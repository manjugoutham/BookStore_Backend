package com.brigelabz.bookstoreapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class OrderDTO {

    @NotNull
    private String orderDate;

    @NotNull
    private Long price;

    @NotNull
    private Long Quantity;

    @Pattern(regexp = "[A-Za-z]{1}[a-zA-Z\\s]{2,}$", message = "Person first name Invalid")
    private String Address;

    @NotNull
    private boolean cancel;
}