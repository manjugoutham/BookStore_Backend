package com.brigelabz.bookstoreapp.controller.BookController;


import com.brigelabz.bookstoreapp.dto.BookDTO;
import com.brigelabz.bookstoreapp.dto.ResponseDTO;
import com.brigelabz.bookstoreapp.entity.Book;
import com.brigelabz.bookstoreapp.service.bookService.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="bookstore")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping(value = {"", "/","/get"})
    public ResponseEntity<ResponseDTO> getAllBooks(){
        List<Book> books = bookService.getAllBook();
        ResponseDTO booksResponseDTO = new ResponseDTO("Get All Books Successfully", books);
        return new ResponseEntity<ResponseDTO>(booksResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<ResponseDTO> getBookById(@PathVariable("bookId") long bookId){
        Book book = bookService.getBookByID(bookId);
        ResponseDTO booksResponseDTO = new ResponseDTO("Found book Successfully having id: "
                +bookId, book);
        return new ResponseEntity<ResponseDTO>(booksResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addBookData(@Valid  @RequestBody BookDTO bookDTO){
        Book book = bookService.addBook(bookDTO);
        ResponseDTO bookResponseDTO = new ResponseDTO("Created Book Successfully", book);
        return new ResponseEntity<ResponseDTO>(bookResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<ResponseDTO> updateBookDataById(@PathVariable("bookId") long bookId, @Valid @RequestBody BookDTO bookDTO){
        Book book = bookService.updateBook(bookId, bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Book with id  " + bookId, book);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDTO> deletePersonDataById(@RequestParam String token,@PathVariable("bookId") long bookId){
        bookService.deleteBook(token,bookId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully ", "Book with id: "+bookId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }

    @PutMapping("/changeBookQuantity/{bookId}")
    public ResponseEntity<ResponseDTO> changeBookQuantity(@RequestParam String token, @PathVariable("bookId")Long bookId, @RequestParam Long quantity){
        Book book = bookService.changeBookQuantity(token,bookId, quantity);
        ResponseDTO responseDTO = new ResponseDTO("Updated Book with id  " + bookId, book);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}