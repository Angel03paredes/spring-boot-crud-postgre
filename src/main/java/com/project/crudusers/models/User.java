package com.project.crudusers.models;

public class User {
    private String name;
    private String title;
    private String email;

    public User(String name, String email,String title){
        this.name = name;
        this.title = title;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
