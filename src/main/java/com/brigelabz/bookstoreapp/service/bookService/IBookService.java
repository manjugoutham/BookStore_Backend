package com.brigelabz.bookstoreapp.service.bookService;

import com.brigelabz.bookstoreapp.dto.BookDTO;
import com.brigelabz.bookstoreapp.entity.Book;

import java.util.List;

public interface IBookService {


    List<Book> getAllBook();
    Book getBookByID(Long bookId);
    Book addBook(BookDTO bookDTO);
    Book updateBook(Long bookID, BookDTO bookDTO);
    void deleteBook(String token,Long bookId);

    Book changeBookQuantity(String token,Long bookId, Long quantity);
    Book changeBookPrice(Long bookId, Long price);

}
