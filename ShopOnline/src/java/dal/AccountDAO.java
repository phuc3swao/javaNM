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
import model.Account;

/**
 *
 * @author Admin
 */
public class AccountDAO extends DBContext {
// lấy acc bằng user và pass    

    public Account getAccount(String user, String pass) {
        String sql = "select * from Account where username =? and password=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(3));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }
// lấy user bằng user    

    public String getUsername(String user) {

        String sql = "select * from Account where username like ?";
        String name = "";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (Exception e) {
        }
        return name;
    }
//thêm acc    

    public void addUser(String user, String pass) {
        String sql = "insert into Account(username,password) values(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//lấy toàn bộ acc 

    public List<Account> getAllAcc() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
//lay acc bang user
    public Account getforEdit(String user) {
        String sql = "select * from Account where username =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);          
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(3));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }
// update info
    public void updateInfo(String user, String info){
        String sql ="update Account set info = ? where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, info);
            ps.setString(2, user);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void resetPass(String user){
        String sql ="update Account set password = '123abc' where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }
    public void changePassword(String user, String pass){
        String sql ="update Account set password = ? where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, user);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }
    
    public void updateStatusToBan(String user){
        String sql = "update Account set status = 0 where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public int totalPage() {
        int total = 0;
        String query = "select count(*)\n"
                + "from Account";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int totalAccount = rs.getInt(1);
                total = totalAccount / 7;
                if (totalAccount % 7 != 0) {
                    total++;
                }
            }
        } catch (Exception e) {
        }
        return total;
    }
    
    public List<Account> paging(int index) {
        String query = "SELECT * FROM Account\n"
                + "order by username\n"
                + "OFFSET ? ROWS FETCH NEXT 7 ROWS ONLY";
        List<Account> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, (index -1) * 7);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
}
