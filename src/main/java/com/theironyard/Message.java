package com.theironyard;

/**
 * Created by melmo on 12/27/16.
 */
public class Message {
    private int id;
    private String content;

    public Message(int id, String text) {
        this.id = id;
        this.content = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
