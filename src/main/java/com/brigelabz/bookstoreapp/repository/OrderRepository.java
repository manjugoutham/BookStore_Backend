package com.brigelabz.bookstoreapp.repository;

import com.brigelabz.bookstoreapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
