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
public class Account {
    private String user,pass;
    private String info;
    private boolean status;

    public Account() {
    }

    public Account(String user, String pass, String info, boolean status) {
        this.user = user;
        this.pass = pass;
        this.info = info;
        this.status = status;
    }

    
    public Account(String user, String pass, String info) {
        this.user = user;
        this.pass = pass;
        this.info = info;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" + "user=" + user + ", pass=" + pass + ", info=" + info + '}';
    }
    
    
}
