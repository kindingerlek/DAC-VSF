/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.AgencyDAO;
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
import model.Agency;
import model.PersonalAccount;
import utilities.PageMessage;

/**
 *
 * @author Mei (Jessyka Alycia Amaral)
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        String agencyNumber = request.getParameter("agency_input");
        String accountNumber = request.getParameter("account_input");
        String password = request.getParameter("password_input");
        if (agencyNumber == null || accountNumber == null || password == null) {
            String message = "Campo de agencia, conta ou senha vazios.";
            String title = "Dados incompletos";
            String type = "danger";
            PageMessage pm = new PageMessage(type, title, message);
            ArrayList<PageMessage> messages = new ArrayList<>();
            messages.add(pm);
            session.setAttribute("messages", messages);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        PersonalAccount account = new PersonalAccount();
        account.setNumber(accountNumber);
        account = account.readByNumber();
        if (account == null) {
            String message = "Conta não encontrada.";
            String title = "Dados incorretos";
            String type = "danger";
            PageMessage pm = new PageMessage(type, title, message);
            ArrayList<PageMessage> messages = new ArrayList<>();
            messages.add(pm);
            session.setAttribute("messages", messages);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } 
        if (!account.getStatus().equals("Fechada")) {
            if (account.verifyPassword(password)) {
                if (account.getAgency().getNumber().equals(agencyNumber)) {
                    session.setAttribute("account", account);
                    session.setAttribute("user", account.getUser());
                    RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                    rd.forward(request, response);
                } else {
                    String message = "Não foi encontrada uma conta com essa agência.";
                    String title = "Dados incorretos";
                    String type = "danger";
                    PageMessage pm = new PageMessage(type, title, message);
                    ArrayList<PageMessage> messages = new ArrayList<>();
                    messages.add(pm);
                    session.setAttribute("messages", messages);
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            } else {
                String message = "Conta ou senha incorreta.";
                String title = "Dados incorretos";
                String type = "danger";
                PageMessage pm = new PageMessage(type, title, message);
                ArrayList<PageMessage> messages = new ArrayList<>();
                messages.add(pm);
                session.setAttribute("messages", messages);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } else {
            String title = "Conta Fechada.";
            String type = "danger";
            PageMessage pm = new PageMessage(type, title, "");
            ArrayList<PageMessage> messages = new ArrayList<>();
            messages.add(pm);
            session.setAttribute("messages", messages);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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
