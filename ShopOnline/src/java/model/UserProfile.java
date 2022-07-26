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
public class UserProfile {
    private int id;
    private String userName;
    private String fullName;
    private String email;
    private String address;
    private String phone;

    public UserProfile() {
    }

    
    public UserProfile(int id, String userName, String fullName, String email, String address, String phone) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserProfile{" + "id=" + id + ", userName=" + userName + ", fullName=" + fullName + ", email=" + email + ", address=" + address + ", phone=" + phone + '}';
    }
    
    
}
