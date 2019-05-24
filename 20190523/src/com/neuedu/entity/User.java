package com.neuedu.entity;

import java.sql.Date;

public class User {
    private String userid;
    private String username;
    private String userpassword;
    private Date userdate;

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", userdate=" + userdate +
                '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Date getUserdate() {
        return userdate;
    }

    public void setUserdate(Date userdate) {
        this.userdate = userdate;
    }

    public User(String userid, String username, String userpassword){
        this.userid = userid;
        this.username = username;
        this.userpassword = userpassword;
    }

    public User(String username, String userpasword) {
        this.username = username;
        this.userpassword = userpasword;
    }
}
