package com.example.apiV2.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    @Column(length = 500)
    private String content;
    private String author;
    private LocalDate date;
    private String tag;

    public Article(String title, String content, String author, LocalDate date, String tag) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.tag = tag;
    }

    public Article() {
    }
}
