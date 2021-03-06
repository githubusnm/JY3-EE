package com.neuedu.test;

public class StudentManager {
    private int id;
    private int student_id;
    private String student_name;
    private String student_password;

    public StudentManager(){}

    public StudentManager(int id, int student_id, String student_name, String student_password) {
        this.id = id;
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_password = student_password;
    }

    public StudentManager(String student_name,String student_password,int id){
        this.student_name = student_name;
        this.student_password = student_password;
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentManager{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_password='" + student_password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }
}
