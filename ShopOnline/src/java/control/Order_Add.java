/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dal.CartDAO;
import dal.DiscountDAO;
import dal.OrderDAO;
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
import model.Cart;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Order_Add", urlPatterns = {"/order_add"})
public class Order_Add extends HttpServlet {

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
            out.println("<title>Servlet Order_Add</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Order_Add at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        DiscountDAO dd = new DiscountDAO();
        dd.upDiscountStatusByCode(request.getParameter("code"));
        
        String customer = request.getParameter("customer");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");       
        try {
            String height = request.getParameter("height");
            String weight = request.getParameter("weight");
            CartDAO cdao = new CartDAO();
            OrderDAO odao = new OrderDAO();
            int maxId = odao.getMaxId() + 1;
            List<Cart> cartl = cdao.getAllCartUser(acc.getUser());
            for (Cart o : cartl) {
                odao.addOrder(
                        maxId,
                        o.getPid(), 
                        acc.getUser(), 
                        customer, 
                        address, 
                        height, 
                        weight, 
                        "Nhận đơn", 
                        o.getDate(), 
                        o.getQuantity(), 
                        o.getPrice(), 
                        phone);
            }
            cdao.deleteCart(acc.getUser());
            response.sendRedirect("Thank.jsp");
        } catch (NumberFormatException e) {
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
