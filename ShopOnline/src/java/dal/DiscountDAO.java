/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Discount;

/**
 *
 * @author Admin
 */
public class DiscountDAO extends DBContext{
    public void insertDiscount(Discount discount){
        try {
            String sql = "INSERT INTO Discount(codeString, status, value) VALUES (?, 1, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            stm.setString(1, discount.getCodeString());
            stm.setDouble(2, discount.getValue());
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DiscountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Discount getDiscount(String code) {
        Discount discount = null;
        String xSql = "select * from Discount where codeString = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(xSql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("codeId");
                double value = rs.getDouble("value");
                boolean status = rs.getBoolean("status");
                discount = new Discount(id, code, status, value);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return discount;
    }
    
    public boolean checkIfDiscountExist(String code) {
        String xSql = "select * from Discount where codeString = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(xSql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return true;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public void upDiscountStatusByCode(String code){
        try {
            String sql = "update Discount set status = 0 where codeString = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            stm.setString(1, code);
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DiscountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
