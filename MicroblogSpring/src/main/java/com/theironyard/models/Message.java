package com.theironyard.models;


/**
 * Created by sparatan117 on 12/27/16.
 */
public class Message {
    private Integer id;
    private String message;

    public Message(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
