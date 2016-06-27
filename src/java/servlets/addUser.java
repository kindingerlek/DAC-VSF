/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
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

                    try {
                        user.setCpf((String) request.getParameter("cpf"));
                    } catch (Exception ex) {
                        ArrayList<PageMessage> errors = new ArrayList();
                        PageMessage e1 = new PageMessage();
                        e1.setTitle("CPF incorreto.");
                        e1.setText(" O CPF está incorreto.");
                        e1.setType("danger");
                        errors.add(e1);
                        session.setAttribute("messages", errors);
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                        break;
                    }

                    user.setRg((String) request.getParameter("rg"));
                    user.setPassword(password);
                    try {
                        if (user.create()) {
                            ArrayList<PageMessage> errors = new ArrayList();
                            PageMessage e1 = new PageMessage();
                            e1.setTitle("Parabéns!");
                            e1.setText(" O primeiro passo já foi, agora você precisa completar seu cadastro.");
                            e1.setType("success");
                            errors.add(e1);
                            session.setAttribute("messages", errors);

                            session.setAttribute("user", user);
                            response.sendRedirect("registration.jsp");
                        } else {
                            internalError(session, request, response);
                        }
                    } catch (Exception er) {
                        ArrayList<PageMessage> errors = new ArrayList();
                        PageMessage e1 = new PageMessage();
                        e1.setTitle("CPF já cadastrado.");
                        e1.setText(" O CPF já está cadastrado.");
                        e1.setType("danger");
                        errors.add(e1);
                        session.setAttribute("messages", errors);
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                        break;
                    }
                    break;

                case 2:
                    user.setName((String) request.getParameter("name"));
                    user.setFantasyName((String) request.getParameter("fantasyName"));
                    user.setEmail((String) request.getParameter("email"));

                    try {
                        user.setCnpj((String) request.getParameter("cnpj"));
                    } catch (Exception ex) {
                        ArrayList<PageMessage> errors = new ArrayList();
                        PageMessage e1 = new PageMessage();
                        e1.setTitle("CNPJ incorreto.");
                        e1.setText(" O CNPJ está incorreto.");
                        e1.setType("danger");
                        errors.add(e1);
                        session.setAttribute("messages", errors);
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }

                    user.setPassword(password);
                    try {
                        if (user.create()) {
                            ArrayList<PageMessage> errors = new ArrayList();
                            PageMessage e1 = new PageMessage();
                            e1.setTitle("Parabéns!");
                            e1.setText(" O primeiro passo já foi, agora você precisa completar seu cadastro.");
                            e1.setType("success");
                            errors.add(e1);
                            session.setAttribute("messages", errors);

                            session.setAttribute("user", user);
                            response.sendRedirect("registration.jsp");
                        } else {
                            internalError(session, request, response);
                        }
                    } catch (Exception er) {
                        ArrayList<PageMessage> errors = new ArrayList();
                        PageMessage e1 = new PageMessage();
                        e1.setTitle("CNPJ já cadastrado.");
                        e1.setText(" O CNPJ já está cadastrado.");
                        e1.setType("danger");
                        errors.add(e1);
                        session.setAttribute("messages", errors);
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                        break;
                    }
                    break;
            }

        } else {
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setTitle("Senha incorreta.");
            e1.setText(" As senhas não coincídem.");
            e1.setType("danger");
            errors.add(e1);
            session.setAttribute("messages", errors);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

    }

    public void internalError(HttpSession session, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        ArrayList<PageMessage> errors = new ArrayList();
        PageMessage e1 = new PageMessage();
        e1.setTitle("Erro interno.");
        e1.setText(" Aconteceu algum erro interno, estaremos solucionando o problema assim que possível.");
        e1.setType("danger");
        errors.add(e1);
        session.setAttribute("messages", errors);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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
