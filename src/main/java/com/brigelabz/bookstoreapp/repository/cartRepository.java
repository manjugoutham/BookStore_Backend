package com.brigelabz.bookstoreapp.repository;

import com.brigelabz.bookstoreapp.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cartRepository extends JpaRepository<Cart,Long> {

}
