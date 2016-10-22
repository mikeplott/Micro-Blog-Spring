package com.example;

import javax.persistence.*;

/**
 * Created by michaelplott on 10/22/16.
 */
@Entity
@Table(name = "microblog")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
