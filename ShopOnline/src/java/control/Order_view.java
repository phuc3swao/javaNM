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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Feedback;
import model.Order;
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Order_view", urlPatterns = {"/orderview"})
public class Order_view extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Order_view</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Order_view at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc");
        if (user == null) {
            response.sendRedirect("Login.jsp");
        } else {
            OrderDAO odao = new OrderDAO();
            ProductDAO ddao = new ProductDAO();
            FeedbackDAO fbdao = new FeedbackDAO();
            List<Order> listO = odao.CustomerOrder_Date(user.getUser(), null, null);
            List<Product> listP = ddao.getAllSp();
            List<Feedback> listfb = fbdao.Customerfb(user.getUser());
            request.setAttribute("listFb", listfb);
            request.setAttribute("listO", listO);
            request.setAttribute("listP", listP);
            request.getRequestDispatcher("ViewOrder.jsp").forward(request, response);
        }
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
        String bdate = request.getParameter("bdate");
        String edate = request.getParameter("edate");
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc");
        OrderDAO odao = new OrderDAO();
        List<Order> listO = odao.CustomerOrder_Date(user.getUser(), bdate, edate);
        ProductDAO ddao = new ProductDAO();
        List<Product> listP = ddao.getAllSp();
        request.setAttribute("listO", listO);
        request.setAttribute("listP", listP);
        request.setAttribute("bdate", bdate);
        request.setAttribute("edate", edate);
        request.getRequestDispatcher("ViewOrder.jsp").forward(request, response);
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
