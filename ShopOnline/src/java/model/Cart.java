/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Cart {
    private String account;
    private int pid;
    private Date date;
    private int quantity;
    private double price;

    public Cart() {
    }

    public Cart(String account, int pid, Date date, int quantity, double price) {
        this.account = account;
        this.pid = pid;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cart{" + "account=" + account + ", pid=" + pid + ", date=" + date + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
    
        
}
