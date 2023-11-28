package com.riscodedit.order.controller;


import com.riscodedit.order.domain.dto.OrderRequestDto;
import com.riscodedit.order.domain.dto.OrderResponseDto;
import com.riscodedit.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  String placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        orderService.createOrder(orderRequestDto);
        return "Order Placed Successfully";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponseDto> getAllOrders(){
        return orderService.getAllOrders();

    }

    @GetMapping(path = "/{order_id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponseDto getOneOrder(@PathVariable("order_id") Long order_id){
       return orderService.getOneOrder(order_id);
    }
}
