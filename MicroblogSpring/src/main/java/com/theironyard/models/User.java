package com.theironyard.models;

/**
 * Created by sparatan117 on 12/27/16.
 */
public class User {
    private String username;


    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
