package com.brigelabz.bookstoreapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@Table(name="orderTable")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_Id;
    @NotNull
    private String orderDate;
    @NotNull
    private Long price;
    @NotNull
    private Long quantity;
    @Pattern(regexp = "[A-Za-z]{1}[a-zA-Z\\s]{2,}$", message = "Person first name Invalid")
    private String address;

    @ManyToOne
    private User userOrder;

    @ManyToMany
    private List<Book> books;

    @NotNull
    private boolean cancel;
}
