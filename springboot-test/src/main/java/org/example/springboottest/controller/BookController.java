package org.example.springboottest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springboottest.dto.request.PostBookRequestDto;
import org.example.springboottest.dto.response.GetBookListResponseDto;
import org.example.springboottest.dto.response.GetBookResponseDto;
import org.example.springboottest.dto.response.PostBookResponseDto;
import org.example.springboottest.dto.response.ResponseDto;
import org.example.springboottest.entity.Category;
import org.example.springboottest.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/test/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // Mapping pattern 설정
    public static final String BOOK_GET_BOOK_ID = "/{id}";
    public static final String BOOK_GET_LIST = "/list";
    public static final String BOOK_GET_CATEGORY = "/category";

    @GetMapping(BOOK_GET_BOOK_ID)
    public ResponseEntity<ResponseDto<GetBookResponseDto>> getBookById(@PathVariable Long id) {
        ResponseDto<GetBookResponseDto> result = bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(BOOK_GET_LIST)
    public ResponseEntity<ResponseDto<List<GetBookListResponseDto>>> getAllBooks() {
        ResponseDto<List<GetBookListResponseDto>> result = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping
    public ResponseEntity<ResponseDto<PostBookResponseDto>> createBook(@RequestBody PostBookRequestDto dto) {
        ResponseDto<PostBookResponseDto> result = bookService.createBook(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(BOOK_GET_CATEGORY)
    public ResponseEntity<ResponseDto<List<GetBookListResponseDto>>> getBooksByCategory(@RequestParam Category category) {
        ResponseDto<List<GetBookListResponseDto>> result = bookService.getBooksByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
