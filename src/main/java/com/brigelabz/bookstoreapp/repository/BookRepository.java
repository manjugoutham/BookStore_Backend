package com.brigelabz.bookstoreapp.repository;

import com.brigelabz.bookstoreapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

    Book getBookById(Long id);

//    Long countByAuthor();

}
