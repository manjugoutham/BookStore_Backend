package com.brigelabz.bookstoreapp.service.cartService;

import com.brigelabz.bookstoreapp.dto.BookDTO;
import com.brigelabz.bookstoreapp.entity.Book;
import com.brigelabz.bookstoreapp.entity.Cart;

import java.util.List;

public interface ICartService {

    List<Cart> getAllCartItems();
    Cart getBookStoreDataById(Long cartId);

    Book addToCart(BookDTO bookDTO);

    void removeCart(Long cartId);
    Cart updateCart(Long catId, Long quantity);
    Cart getAllCartItemsUser(String Token);
}
