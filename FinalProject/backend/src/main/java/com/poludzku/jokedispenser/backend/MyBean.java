package com.poludzku.jokedispenser.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myData;
    private String author;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}