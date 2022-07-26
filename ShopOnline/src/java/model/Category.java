/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Category {
    private int cid;
    private String nameCate;

    public Category() {
    }

    public Category(int cid, String nameCate) {
        this.cid = cid;
        this.nameCate = nameCate;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    @Override
    public String toString() {
        return "Category{" + "cid=" + cid + ", nameCate=" + nameCate + '}';
    }
     
}
