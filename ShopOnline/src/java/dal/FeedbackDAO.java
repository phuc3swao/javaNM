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
import model.Feedback;

/**
 *
 * @author Admin
 */
public class FeedbackDAO extends DBContext{
    
    public List<Feedback> Customerfb(String user){
        List<Feedback> list = new ArrayList<>();
        String sql = "select oid, pid, star, comment,status, account, [date] from Feedback where account = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add( new Feedback(
                        rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getDouble(3), 
                        rs.getString(4), 
                        rs.getBoolean(5), 
                        rs.getString(6),
                        rs.getDate(7)));
            }
            ps.close();
        } catch (Exception e) {
        }
        return list;
    }
    
    public void insertFeedback(String oid, String pid, String star, String comment, String account,String date){
        String sql= "insert into Feedback values("+oid+","+pid+","+star+",N'"+comment+"',"+1+",'"+account+"','"+date+"')";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
        
    }
    
    public List<Feedback> fb_Product(int pid){
        List<Feedback> list = new ArrayList<>();
        String sql = "select oid, pid, star, comment,status, account, [date] from Feedback where pid = ? order by date desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add( new Feedback(
                        rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getDouble(3), 
                        rs.getString(4), 
                        rs.getBoolean(5), 
                        rs.getString(6),
                        rs.getDate(7)));
            }
            ps.close();
        } catch (Exception e) {
        }
        return list;
    }
    
    //rating
    public double avgRating(int id){
        String sql = "select ROUND(AVG(star),1) from Feedback where pid = ? and status = 1";
        double rate = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                rate = rs.getDouble(1);
            }
            ps.close();
        } catch (Exception e) {
        }
        return rate;
    }
    
    public void updateStatus(String oid, String status){
        String sql ="update Feedback set status = "+status+" where oid = "+oid+" ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeQuery();
            ps.close();
        } catch (Exception e) {
        }
    }
}
