/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PersonalAccount;
import utilities.PageMessage;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "Transfer", urlPatterns = {"/Transfer"})
public class Transfer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer code = Integer.parseInt(request.getParameter("code"));
        Integer token = Integer.parseInt(request.getParameter("token"));
        Calendar cal2 = Calendar.getInstance();
        int h = cal2.get(Calendar.HOUR_OF_DAY);
        int d = cal2.get(Calendar.DAY_OF_MONTH);
        int rightToken = Math.abs((code * code * h) / (d));

        HttpSession session = request.getSession();
        PersonalAccount account = (PersonalAccount) session.getAttribute("account");
        int destinationType = Integer.parseInt(request.getParameter("destinationType"));
        Double ammount = 0.0;
        String input = request.getParameter("amount");
        if (input.equals("")) {
            ammount = 0.0;
        } else {
            Pattern regex = Pattern.compile("\\d[\\d,\\.]+");
            Matcher finder = regex.matcher(input);
            if (finder.find()) {
                try {
                    System.out.println(input);
                    System.out.println(finder.group(0));
                    ammount = Double.parseDouble(finder.group(0).replaceAll(",", "."));
                } catch (NumberFormatException e) {
                    ammount = 0.0;
                }
            }
        }
        String agencyToSend = request.getParameter("other_account_agency");
        String password = request.getParameter("password");
        String identifier = request.getParameter("identifier");

        if (token == rightToken) {
            if (account.verifyPassword(password)) {
                PersonalAccount accountToSend = new PersonalAccount();
                ArrayList<PageMessage> errors = null;
                PageMessage e1 = null;
                switch (destinationType) {
                    case 1:
                        //minhas contas
                        accountToSend.setNumber(request.getParameter("same_account_number"));
                        accountToSend = accountToSend.readByNumber();
                        makeTransfer(accountToSend, account, ammount, session, response);
                        errors = new ArrayList();
                        e1 = new PageMessage();
                        e1.setText("Transferência realizada com sucesso.");
                        e1.setType("success");
                        errors.add(e1);
                        session.setAttribute("messages", errors);
                        response.sendRedirect("transaction.jsp");
                        break;

                    case 2:
                        accountToSend.setNumber(request.getParameter("other_account_number"));
                        accountToSend = accountToSend.readByNumber();
                        System.out.println(accountToSend + " account o que tem");
                        if (accountToSend == null) {
                            errors = new ArrayList();
                            e1 = new PageMessage();
                            e1.setText("Conta não encontrada.");
                            e1.setType("danger");
                            errors.add(e1);
                            session.setAttribute("messages", errors);
                            response.sendRedirect("transaction.jsp");
                        } else if (accountToSend.getAgency().getNumber().equals(agencyToSend)
                                && accountToSend.getUser().getIdentifier().equals(identifier)) {
                            makeTransfer(accountToSend, account, ammount, session, response);
                            errors = new ArrayList();
                            e1 = new PageMessage();
                            e1.setText("Transferência realizada com sucesso.");
                            e1.setType("success");
                            errors.add(e1);
                            session.setAttribute("messages", errors);
                            response.sendRedirect("transaction.jsp");
                        } else {
                            errors = new ArrayList();
                            e1 = new PageMessage();
                            e1.setTitle("Dados de conta inconsistentes.");
                            e1.setType("danger");
                            errors.add(e1);
                            session.setAttribute("messages", errors);
                            response.sendRedirect("transaction.jsp");
                        }

                }
            } else {
                ArrayList<PageMessage> errors = new ArrayList();
                PageMessage e1 = new PageMessage();
                e1.setText("A senha que você digitou está incorreta.");
                e1.setTitle(" Senha inválda.");
                e1.setType("danger");
                errors.add(e1);
                session.setAttribute("messages", errors);
                response.sendRedirect("transaction.jsp");
            }
        } else {
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setText("O token que você digitou está incorreto.");
            e1.setTitle(" Token inváldo.");
            e1.setType("danger");
            errors.add(e1);
            session.setAttribute("messages", errors);
            response.sendRedirect("transaction.jsp");
        }

    }

    public boolean makeTransfer(PersonalAccount accountToSend, PersonalAccount account, Double ammount, HttpSession session, HttpServletResponse response) throws IOException {
        if (accountToSend.getNumber().equals(account.getNumber())) {
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setText("Você não pode fazer uma transferência para a mesma conta.");
            e1.setType("danger");
            errors.add(e1);
            session.setAttribute("messages", errors);
            response.sendRedirect("transaction.jsp");
            return false;
        }

        try {
            account.transfer(accountToSend, ammount);
            return true;
        } catch (Exception ex) {
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setText("Você não tem limite o suficiente para esta transação.");
            e1.setTitle(" Limite insuficiente.");
            e1.setType("danger");
            errors.add(e1);
            session.setAttribute("messages", errors);
            response.sendRedirect("transaction.jsp");
            return false;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
