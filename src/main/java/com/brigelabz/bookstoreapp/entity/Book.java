package com.brigelabz.bookstoreapp.entity;

import com.brigelabz.bookstoreapp.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Bookdata")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Person name Invalid")
    private String name;

    private String author;

    private String description;

    private String bookLogo;

    private Long price;

    @ManyToMany(mappedBy = "books")
    private List<Order> order;

    @ManyToOne
    private Cart carts;

    private String quantity;

    public Book(BookDTO bookDTO) {
    }
}
