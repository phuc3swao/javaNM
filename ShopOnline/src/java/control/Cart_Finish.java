/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dal.CartDAO;
import dal.DiscountDAO;
import dal.ProductDAO;
import dal.UserProfileDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.Discount;
import model.Product;
import model.UserProfile;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Cart_Finish", urlPatterns = {"/cart_finish"})
public class Cart_Finish extends HttpServlet {

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
            out.println("<title>Servlet Cart_Finish</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cart_Finish at " + request.getContextPath() + "</h1>");
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
        String code = request.getParameter("code");
        DiscountDAO dd = new DiscountDAO();
        if (dd.checkIfDiscountExist(code)) {
            Discount discount = dd.getDiscount(code);
            if (!discount.isStatus()) {
                CartDAO cdao = new CartDAO();
                List<Integer> pidlist = cdao.spOfUser(acc.getUser());
                List<Product> listP = new ArrayList<>();
                ProductDAO ddao = new ProductDAO();
                double TT = 0;
                for (Integer c : pidlist) {
                    Product a = ddao.getProductbyID(c);
                    TT = TT + a.getPrice();
                    listP.add(a);
                }
                request.setAttribute("TT", TT);
                request.setAttribute("listP", listP);
                request.setAttribute("lfail", "Coupon not available!");
                request.getRequestDispatcher("Cart.jsp").forward(request, response);
            } else {
                CartDAO cdao = new CartDAO();
                List<Cart> clist = cdao.getAllCartUser(acc.getUser());
                for (Cart o : clist) {
                    String qname = "quantity" + o.getPid();
                    String tname = "tongtien" + o.getPid();
                    try {
                        int quantity = Integer.parseInt(request.getParameter(qname));
                        double tongtien = Double.parseDouble(request.getParameter(tname));
                        Date date = Date.valueOf(LocalDate.now());
                        cdao.quantity_price(acc.getUser(), o.getPid(), quantity, tongtien, date);

                    } catch (NumberFormatException e) {
                    }
                }
                UserProfileDAO updao = new UserProfileDAO();
                UserProfile user = updao.getUserByUsername(acc.getUser());
                request.setAttribute("user", user);
                String x = request.getParameter("xxx");

                double fPrice = Double.parseDouble(x) - discount.getValue();
                request.setAttribute("discount", discount);
                request.setAttribute("fPrice", fPrice);

                request.setAttribute("TongTien", x);
                request.getRequestDispatcher("Order.jsp").forward(request, response);
            }
        } else {
            if (!code.isEmpty()) {
                CartDAO cdao = new CartDAO();
                List<Integer> pidlist = cdao.spOfUser(acc.getUser());
                List<Product> listP = new ArrayList<>();
                ProductDAO ddao = new ProductDAO();
                double TT = 0;
                for (Integer c : pidlist) {
                    Product a = ddao.getProductbyID(c);
                    TT = TT + a.getPrice();
                    listP.add(a);
                }
                request.setAttribute("TT", TT);
                request.setAttribute("listP", listP);
                request.setAttribute("lfail", "Coupon not available!");
                request.getRequestDispatcher("Cart.jsp").forward(request, response);
            } else {
                CartDAO cdao = new CartDAO();
                List<Cart> clist = cdao.getAllCartUser(acc.getUser());
                for (Cart o : clist) {
                    String qname = "quantity" + o.getPid();
                    String tname = "tongtien" + o.getPid();
                    try {
                        int quantity = Integer.parseInt(request.getParameter(qname));
                        double tongtien = Double.parseDouble(request.getParameter(tname));
                        Date date = Date.valueOf(LocalDate.now());
                        cdao.quantity_price(acc.getUser(), o.getPid(), quantity, tongtien, date);

                    } catch (NumberFormatException e) {
                    }
                }
                UserProfileDAO updao = new UserProfileDAO();
                UserProfile user = updao.getUserByUsername(acc.getUser());
                request.setAttribute("user", user);
                String x = request.getParameter("xxx");

                double fPrice = Double.parseDouble(x);

                request.setAttribute("fPrice", fPrice);

                request.setAttribute("TongTien", x);
                request.getRequestDispatcher("Order.jsp").forward(request, response);
            }
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
