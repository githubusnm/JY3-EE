package com.neuedu.entity;

public class Admin {
    private String adminname;
    private String adminpassword;

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminname='" + adminname + '\'' +
                ", adminpassword='" + adminpassword + '\'' +
                '}';
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

    public Admin(String adminname, String adminpassword) {
        this.adminname = adminname;
        this.adminpassword = adminpassword;
    }
}
