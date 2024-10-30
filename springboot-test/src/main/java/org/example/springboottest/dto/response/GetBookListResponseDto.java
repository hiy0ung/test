package org.example.springboottest.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboottest.entity.Book;
import org.example.springboottest.entity.Category;

@Data
@NoArgsConstructor
public class GetBookListResponseDto {
    private Long id;
    private String title;
    private String author;
    private Category category;

    public GetBookListResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.category = book.getCategory();
    }
}
