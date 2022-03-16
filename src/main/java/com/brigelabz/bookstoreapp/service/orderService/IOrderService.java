package com.brigelabz.bookstoreapp.service.orderService;

import com.brigelabz.bookstoreapp.dto.OrderDTO;
import com.brigelabz.bookstoreapp.entity.Order;

import java.util.List;

public interface IOrderService {

    //Order placeOrder(String token);

    Order placeOrder(String token, OrderDTO orderDTO);

    Boolean cancelOrder(String token, Long orderId);
//    List<Order> getAllOrders(OrderDTO orderDTO);
    List<Order> getAllOrders();
    List<Order> getAllOrdersByUserId(String token);

}