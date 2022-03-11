package com.brigelabz.bookstoreapp.repository;

import com.brigelabz.bookstoreapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Pattern;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    Book getBookById(Long id);
    Book searchBooksByName(@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Person first name Invalid") String name);
    List<Book> getBooksByOrderByPriceAsc();
    List<Book> getBooksByOrderByPriceDesc();

}
