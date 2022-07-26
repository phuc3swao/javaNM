/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Array;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Order;

/**
 *
 * @author Admin
 */
public class OrderProcDAO extends DBContext{
    
    public void insertOP(int oid, Date beginDate, int idStaff, String status){
        String sql = "insert into OrderProc(oid,beginDate,idStaff,status) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, oid);
            ps.setDate(2, beginDate);
            ps.setInt(3, idStaff);
            ps.setString(4, status);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<Order> listWorkStaff(String user){
        List<Order> list = new ArrayList<>();
        String sql ="select o.oid,o.pid,o.account,o.customer,o.address,o.height,o.weight,o.status,o.date,o.quantity,o.price,o.phone\n" +
"from [Order] o full outer join OrderProc op on o.oid=op.oid full outer join Staff s on op.idStaff=s.idStaff\n" +
"where s.account = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(new Order(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9),
                        rs.getInt(10),
                        rs.getDouble(11),
                        rs.getString(12),
                        rs.getBoolean(13)));
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
}
