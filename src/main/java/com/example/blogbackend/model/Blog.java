package com.example.blogbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String author;

    public Blog() {}

    public Blog(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
