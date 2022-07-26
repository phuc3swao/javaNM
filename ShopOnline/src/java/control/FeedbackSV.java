/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dal.FeedbackDAO;
import dal.OrderDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Admin
 */
@WebServlet(name = "FeedbackSV", urlPatterns = {"/feedback"})
public class FeedbackSV extends HttpServlet {

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
        doGet(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String oid = request.getParameter("oid");
        String pid = request.getParameter("pid");
        request.setAttribute("oid", oid);
        request.setAttribute("pid", pid);
        OrderDAO odao = new OrderDAO();
        ProductDAO pdao = new ProductDAO();
        String nameSP = pdao.getnameSP(Integer.parseInt(pid));
        request.setAttribute("nameSP", nameSP);
        String image = pdao.getImageSP(Integer.parseInt(pid));
        request.setAttribute("image", image);
        request.getRequestDispatcher("Feedback.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        String oid = request.getParameter("oid");
        String pid = request.getParameter("pid");
        String star = request.getParameter("rate");
        String comment = request.getParameter("comment");
        String date = Date.valueOf(LocalDate.now()).toString();
        FeedbackDAO fbdao = new FeedbackDAO();
        fbdao.insertFeedback(oid, pid, star, comment, acc.getUser(),date);
        OrderDAO odao = new OrderDAO();
        odao.setStatus(oid, pid, 1);
        response.sendRedirect("orderview");

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
