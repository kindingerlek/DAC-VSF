/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import utilities.PageMessage;

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

        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        User user = new User();
        user.setEmail(email);
        user = user.read();
        int type = user.getType();
        Double income = null;
        ArrayList<PageMessage> messages = new ArrayList();
        PageMessage pm = new PageMessage();
        String input = request.getParameter("income");
        if (input.equals("")) {
            income = 0.0;
        } else {
            Pattern regex = Pattern.compile("\\d[\\d,\\.]+");
            Matcher finder = regex.matcher(input);
            if (finder.find()) {
                try {
                    System.out.println(input);
                    System.out.println(finder.group(0));
                    income = Double.parseDouble(finder.group(0).replaceAll(",", "."));
                } catch (NumberFormatException e) {
                    income = 0.0;
                }
            }
        }
        String action = request.getParameter("action");
        switch (type) {
            case 1:
                user.setName(request.getParameter("name"));
                try {
                    user.setCpf(request.getParameter("cpf"));
                } catch (Exception ex) {
                    ArrayList<PageMessage> errors = new ArrayList();
                    PageMessage e1 = new PageMessage();
                    e1.setTitle("CPF incorreto.");
                    e1.setText(" O CPF está incorreto.");
                    e1.setType("danger");
                    errors.add(e1);
                    session.setAttribute("messages", errors);
                    response.sendRedirect("index.jsp");
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
                user.setIncome(income);
                System.out.println(user.getIncome());
                user.update();
                if (user.hasAllInformationPF()) {
                    pm.setTitle("Cadastro completo.");
                    pm.setType("sucess");
                    messages.add(pm);
                    session.setAttribute("messages", messages);
                } else {
                    pm.setTitle("Cadastro salvo!");
                    pm.setText("Os dados do seu cadastro foram salvos,"
                            + " mas precisamos que você termine seu cadastro"
                            + " antes de criar uma conta.");
                    pm.setType("sucess");
                    messages.add(pm);
                    session.setAttribute("messages", messages);
                }
                if (action != null) {
                    RequestDispatcher rd = request.getRequestDispatcher(action);
                    rd.forward(request, response);
                } else {
                    response.sendRedirect("index.jsp");
                }
                break;
            case 2:
                user.setName(request.getParameter("name"));
                try {
                    user.setCnpj(request.getParameter("cnpj"));
                } catch (Exception ex) {
                    ArrayList<PageMessage> errors = new ArrayList();
                    PageMessage e1 = new PageMessage();
                    e1.setTitle("CNPJ incorreto.");
                    e1.setText(" O CNPJ está incorreto.");
                    e1.setType("danger");
                    errors.add(e1);
                    session.setAttribute("messages", errors);
                    response.sendRedirect("index.jsp");
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
                user.setIncome(income);

                user.update();
                if (user.hasAllInformationPJ()) {
                    pm.setTitle("Cadastro completo.");
                    pm.setType("sucess");
                    messages.add(pm);
                    session.setAttribute("messages", messages);
                } else {
                    pm.setTitle("Cadastro salvo!");
                    pm.setText("Os dados do seu cadastro foram salvos,"
                            + " mas precisamos que você termine seu cadastro"
                            + " antes de criar uma conta.");
                    pm.setType("sucess");
                    messages.add(pm);
                    session.setAttribute("messages", messages);
                }
                if (action != null) {
                    RequestDispatcher rd = request.getRequestDispatcher(action);
                    rd.forward(request, response);
                } else {
                    response.sendRedirect("index.jsp");
                }
                break;
            default:
                internalError(session, response);
        }
    }

    public void internalError(HttpSession session, HttpServletResponse response) throws IOException {
        ArrayList<PageMessage> errors = new ArrayList();
        PageMessage e1 = new PageMessage();
        e1.setTitle("Erro interno.");
        e1.setText(" Aconteceu algum erro interno, estaremos solucionando o problema assim que possível.");
        e1.setType("danger");
        errors.add(e1);
        session.setAttribute("messages", errors);
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
