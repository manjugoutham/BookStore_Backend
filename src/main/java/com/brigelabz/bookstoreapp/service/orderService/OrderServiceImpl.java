package com.brigelabz.bookstoreapp.service.orderService;

import com.brigelabz.bookstoreapp.dto.OrderDTO;
import com.brigelabz.bookstoreapp.entity.Cart;
import com.brigelabz.bookstoreapp.entity.Order;
import com.brigelabz.bookstoreapp.repository.OrderRepository;
import org.modelmapper.spi.StrongTypeConditionalConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    OrderRepository orderRepository;
    static String TOKEN = null;

    @Override
    public Order placeOrder(String token) {
        return null;
    }

    @Override
    public Boolean cancelOrder(String token, Long orderId) {
        return null;
    }

//    @Override
//    public List<Order> getAllOrders(OrderDTO orderDTO) {
//
//        return orderRepository.findAll();
//    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getAllOrdersForUser(String token) {
        return null;
    }
}