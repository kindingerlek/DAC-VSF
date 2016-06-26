/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
 * @author Bruno
 */
@WebServlet(name = "CloseAccount", urlPatterns = {"/CloseAccount"})
public class CloseAccount extends HttpServlet {

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

        HttpSession session = request.getSession();
        PersonalAccount account = (PersonalAccount) session.getAttribute("account");
        account.closeAccount();

        User user = (User) session.getAttribute("user");
        List<PersonalAccount> activeAccounts = user.getActiveAccounts();

        if (activeAccounts == null || activeAccounts.size() == 0) {
            user.setStatus("Inativo");
            user.update();
            
            session.setAttribute("user", null);
            session.setAttribute("account", null);
            
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setTitle("Conta fechada com sucesso.");
            e1.setType("success");
            errors.add(e1);
            session.setAttribute("messages", errors);
            response.sendRedirect("index.jsp");
        } else {
            session.setAttribute("account", activeAccounts.get(0));
            
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setTitle("Conta fechada com sucesso.");
            e1.setText(" Você agora está logado na conta "+activeAccounts.get(0).getNumber());
            e1.setType("success");
            errors.add(e1);
            session.setAttribute("messages", errors);
            response.sendRedirect("accounts.jsp");
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
