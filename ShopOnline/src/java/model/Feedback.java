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
public class Feedback {
    private int oid,pid;
    private double star;
    private String commment;
    private boolean status;
    private String account;
    private Date date;

    public Feedback() {
    }

    public Feedback(int oid, int pid, double star, String commment, boolean status, String account, Date date) {
        this.oid = oid;
        this.pid = pid;
        this.star = star;
        this.commment = commment;
        this.status = status;
        this.account = account;
        this.date = date;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public String getCommment() {
        return commment;
    }

    public void setCommment(String commment) {
        this.commment = commment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Feedback{" + "oid=" + oid + ", pid=" + pid + ", star=" + star + ", commment=" + commment + ", status=" + status + ", account=" + account + ", date=" + date + '}';
    }

 
    
}
