/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cart;

/**
 *
 * @author Admin
 */
public class CartDAO extends DBContext{
//thêm user và pid vào cart    
    public void insertItem(String user, int pid, String quantity){
        String sql ="insert into Cart(account,pid,quantity) values(?,?,"+quantity+")";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setInt(2, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }
// lấy item bằng user và pid   
    public String getItem(String user, int pid){
        String sql ="select * from Cart where account = ? and pid = ?";
         try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setInt(2, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                 
                 return new String(rs.getString(1));
             }
        } catch (Exception e) {
        }
        return null;
    }
// list pid của user    
    public List<Integer> spOfUser(String user){
        List<Integer> list = new ArrayList<>();
        String sql ="select pid from Cart where account=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getInt(1));
            }           
            ps.close();
            return list;
        } catch (Exception e) {
        }
        
        return list;
    }
//xóa Item     
    public void deleteItem(String account,int pid){
        String sql = "delete from Cart where account = ? and pid=? "; 
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            ps.setInt(2, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
// insert them quantity và tổng tiền
    public void quantity_price(String account, int pid, int quantity, Double priceS, Date date){
        String sql = "update Cart set quantity = ?, priceS = ?, date = ? where account = ? and pid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setDouble(2, priceS);
            ps.setDate(3, date);
            ps.setString(4, account);
            ps.setInt(5, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
// Lấy toàn bộ Item card ( mỗi thành phần là 1 Card)
    public List<Cart> getAllCartUser(String acount){
        List<Cart> list = new ArrayList<>();
        String sql ="select * from Cart where account = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, acount);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Cart(
                        rs.getString(1), 
                        rs.getInt(2), 
                        rs.getDate(3), 
                        rs.getInt(4), 
                        rs.getDouble(5)));
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
    
//xóa giỏ hàng 
    public void deleteCart(String account){
        String sql = "delete from Cart where account = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
