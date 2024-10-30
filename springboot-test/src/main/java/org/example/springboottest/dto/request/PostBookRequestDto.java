package org.example.springboottest.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboottest.entity.Category;

@Data
@NoArgsConstructor
public class PostBookRequestDto {
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private Category category;
}
