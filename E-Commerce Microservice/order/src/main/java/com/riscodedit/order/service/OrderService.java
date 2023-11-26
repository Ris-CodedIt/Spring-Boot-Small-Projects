package com.riscodedit.order.service;

import com.riscodedit.order.domain.dto.OrderRequestDto;
import com.riscodedit.order.domain.dto.OrderResponseDto;
import java.util.List;

public interface OrderService {
    void createOrder(OrderRequestDto orderRequestDto);

    List<OrderResponseDto> getAllOrders();

    OrderResponseDto getOneOrder(Long orderId);
}
