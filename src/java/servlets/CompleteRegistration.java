/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "CompletRegistration", urlPatterns = {"/CompleteRegistration"})
public class CompleteRegistration extends HttpServlet {

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
        User user = new User();
        user.setEmail(email);
        user = user.read();
        int type = user.getType();
        switch (type) {
            case 1:
                user.setName(request.getParameter("name"));
                try {
                    user.setCpf(request.getParameter("cpf"));
                } catch (Exception ex) {
                    System.out.println("error cpf invalido");
                }
                user.setRg(request.getParameter("rg"));
                user.setZipCode(request.getParameter("zipCode"));
                user.setCity(request.getParameter("city"));
                user.setState(request.getParameter("state"));
                user.setNeighborhood(request.getParameter("neighborhood"));
                user.setStreet(request.getParameter("street"));
                user.setComplement(request.getParameter("complement"));
                user.setLandPhone(request.getParameter("landphone"));
                user.setCellPhone(request.getParameter("cellphone"));
                user.setAddressNumber(request.getParameter("addressNumber"));
                user.setIncome(Double.parseDouble(request.getParameter("income")));
                user.update();
                break;

            case 2:
                user.setName(request.getParameter("name"));
                try {
                    user.setCnpj(request.getParameter("cnpj"));
                } catch (Exception ex) {
                    System.out.println("error cnjp invalido");
                }
                user.setFantasyName(request.getParameter("fantasyName"));
                user.setZipCode(request.getParameter("zipCode"));
                user.setCity(request.getParameter("city"));
                user.setState(request.getParameter("state"));
                user.setNeighborhood(request.getParameter("neighborhood"));
                user.setStreet(request.getParameter("street"));
                user.setComplement(request.getParameter("complement"));
                user.setLandPhone(request.getParameter("landphone"));
                user.setCellPhone(request.getParameter("cellphone"));
                user.setAddressNumber(request.getParameter("addressNumber"));
                user.setIncome(Double.parseDouble(request.getParameter("income")));
                
                user.update();
                break;

            default:
            //error
        }

        response.sendRedirect("index.jsp");
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
