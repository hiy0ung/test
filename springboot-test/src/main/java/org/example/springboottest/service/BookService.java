package org.example.springboottest.service;

import lombok.RequiredArgsConstructor;
import org.example.springboottest.common.constant.ResponseMessage;
import org.example.springboottest.dto.request.PostBookRequestDto;
import org.example.springboottest.dto.response.GetBookListResponseDto;
import org.example.springboottest.dto.response.GetBookResponseDto;
import org.example.springboottest.dto.response.PostBookResponseDto;
import org.example.springboottest.dto.response.ResponseDto;
import org.example.springboottest.entity.Book;
import org.example.springboottest.entity.Category;
import org.example.springboottest.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public ResponseDto<GetBookResponseDto> getBookById(Long id) {
        GetBookResponseDto data = null;
        Long bookId = id;

        try {
            Optional<Book> bookOptional = bookRepository.findById(bookId);

            if (bookOptional.isPresent()) {
                data = new GetBookResponseDto(bookOptional.get());
            } else {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<List<GetBookListResponseDto>> getAllBooks() {
        List<GetBookListResponseDto> data = null;

        try {
            List<Book> books = bookRepository.findAll();

            data = books.stream()
                    .map(GetBookListResponseDto::new)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<PostBookResponseDto> createBook(PostBookRequestDto dto) {
        PostBookResponseDto data = null;

        try {
            Book book = Book.builder()
                    .title(dto.getTitle())
                    .author(dto.getAuthor())
                    .category(dto.getCategory())
                    .build();

            book = bookRepository.save(book);

            data = new PostBookResponseDto(book);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<List<GetBookListResponseDto>> getBooksByCategory(Category category) {
        List<GetBookListResponseDto> data = null;
        Category bookCategory = category;

        try {
            Optional<List<Book>> optionalBooks = bookRepository.findByCategory(bookCategory);

            if (optionalBooks.isPresent()) {
                List<Book> books = optionalBooks.get();
                data = books.stream()
                        .map(GetBookListResponseDto::new)
                        .collect(Collectors.toList());
            } else {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
}
