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
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext {

    public List<Product> random8Pro() {
        String sql = "select top(8) * from Product\n"
                + "order by NEWID()";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getBoolean(9)));
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllSp() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getBoolean(9)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> allCategory() {
        String sql = "select * from Category";
        List<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> titleAll() {
        List<Product> list = new ArrayList<>();
        String sql = "select distinct title, cateid from Product order by cateid";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(0, null, null, 0, null, rs.getString(1), null, rs.getInt(2), true));
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }

    public List<String> colorAll() {
        List<String> list = new ArrayList<>();
        String sql = "select distinct color from Product";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductbyID(int id) {
        String sql = "select * from Product where idSP = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getBoolean(9));
                return p;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> searchName(String name) {
        String sql = "select * from Product where nameSP like ?";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getBoolean(9)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchPbyOp(String namesp, String gender, String priceMin, String PriceMax, String[] color) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product where nameSP like '%" + namesp + "%'";
        if (gender.equalsIgnoreCase("") || gender.equalsIgnoreCase("null")) {

        } else if (gender.equalsIgnoreCase("both")) {
            sql += " and gender is null";
        } else {
            sql += " and gender = '" + gender + "'";
        }

        if (priceMin != null && !(priceMin.equalsIgnoreCase(""))) {
            sql += " and price >= " + priceMin + "";

        }
        if (PriceMax != null && !(PriceMax.equalsIgnoreCase(""))) {
            sql += " and price <= " + PriceMax + "";
        }

        if (color == null) {

        } else {
            sql += " and color = N'" + color[0] + "'";
            for (int i = 1; i < color.length; i++) {
                sql += " or color = N'" + color[i] + "'";
            }
        }

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getBoolean(9)));
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }

    public void addProduct(int pid, String name, String image, double price, String color, String title, String description, int cateid, String gender) {

        String sql = "insert into Product values (?,?,?,?,?,?,?,?," + gender + ")";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.setString(2, name);
            ps.setString(3, image);
            ps.setDouble(4, price);
            ps.setString(5, color);
            ps.setString(6, title);
            ps.setString(7, description);
            ps.setInt(8, cateid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProduct(int pid, String name, String image, double price, String color, String title, String description, int cateid, String gender) {
        String sql = "update Product set\n"
                + "nameSP = N'" + name + "', \n"
                + "image = '" + image + "',\n"
                + "price = " + price + ",\n"
                + "color = N'" + color + "',\n"
                + "title = N'" + title + "',\n"
                + "description = N'" + description + "',\n"
                + "cateid = " + cateid + ",\n"
                + "Gender = " + gender + "\n"
                + "where idSP = " + pid + "";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(int id) {
        String sql = "delete from Product where idSP = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public String getnameSP(int id) {
        String img = null;
        String sql = "select nameSP from Product where idSP = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                img = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return img;
    }

    public String getImageSP(int id) {
        String name = null;
        String sql = "select image from Product where idSP = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return name;
    }

    public List<Product> listbyTitle(String title) {
        List<Product> list = new ArrayList<>();
        String slq = "select * from Product where title = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(slq);
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getBoolean(9)));
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }

    public int totalProduct() {
        int total = 0;
        String sql = "select COUNt(*) from Product";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
            ps.close();
        } catch (Exception e) {
        }
        return total;
    }

    public List<Product> pagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product \n"
                + "order by idSP\n"
                + "offset ? row fetch next 9 row only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index-1)*9);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getBoolean(9)));            
            }
        } catch (Exception e) {
        }       
        return list;
    }
    
    public List<Product> search_manage(String id, String nameSP){
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        if(!nameSP.equals("")){
            sql += " where nameSP like N'%"+nameSP+"%'";                      
        }
        if(!id.equals("")){
            sql += " where idSP = "+id+"";
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getBoolean(9)));
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
    
    public int totalPage() {
        int total = 0;
        String query = "select count(*)\n"
                + "from Product";
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
    
    public List<Product> paging(int index) {
        String query = "SELECT * FROM Product\n"
                + "order by idSP\n"
                + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, (index -1) * 10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getBoolean(9)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
}
