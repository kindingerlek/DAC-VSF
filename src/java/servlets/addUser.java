/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "addUser", urlPatterns = {"/addUser"})
public class addUser extends HttpServlet {

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
        String password = (String) request.getParameter("password");
        String confirmPassword = (String) request.getParameter("confirmPassword");
        User user = new User();
        user.setType(Integer.parseInt((String) request.getParameter("personType")));
        HttpSession session = request.getSession();
        
        if (password.equals(confirmPassword)) {
            switch (user.getType()) {
                case 1:
                    user.setName((String) request.getParameter("name"));
                    user.setEmail((String) request.getParameter("email"));
                    user.setCpf((String) request.getParameter("cpf"));
                    user.setRg((String) request.getParameter("rg"));
                    user.setPassword(password);
                    user.create();
                    break;
                case 2:
                    user.setName((String) request.getParameter("name"));
                    user.setFantasyName((String) request.getParameter("fantasyName"));
                    user.setEmail((String) request.getParameter("email"));
                    user.setCnpj((String) request.getParameter("cnpj"));
                    user.setPassword(password);
                    user.create();
                    break;
                default:
                    //error
            }
            session.setAttribute("user", user);
            response.sendRedirect("registration.jsp");
        } else {
            //error
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
