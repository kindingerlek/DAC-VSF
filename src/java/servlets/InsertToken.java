/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Email;
import model.User;
import org.apache.commons.mail.EmailException;
import utilities.PageMessage;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "InsertToken", urlPatterns = {"/InsertToken"})
public class InsertToken extends HttpServlet {

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
        User user = (User) session.getAttribute("user");
        
        String amount = request.getParameter("amount");
        String email = user.getEmail();
        String action = request.getParameter("action");
        
        if (amount.equals("")) {
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setText("É obrigatório a inserção de um valor para a transferência.");
            e1.setType("danger");
            errors.add(e1);
            session.setAttribute("messages", errors);
            response.sendRedirect("transaction.jsp");
        }
        
        Calendar cal = Calendar.getInstance();
        int mi = cal.get(Calendar.MILLISECOND);
        int code = (int) Math.abs((Math.random()*1000)*mi);
        
        Calendar cal2 = Calendar.getInstance();
        int h = cal2.get(Calendar.HOUR_OF_DAY);
        int d = cal2.get(Calendar.DAY_OF_MONTH);
        int token = Math.abs((code * code * h) / (d));
        
        try {
            Email.sendToken(email, Integer.toString(token));
        } catch (EmailException ex) {
            internalError(session, response);
        }
        
        request.setAttribute("code", code);
        request.setAttribute("amount", amount);
        request.setAttribute("action", action);
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/insertToken.jsp");
        rd.forward(request, response);
        
    }
    
    public void internalError(HttpSession session, HttpServletResponse response) throws IOException {
        ArrayList<PageMessage> errors = new ArrayList();
        PageMessage e1 = new PageMessage();
        e1.setTitle("Erro interno."); 
        e1.setText(" Aconteceu algum erro interno, estaremos solucionando o problema assim que possível.");
        e1.setType("danger");
        errors.add(e1);
        session.setAttribute("messages", errors);
        response.sendRedirect("home.jsp");
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
