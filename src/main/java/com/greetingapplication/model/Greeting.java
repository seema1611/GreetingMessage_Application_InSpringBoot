package com.greetingapplication.model;

import javax.persistence.*;

@Entity
@Table(name = "Greeting")
public class Greeting {

    @Id
    private long id;
    @Column(name = "message")
    private String message;

    public long getIncrementAndGet() {
        return id;
    }

    public void setIncrementAndGet(long id) {
        this.id = id;
    }

    public String getFormat() {
        return message;
    }

    public void setFormat(String message) {
        this.message = message;
    }
}
