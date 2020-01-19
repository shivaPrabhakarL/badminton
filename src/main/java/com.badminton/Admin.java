package com.badminton;

public class Admin{
    int id = 0;
    String firstName;
    String lastName;
    String UserName;
    String email;
    String password;
    public int getId() {
        return id;
    }

    public void setId() {
        this.id = this.id+1;
    }



    public Admin(){
        this.id = this.id + 1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}