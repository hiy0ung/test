package org.example.springboottest.repository;

import org.example.springboottest.entity.Book;
import org.example.springboottest.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<List<Book>> findByCategory(Category category);
}
