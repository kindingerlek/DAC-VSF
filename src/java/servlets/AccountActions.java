/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PersonalAccount;
import model.User;
import utilities.PageMessage;

/**
 *
 * @author Mei (Jessyka Alycia Amaral)
 */
@WebServlet(name = "AccountActions", urlPatterns = {"/AccountActions"})
public class AccountActions extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PersonalAccount account = (PersonalAccount) session.getAttribute("account");
        String accountNumber = request.getParameter("number");
        String password = request.getParameter("password");
        if (accountNumber == null || password == null) {
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setTitle("Dados inválidos.");
            e1.setText("Não foram digitados os dados necessários");
            e1.setType("danger");
            errors.add(e1);
            session.setAttribute("messages", errors);
            RequestDispatcher rd = request.getRequestDispatcher("accounts.jsp");
            rd.forward(request, response);
        }
        PersonalAccount accountToChange = null;
        for (PersonalAccount acc : user.getActiveAccounts()) {
            if (acc.getNumber().equals(accountNumber)) {
                accountToChange = acc;
                break;
            }
        }
        if (accountToChange == null) {
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setTitle("Dados inválidos.");
            e1.setText("Não foi encontrada uma conta com esse número.");
            e1.setType("danger");
            errors.add(e1);
            session.setAttribute("messages", errors);
            RequestDispatcher rd = request.getRequestDispatcher("accounts.jsp");
            rd.forward(request, response);
        }
        if (accountToChange.verifyPassword(password)) {
            session.setAttribute("account", accountToChange);
            if (request.getParameter("action").equals("close")) {
                RequestDispatcher rd = request.getRequestDispatcher("CloseAccount");
                rd.forward(request, response);
            } else if (request.getParameter("action").equals("change")) {
                ArrayList<PageMessage> errors = new ArrayList();
                PageMessage e1 = new PageMessage();
                e1.setTitle("Conta ativa: ");
                e1.setText("Sua conta ativa agora é " + accountToChange.getNumber() + ".");
                e1.setType("success");
                errors.add(e1);
                session.setAttribute("messages", errors);
                RequestDispatcher rd = request.getRequestDispatcher("accounts.jsp");
                rd.forward(request, response);
            }
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
