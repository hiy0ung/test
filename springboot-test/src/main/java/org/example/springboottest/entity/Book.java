package org.example.springboottest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_title", nullable = false)
    private String title;

    @Column(name = "book_author",nullable = false)
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_category", nullable = false, columnDefinition = "enum ('인문', '사회', '과학기술', '기타') not null default '기타'")
    private Category category;

    @Builder
    public Book(String title, String author, Category category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }
}
