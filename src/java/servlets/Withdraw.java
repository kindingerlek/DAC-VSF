/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Withdraw", urlPatterns = {"/Withdraw"})
public class Withdraw extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        Integer code = Integer.parseInt(request.getParameter("code"));
        Integer token = Integer.parseInt(request.getParameter("token"));
        String password = request.getParameter("password");
        PersonalAccount account = (PersonalAccount) session.getAttribute("account");

        Calendar cal2 = Calendar.getInstance();
        int h = cal2.get(Calendar.HOUR_OF_DAY);
        int d = cal2.get(Calendar.DAY_OF_MONTH);
        int rightToken = Math.abs((code * code * h) / (d));

        if (token == rightToken) {
            if (account.verifyPassword(password)) {
                Double amount = Double.parseDouble(request.getParameter("amount"));

                try {
                    account.withdraw(amount);
                    ArrayList<PageMessage> errors = new ArrayList();
                    PageMessage e1 = new PageMessage();
                    e1.setTitle("Saque realizado com sucesso.");
                    e1.setType("success");
                    errors.add(e1);
                    session.setAttribute("messages", errors);
                    response.sendRedirect("withdraw.jsp");
                } catch (Exception ex) {
                    ArrayList<PageMessage> errors = new ArrayList();
                    PageMessage e1 = new PageMessage();
                    switch (ex.getMessage()) {
                        case "inadequate limit":
                            e1.setText("Você não tem limite o suficiente para esta transação.");
                            e1.setTitle(" Limite insuficiente.");
                            e1.setType("danger");
                            errors.add(e1);
                            session.setAttribute("messages", errors);
                            response.sendRedirect("withdraw.jsp");
                            break;

                        case "user unsupported":
                            e1.setText("Pessoa Física.");
                            e1.setTitle(" Somente Pessoa Jurídica tem acesso a este recurso.");
                            e1.setType("danger");
                            errors.add(e1);
                            session.setAttribute("messages", errors);
                            response.sendRedirect("home.jsp");
                            break;
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
                response.sendRedirect("withdraw.jsp");
            }

        } else {
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setText("O token que você digitou está incorreto.");
            e1.setTitle(" Token inváldo.");
            e1.setType("danger");
            errors.add(e1);
            session.setAttribute("messages", errors);
            response.sendRedirect("withdraw.jsp");
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
