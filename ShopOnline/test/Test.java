
import dal.FeedbackDAO;
import dal.OrderDAO;
import dal.ProductDAO;
import dal.UserProfileDAO;
import java.util.ArrayList;
import java.util.List;
import model.Feedback;
import model.Order;
import model.Product;
import model.UserProfile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Test {
    public static void main(String[] args) {
        UserProfileDAO dao = new UserProfileDAO();
        UserProfile u =dao.getUserByUsername("chanmat");
        Boolean z = dao.exisProfile("chanmat", "chanmat@gmail.com");
        ProductDAO pdao = new ProductDAO();
        Product p = pdao.getProductbyID(1);
        
        
        OrderDAO odao = new OrderDAO();
        List<Order> list1 = odao.getOrderbyStatus("a", "");
        //List<Order> list2 = odao.getOrderbyDate("2022-06-19", "2022-06-19");
        String c = pdao.getnameSP(10);
        FeedbackDAO fbdao = new FeedbackDAO();
//        List<Feedback> fblist = fbdao.fb_Product(10);
//            for (Feedback cd : fblist) {
//                System.out.println(cd);
//        }
//            
//            System.out.println(fbdao.avgRating());
        
        double x = (double)pdao.totalProduct()/9;
        System.out.println(x);
        List<Product> lpb = pdao.pagingProduct(0);
        for (Product t : lpb) {
            System.out.println(t);
        }
        
        
        
    }
}
