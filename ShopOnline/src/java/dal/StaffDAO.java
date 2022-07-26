/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Staff;

/**
 *
 * @author Admin
 */
public class StaffDAO extends DBContext{
    
    public int maxIDStaff(){
        String sql="select max(idStaff) from Staff";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;       
    }
    
    public void inserStaff(int id, String name,String ability, String account){
        String sql= "insert into Staff values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, ability);
            ps.setString(4, account);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }
    public List<Staff> getAllStaff(){
        String sql = "select idStaff,name,ability,account from Staff";
        List<Staff> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(new Staff(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4)));
            }
            ps.close();
            return list;
            
        } catch (Exception e) {
        }
        return list;
    }
    
    public Staff existStaff(String account){
        String sql ="select * from Staff where account = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                return new Staff(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4));
            }
        } catch (Exception e) {
        }
        return null;       
    }
    
}
