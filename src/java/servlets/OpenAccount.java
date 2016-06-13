/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Agency;
import model.Email;
import model.PersonalAccount;
import model.User;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "OpenAccount", urlPatterns = {"/OpenAccount"})
public class OpenAccount extends HttpServlet {

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

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        User user = new User();
        user.setEmail(email);

        user = user.read();
        if (user.getPassword() != null && user.getPassword().equals(password)) {
            switch (user.getType()) {
                case 1: {
                    if (user.hasAllInformationPF()) {
                        PersonalAccount account = new PersonalAccount();
                        Agency agency = new Agency();
                        agency.setNumber("12345");
                        agency = agency.readByNumber();
                        account.openAccount(user, agency);
                        account = account.readByNumber();
                        int number = Integer.parseInt(account.getNumber().replace("-",""));
                        number =+ 3987 - 98 + 98765;
                        String token = Integer.toString(number);
                        try {
                            Email.sendEmail(user.getEmail(), token);
                        } catch (EmailException ex) {
                            System.out.println("Error: enviar email OpenAccount");
                        }
                        System.out.println(account.getId());
                        session.setAttribute("id", account.getId());
                        response.sendRedirect("putTokenTemp.jsp");
                    } else {
                        this.redirectToRegistration(user, request, response);
                    }
                    break;
                }
            }
        }

    }

    public void redirectToRegistration(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        response.sendRedirect("registration.jsp");
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
