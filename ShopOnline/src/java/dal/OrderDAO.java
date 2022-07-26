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

import model.Order;
import model.Static1;

/**
 *
 * @author Admin
 */
public class OrderDAO extends DBContext {

    //Lấy Order dựa vào id
    public Order getObyPid(int pid) {
        String sql = "select * from [Order] where pid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(
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
                        rs.getBoolean(13));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int getMaxId(){
        int id = 0;
        String sql = "select max(oid) from [Order]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
            return id;

        } catch (Exception e) {
        }
        
        return id;
    }
    
    public void addOrder(int oid, int pid, String account, String customer, String address, String height, String weight, String status, Date date, int quantity, double price, String phone) {
        String sql = "insert into [Order] values (?,?,?,?,?,?,?,?,?,?,?,?,0)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, oid);
            ps.setInt(2, pid);
            ps.setString(3, account);
            ps.setString(4, customer);
            ps.setString(5, address);
            ps.setString(6, height);
            ps.setString(7, weight);
            ps.setString(8, status);
            ps.setDate(9, date);
            ps.setInt(10, quantity);
            ps.setDouble(11, price);
            ps.setString(12, phone);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//Lấy toàn bộ Order

    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String sql = "select * from [Order]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
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
// Lấy order bằng oid (id của Order)

    public Order getOrderbyOid(int oid) {
        String sql = "select * from [Order] where oid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, oid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order(
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
                        rs.getBoolean(13));
                return o;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public void udpateStatus(int oid, String status) {
        String sql = "update [Order] set status = ? where oid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, oid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //thống kê 
    public int TongSPselled() {
        String sql = "select sum(quantity) from [Order]";
        int allquan = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                allquan = rs.getInt(1);
            }
            return allquan;
        } catch (Exception e) {
        }
        return allquan;
    }

    public int TongOrder() {
        String sql = "select count(*) from [Order]";
        int all = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                all = rs.getInt(1);
            }
            return all;
        } catch (Exception e) {
        }
        return all;
    }

    public List<Static1> slsellbyPid() {
        String sql = "select pid,sum(quantity) from [Order]\n"
                + "group by pid";
        List<Static1> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Static1(rs.getInt(1), rs.getInt(2)));
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }

    public int PriceperDay() {
        int a = 0, b = 1;
        String sql1 = "select count(distinct date) from [Order]";

        String sql2 = "select sum(price) from [Order]";
        try {
            PreparedStatement p1 = connection.prepareStatement(sql1);
            PreparedStatement p2 = connection.prepareStatement(sql2);
            ResultSet r1 = p1.executeQuery();
            ResultSet r2 = p2.executeQuery();
            while (r1.next()) {
                a = r1.getInt(1);
            }
            while (r2.next()) {
                b = r2.getInt(1);
            }
            if (a != 0) {
                return b / a;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //Get order by status or username 
    public List<Order> getOrderbyStatus(String customer, String status) {
        String sql = "";
        List<Order> list = new ArrayList<>();
        if (customer.equalsIgnoreCase("") && status.equalsIgnoreCase("")) {

        } else if (customer.equals("")) {
            sql = "select oid,pid,account,customer,address,height,weight,status,date,quantity,price,phone,feedback \n"
                    + "from [Order]\n"
                    + "where status = N'" + status + "'";
        } else if (status.equals("")) {
            sql = "select oid,pid,account,customer,address,height,weight,status,date,quantity,price,phone,feedback \n"
                    + "from [Order]\n"
                    + "where customer like '%" + customer + "%'";
        } else {
            sql = "select oid,pid,account,customer,address,height,weight,status,date,quantity,price,phone,feedback \n"
                    + "from [Order]\n"
                    + "where customer like '%" + customer + "%' and status = N'" + status + "'";
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
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
            ps.close();
            return list;
        } catch (Exception e) {
        }

        return null;
    }

    public List<Order> CustomerOrder_Date(String account, String bdate, String edate) {
        String sql = "";
        List<Order> list = new ArrayList<>();
        if (bdate == null && edate == null) {
            sql = "select oid,pid,account,customer,address,height,weight,status,date,quantity,price,phone,feedback \n"
                    + "from [Order]\n"
                    + "where account = '" + account + "'";
        } else {
            sql = "select oid,pid,account,customer,address,height,weight,status,date,quantity,price,phone,feedback \n"
                    + "from [Order]\n"
                    + "where account = '" + account + "' and [date] between '" + bdate + "' and '" + edate + "'";
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
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
            ps.close();
            return list;
        } catch (Exception e) {
        }

        return null;
    }

    public void setStatus(String oid, String pid, int status) {
        String sql = "update [Order] set feedback = " + status + " where oid = " + oid + " and pid = " + pid + "";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }

    public int productAllquantity(String pid) {
        String sql = "select SUM(quantity) from [Order] where pid = " + pid + " and status = N'Bán thành công'";
        int quantity = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                quantity = rs.getInt(1);
            }
            ps.close();
        } catch (Exception e) {
        }
        return quantity;
    }

    //Xóa order, xóa cả feedback
    public void deleteOrder(String oid) {
        String sql = "delete from Feedback where oid = "+oid+" \n"
                + "delete from [Order] where oid = "+oid+"";
        try {
             PreparedStatement ps = connection.prepareStatement(sql);
             ps.executeUpdate();
             ps.close();
        } catch (Exception e) {
        }
    }
    
    public int totalPage() {
        int total = 0;
        String query = "select count(*)\n"
                + "from Order";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int totalProduct = rs.getInt(1);
                total = totalProduct / 10;
                if (totalProduct % 10 != 0) {
                    total++;
                }
            }
        } catch (Exception e) {
        }
        return total;
    }
    
    public List<Order> paging(int index) {
        String query = "SELECT * FROM [Order]\n"
                + "order by oid\n"
                + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, (index -1) * 10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
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
        return null;
    }
}
