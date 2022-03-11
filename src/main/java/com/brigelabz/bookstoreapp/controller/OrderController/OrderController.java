package com.brigelabz.bookstoreapp.controller.OrderController;

import com.brigelabz.bookstoreapp.dto.OrderDTO;
import com.brigelabz.bookstoreapp.dto.ResponseDTO;
import com.brigelabz.bookstoreapp.entity.Order;
import com.brigelabz.bookstoreapp.service.orderService.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderServiceImpl orderServiceImpl;

    @GetMapping(value = {"","/","/get-all-order"})
    public ResponseEntity<ResponseDTO> getAllOrders(){
        List<Order> allOrders = orderServiceImpl.getAllOrders();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", allOrders);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping( "/get-All-Orders-For-User")
    public ResponseEntity<ResponseDTO> getAllOrdersForUser(@RequestParam String token){
        List<Order> userOrderList = orderServiceImpl.getAllOrdersForUser(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful at ORDER DTO: " , userOrderList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/cancel-Orders-By-Id/{userId}")
    public ResponseEntity<ResponseDTO> cancleOrdersById(@RequestParam String token,@RequestParam Long orderId){
        orderServiceImpl.cancelOrder(token, orderId);
        ResponseDTO responseDTO = new ResponseDTO("Canceled Order with id  " + orderId,"");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/place-Order")
    public ResponseEntity<ResponseDTO> addPersonData(@RequestParam String token){
        Order placeOrder = orderServiceImpl.placeOrder(token);
        ResponseDTO responseDTO = new ResponseDTO("Oder Place successfully : " ,placeOrder);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}