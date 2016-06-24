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

@WebServlet(name = "closeAccount", urlPatterns = {"/closeAccount"})
public class closeAccount extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            
            PersonalAccount account = (PersonalAccount) session.getAttribute("account");
            User user = account.getUser();
            ArrayList<PageMessage> messages = new ArrayList();
            
            
            //
            int countAccounts = user.getAccountList().size();

            if (account.close()) {
                RequestDispatcher rd = request.getRequestDispatcher("Loggout");

                if(countAccounts == 0)
                    user.setStatus("inactive");
                
                messages.add(new PageMessage("success", "Okdok!", "Sua conta foi deletada"));
                session.setAttribute("messages", messages);

                rd.forward(request, response);
            }
            
            messages.add(new PageMessage("danger", "Ops!", "Não foi possível apagar sua conta.<br>"
                    + "Certifique-se que a conta possui saldo possito para "
                    + "então completar a ação."));
            
            session.setAttribute("messages", messages);
            
            response.sendRedirect(request.getHeader("Referer"));
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
