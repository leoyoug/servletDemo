package com.touch.entity;

import java.sql.Date;

public class Person {
    private int id;
    private String name;
    private String password;
    private String email;
    private String birthday;

    public int getId() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setbirthday(String birthday) {
        this.birthday = birthday;
    }

    public Person() {

    }

    public Person(int id, String name, String password, String email, String birthday) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
