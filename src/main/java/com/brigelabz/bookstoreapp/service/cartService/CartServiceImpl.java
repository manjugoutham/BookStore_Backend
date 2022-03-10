package com.brigelabz.bookstoreapp.service.cartService;

import com.brigelabz.bookstoreapp.dto.BookDTO;
import com.brigelabz.bookstoreapp.entity.Book;
import com.brigelabz.bookstoreapp.entity.Cart;
import com.brigelabz.bookstoreapp.exceptions.BookstoreException;
import com.brigelabz.bookstoreapp.repository.BookRepository;
import com.brigelabz.bookstoreapp.repository.cartRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartServiceImpl implements ICartService{

    @Autowired
    private cartRepository cartrepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper mapper;

   // private List<Cart> cartList = new ArrayList<>();
    //public List<Cart> CartServiceImpl(cartRepository cartrepository, ModelMapper mapper) {
//        this.cartrepository = cartrepository;
//        this.mapper = mapper;
//        return null;
//    }

    @Override
    public List<Cart> getAllCartItems() {
        return cartrepository.findAll();
    }


    public Cart getBookStoreDataById(Long cartId) {
        return cartrepository
                .findById(cartId)
                .orElseThrow(() -> new BookstoreException("Cart Not Found!!"));
    }

    @Override
    public Book addToCart(BookDTO bookDTO) {
        Book bookdata = null;
        bookdata = new Book(bookDTO);
//        mapper.map(bookId)
        log.debug("Book Data: "+bookdata.toString());
        return bookRepository.save(bookdata);
    }

    @Override
    public void removeCart(Long bookId) {

        Cart cartData = this.getBookStoreDataById(bookId);
        cartrepository.delete(cartData);

    }

    @Override
    public Cart updateCart(Long cartId, Long quatity) {
        Cart cartData = this.getBookStoreDataById(cartId);
        mapper.map(quatity,cartData);
        return cartrepository.save(cartData);
    }

    @Override
    public Cart getAllCartItemsUser(String token) {
        return null;
    }
}

