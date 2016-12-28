package com.theironyard;

import java.util.Date;
import java.util.UUID;

/**
 * Created by melmo on 12/27/16.
 */
public class Message {
    private String id;
    private String content;
    private String username;
    private Date createdOn;

    public Message(String content, String username) {
        this.id = UUID.randomUUID().toString();
        this.createdOn = new Date();
        this.content = content;
        this.username = username;
    }

    public Message(String id, String content, String username, Date createdOn) {
        this.id = id;
        this.content = content;
        this.username = username;
        this.createdOn = createdOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
