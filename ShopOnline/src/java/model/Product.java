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
public class Product {
    private int id;
    private String nameSP,image;
    private double price;
    private String color,title,descrption;
    private int cateid;
    private boolean gender;

    public Product() {
    }

    public Product(int id, String nameSP, String image, double price, String color, String title, String descrption, int cateid, boolean gender) {
        this.id = id;
        this.nameSP = nameSP;
        this.image = image;
        this.price = price;
        this.color = color;
        this.title = title;
        this.descrption = descrption;
        this.cateid = cateid;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSP() {
        return nameSP;
    }

    public void setNameSP(String nameSP) {
        this.nameSP = nameSP;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", nameSP=" + nameSP + ", image=" + image + ", price=" + price + ", color=" + color + ", title=" + title + ", descrption=" + descrption + ", cateid=" + cateid + ", gender=" + gender + '}';
    }

    
}
