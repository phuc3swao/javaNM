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
public class Staff {
    private int idStaff;
    private String name,ability,account;

    public Staff() {
    }

    public Staff(int idStaff, String name, String ability, String account) {
        this.idStaff = idStaff;
        this.name = name;
        this.ability = ability;
        this.account = account;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Staff{" + "idStaff=" + idStaff + ", name=" + name + ", ability=" + ability + ", account=" + account + '}';
    }
       
}
