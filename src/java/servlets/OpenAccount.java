/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Agency;
import model.Email;
import model.PersonalAccount;
import model.User;
import org.apache.commons.mail.EmailException;
import utilities.PageMessage;
import webService.DebtorActualSituation;

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

        Client client = ClientBuilder.newClient();
        String uri = "http://localhost:8084/DAC-DOR/webresources/debtorSituations?debtorIdentifier=";

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        User user = new User();
        user.setEmail(email);

        user = user.read();
        if (user != null) {
            if (user.verifyPassword(password)) {
                uri += user.getIdentifier();

                Response res = client
                        .target(uri)
                        .request(MediaType.APPLICATION_JSON)
                        .get();
                DebtorActualSituation debtor;

                if (res.getStatus() == 404) {
                    debtor = new DebtorActualSituation();
                    debtor.setIndebt(false);
                } else {
                    debtor = res.readEntity(DebtorActualSituation.class);
                }
                if (!debtor.isIndebt()) {
                    if (user.hasAllInformation()) {
                        PersonalAccount account = new PersonalAccount();
                        account.setUser(user);

                        account = account.readByUserIdAndInativeStatus();

                        if (account.getNumber() != null && !account.getNumber().isEmpty()) {
                            createTokenAndRedirect(account, user, session, response);
                        } else {
                            Agency agency = new Agency();
                            agency.setNumber("12345");
                            agency = agency.readByNumber();

                            account.openAccount(user, agency);
                            account = account.readByNumber();
                            createTokenAndRedirect(account, user, session, response);
                        }
                    } else {
                        this.redirectToRegistration(user, request, response);
                    }
                } else {
                    String page = null;
                    ArrayList<PageMessage> errors = new ArrayList();
                    PageMessage e1 = new PageMessage();
                    e1.setText("Devedores não podem abrir novas contas.");
                    e1.setTitle("Devedor.");
                    e1.setType("danger");
                    errors.add(e1);
                    session.setAttribute("messages", errors);
                    if (((PersonalAccount) session.getAttribute("account")) == null) {
                        page = "index.jsp";
                    } else {
                        page = "accounts.jsp";
                    }
                    response.sendRedirect(page);
                }

            } else {
                String page = null;
                ArrayList<PageMessage> errors = new ArrayList();
                PageMessage e1 = new PageMessage();
                e1.setText("A senha que você digitou está incorreta.");
                e1.setTitle("Senha inválda.");
                e1.setType("danger");
                errors.add(e1);
                session.setAttribute("messages", errors);
                if (((PersonalAccount) session.getAttribute("account")) == null) {
                    page = "index.jsp";
                } else {
                    page = "accounts.jsp";
                }
                response.sendRedirect(page);
            }
        } else {
            String page = null;
            ArrayList<PageMessage> errors = new ArrayList();
            PageMessage e1 = new PageMessage();
            e1.setTitle("Email não cadastrado.");
            e1.setText(" Este email não está cadastrado.");
            e1.setType("danger");
            errors.add(e1);
            session.setAttribute("messages", errors);
            if (((PersonalAccount) session.getAttribute("account")) == null) {
                page = "index.jsp";
            } else {
                page = "accounts.jsp";
            }
            response.sendRedirect(page);
        }

    }

    public void createTokenAndRedirect(PersonalAccount account, User user, HttpSession session, HttpServletResponse response) throws IOException {
        Calendar cal = Calendar.getInstance();
        int mi = cal.get(Calendar.MILLISECOND);
        int number = (int) Math.abs((Math.random() * 1000) * mi);
        String token = Integer.toString(number);

        user.setTokenForAccount(token);
        user.update();

        try {
            Email.sendConfirmation(user.getEmail(), token, account);
        } catch (EmailException ex) {
            internalError(session, response);
        }
        session.setAttribute("id", account.getId());
        response.sendRedirect("putTokenTemp.jsp");
    }

    public void internalError(HttpSession session, HttpServletResponse response) throws IOException {
        ArrayList<PageMessage> errors = new ArrayList();
        String page = null;
        PageMessage e1 = new PageMessage();
        e1.setTitle("Erro interno.");
        e1.setText(" Aconteceu algum erro interno, estaremos solucionando o problema assim que possível.");
        e1.setType("danger");
        errors.add(e1);
        session.setAttribute("messages", errors);
        if (((PersonalAccount) session.getAttribute("account")) == null) {
            page = "index.jsp";
        } else {
            page = "accounts.jsp";
        }
        response.sendRedirect(page);
    }

    public void redirectToRegistration(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        ArrayList<PageMessage> errors = new ArrayList();
        PageMessage e1 = new PageMessage();
        e1.setTitle("Completar cadastro:");
        e1.setText(" Para abrir uma conta, o cadastro precisa estar completo.");
        e1.setType("info");
        errors.add(e1);
        session.setAttribute("messages", errors);
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
