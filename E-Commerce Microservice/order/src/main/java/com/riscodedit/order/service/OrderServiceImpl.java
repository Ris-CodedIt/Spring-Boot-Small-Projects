package com.riscodedit.order.service;

import com.riscodedit.order.domain.dto.OrderItemDto;
import com.riscodedit.order.domain.dto.OrderRequestDto;
import com.riscodedit.order.domain.dto.OrderResponseDto;
import com.riscodedit.order.domain.entity.Order;
import com.riscodedit.order.domain.entity.OrderItem;
import com.riscodedit.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItem> orderItems = orderRequestDto.getOrderItemDtoList()
                .stream()
                .map(orderItemDto -> mapFromDto(orderItemDto))
                .toList();

        order.setOrderItemList(orderItems);

        orderRepository.save(order);

    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return null;
    }

    @Override
    public OrderResponseDto getOneOrder(Long orderId) {
        return null;
    }


    private OrderItem mapFromDto(OrderItemDto orderItemDto){
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setPrice(orderItemDto.getPrice());
        orderItem.setSkuCode(orderItemDto.getSkuCode());
        return orderItem;
    }
}
