/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.UserProfile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class UserProfileDAO extends DBContext{
    //HungBD
    public UserProfile getUserByUsername(String userName){
        UserProfile uProfile = null;
        String xSql = "select * from UserProfile where username = ?" ;
        try {
            PreparedStatement ps = connection.prepareStatement(xSql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            int id;
            String fullName, email, address, phone;
            if (rs.next()) {
                id = rs.getInt("id");
                fullName = rs.getString("fullname");
                email = rs.getString("email");
                address = rs.getString("address");
                phone = rs.getString("phone");
                uProfile = new UserProfile(id, userName, fullName, email, address, phone);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return uProfile;
    }
    
    //PhucLH 
    public boolean exisProfile(String user, String gmail){
        String sql ="select * from UserProfile where username = ? and email = ?";
        UserProfile u = null ;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, gmail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                u = new UserProfile(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        if(u != null){
            return true;
        }else {
            return false;
        }
    }
    
    //update or insert
    public void upsertUser(UserProfile user) {
        try {
            String sql = "UPDATE UserProfile SET fullname = ?, email = ?, address = ?, phone = ? WHERE username = ?\n"
                    + "\n"
                    + "IF @@ROWCOUNT = 0\n"
                    + "   INSERT INTO UserProfile(username, fullname, email, address, phone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            //for update
            stm.setString(1, user.getFullName());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getAddress());
            stm.setString(4, user.getPhone());
            stm.setString(5, user.getUserName());
            //for insert
            stm.setString(6, user.getUserName());
            stm.setString(7, user.getFullName());
            stm.setString(8, user.getEmail());
            stm.setString(9, user.getAddress());
            stm.setString(10, user.getPhone());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
