/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
import model.Product;
import model.Static1;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Statistic", urlPatterns = {"/statistic"})
public class Statistic extends HttpServlet {

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
            out.println("<title>Servlet Statistic</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Statistic at " + request.getContextPath() + "</h1>");
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
        OrderDAO dao = new OrderDAO();
        //get page index
        String index = request.getParameter("page");
        int indexPage = 0;
        if(index == null){
            indexPage = 1;
        }
        else{
            indexPage = Integer.parseInt(index);
        }
        
        int OrderAll = dao.TongOrder();
        request.setAttribute("allOrder", OrderAll);
        int quantity = dao.TongSPselled();
        request.setAttribute("Allquantiy", quantity);
        int money = dao.PriceperDay();
        request.setAttribute("money", money);
        List<Static1> list = dao.slsellbyPid();
        request.setAttribute("staticP", list);
        ProductDAO pdao = new ProductDAO();
//        List<Product> listP = pdao.getAllSp();
        //paging
        List<Product> listP = pdao.paging(indexPage);
        int totalPage = pdao.totalPage();
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listP", listP);
        request.getRequestDispatcher("Static.jsp").forward(request, response);
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
