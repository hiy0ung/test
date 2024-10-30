package org.example.springboottest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboottest.entity.Book;
import org.example.springboottest.entity.Category;

@Data
@NoArgsConstructor
public class PostBookResponseDto {
    private Long id;
    private String title;
    private String author;
    private Category category;

    public PostBookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.category = book.getCategory();
    }
}
