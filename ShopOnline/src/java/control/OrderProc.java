/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dal.OrderDAO;
import dal.OrderProcDAO;
import dal.StaffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Order;
import model.Staff;

/**
 *
 * @author Admin
 */
@WebServlet(name = "OrderProc", urlPatterns = {"/orderproc"})
public class OrderProc extends HttpServlet {

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
            out.println("<title>Servlet OrderProc</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderProc at " + request.getContextPath() + "</h1>");
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
        String oid = request.getParameter("oid");
        StaffDAO sdao = new StaffDAO();
        List<Staff> listS = sdao.getAllStaff();
        request.setAttribute("listS", listS);
        request.setAttribute("donhang", oid);
        request.getRequestDispatcher("Order_divide.jsp").forward(request, response);
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
        String oid_r = request.getParameter("oid");
        String sid_r = request.getParameter("staff");
        OrderDAO odao = new OrderDAO();
        StaffDAO sdao = new StaffDAO();
        OrderProcDAO opdao = new OrderProcDAO();
        try {
            Order o = odao.getOrderbyOid(Integer.parseInt(oid_r));
            int idStaff = Integer.parseInt(sid_r);
            Date date = Date.valueOf(LocalDate.now());
            opdao.insertOP(o.getOid(), date, idStaff, "Đang giao");
            odao.udpateStatus(o.getOid(), "Đã giao việc");
            
        } catch (Exception e) {
        }
        response.sendRedirect("order_all");
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
