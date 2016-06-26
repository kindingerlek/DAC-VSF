/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
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
@WebServlet(name = "Deposit", urlPatterns = {"/Deposit"})
public class Deposit extends HttpServlet {

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
                Double amount = 0.0;
                String input = request.getParameter("amount");
                if (input.equals("")) {
                    amount = 0.0;
                } else {
                    Pattern regex = Pattern.compile("\\d[\\d,\\.]+");
                    Matcher finder = regex.matcher(input);
                    if (finder.find()) {
                        try {
                            System.out.println(input);
                            System.out.println(finder.group(0));
                            amount = Double.parseDouble(finder.group(0).replaceAll(",", "."));
                        } catch (NumberFormatException e) {
                            amount = 0.0;
                        }
                    }
                }
                account.deposit(amount, "Depósito");
                ArrayList<PageMessage> errors = new ArrayList();
                PageMessage e1 = new PageMessage();
                e1.setTitle("Deposito realizado com sucesso.");
                e1.setType("success");
                errors.add(e1);
                session.setAttribute("messages", errors);
                response.sendRedirect("deposit.jsp");
            } else {
                ArrayList<PageMessage> errors = new ArrayList();
                PageMessage e1 = new PageMessage();
                e1.setText("A senha que você digitou está incorreta.");
                e1.setTitle(" Senha inválda.");
                e1.setType("danger");
                errors.add(e1);
                session.setAttribute("messages", errors);
                response.sendRedirect("deposit.jsp");
            }
        } else {
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setText("O token que você digitou está incorreto.");
            e1.setTitle(" Token inváldo.");
            e1.setType("danger");
            errors.add(e1);
            session.setAttribute("messages", errors);
            response.sendRedirect("deposit.jsp");
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
