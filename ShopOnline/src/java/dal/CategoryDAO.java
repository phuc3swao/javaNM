/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;

/**
 *
 * @author admin
 */
public class CategoryDAO extends DBContext {

    public List<Category> getAllCt() {
        String sql = "SELECT [cid]\n"
                + "      ,[CateName]\n"
                + "  FROM [dbo].[Category]";

        List<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Category getCategorybyID(int id) {
        String sql = "SELECT [cid]\n"
                + "      ,[CateName]\n"
                + "  FROM [Category]\n"
                + "  WHERE [cid] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Category p = new Category(rs.getInt(1), rs.getString(2));
            return p;

        } catch (Exception e) {
        }
        return null;
    }

    public void addCategory(int id, String name) {
        String sql = "INSERT INTO [dbo].[Category]\n"
                + "           ([cid]\n"
                + "           ,[CateName])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }

    public void delete(int cid) {
        try {
            String sql = "DELETE FROM [Category]\n"
                    + "      WHERE cid = ?";

            //Đưa câu lệnh sql vào prepare để chuẩn bị thực thi
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);

            //Thực thi và trả về kết quả
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
