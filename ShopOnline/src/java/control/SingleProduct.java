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
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Feedback;
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SingleProduct", urlPatterns = {"/product"})
public class SingleProduct extends HttpServlet {

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
        String id_r = request.getParameter("pid");
        ProductDAO pdao = new ProductDAO();
        FeedbackDAO fbdao = new FeedbackDAO();
        try {
            int id = Integer.parseInt(id_r);
            Product p = pdao.getProductbyID(id);
            request.setAttribute("sanphamP", p);
            List<Feedback> fblist = fbdao.fb_Product(id);
            request.setAttribute("listfb", fblist);
            int review=0;           
            int rate[] = new int[5];                  
            double pr1,pr2,pr3,pr4,pr5;
            for (Feedback t : fblist) {
                if(t.isStatus()){
                    review++;
                }else{
      
                }
                if(t.isStatus()){
                    if(t.getStar() == 5){      // tính số feedback 5 sao
                    rate[0]++;
                }else if(t.getStar() == 4){// tính số feedback 4 sao
                    rate[1]++;
                }else if(t.getStar() == 3){// tính số feedback 3 sao
                    rate[2]++;
                }else if(t.getStar() == 2){// tính số feedback 2 sao
                    rate[3]++;
                }else if(t.getStar() == 1){// tính số feedback 1 sao
                    rate[4]++;
                }
                }
                
            }
            pr5 = (double)100*rate[0]/review;
            pr5 = (double)Math.round(pr5*100)/100;
            pr4 = (double)100*rate[1]/review;
            pr4 = (double)Math.round(pr4*100)/100;
            pr3 = (double)100*rate[2]/review;
            pr3 = (double)Math.round(pr3*100)/100;
            pr2 = (double)100*rate[3]/review;
            pr2 = (double)Math.round(pr2*100)/100;
            pr1 = (double)100*rate[4]/review;
            pr1 = (double)Math.round(pr1*100)/100;
            request.setAttribute("review", review);
            request.setAttribute("s5", rate[0]);
            request.setAttribute("s4", rate[1]);
            request.setAttribute("s3", rate[2]);
            request.setAttribute("s2", rate[3]);
            request.setAttribute("s1", rate[4]);
            request.setAttribute("pr1", pr1);
            request.setAttribute("pr2", pr2);
            request.setAttribute("pr3", pr3);
            request.setAttribute("pr4", pr4);
            request.setAttribute("pr5", pr5);
            double rate_m = fbdao.avgRating(id);
            request.setAttribute("ratem", rate_m);
            OrderDAO odao = new OrderDAO();
            int quantity = odao.productAllquantity(id_r);
            request.setAttribute("quan", quantity);
            request.getRequestDispatcher("proSingle.jsp").forward(request, response);

        } catch (Exception e) {
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
