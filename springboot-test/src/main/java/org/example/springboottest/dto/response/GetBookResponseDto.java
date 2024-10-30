package org.example.springboottest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboottest.entity.Book;
import org.example.springboottest.entity.Category;

@Data
@NoArgsConstructor
public class GetBookResponseDto {
    private Long id;
    private String title;
    private String author;
    private Category category;

    public GetBookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.category = book.getCategory();
    }
}
