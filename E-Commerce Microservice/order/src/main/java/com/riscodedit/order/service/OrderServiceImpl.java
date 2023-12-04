package com.riscodedit.order.service;

import com.riscodedit.order.domain.dto.InventoryResponseDto;
import com.riscodedit.order.domain.dto.OrderItemDto;
import com.riscodedit.order.domain.dto.OrderRequestDto;
import com.riscodedit.order.domain.dto.OrderResponseDto;
import com.riscodedit.order.domain.entity.Order;
import com.riscodedit.order.domain.entity.OrderItem;
import com.riscodedit.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private WebClient webClient;

    public OrderServiceImpl(OrderRepository orderRepository, WebClient webClient) {
        this.orderRepository = orderRepository;
        this.webClient = webClient;
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

       List<String> skuCodes =  order.getOrderItemList().stream()
                .map(OrderItem::getSkuCode)
                .toList();


        // call to inventory service to check if products in stock
       InventoryResponseDto[] inventoryResponseArray = webClient.get()
                .uri("http://localhost:8083/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build() )
                .retrieve()
                .bodyToMono(InventoryResponseDto[].class)
                .block();

      boolean result = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponseDto::getIsInStock);

       if(result){
           orderRepository.save(order);
       }else{
           throw  new IllegalArgumentException("product out of stock");
       }

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
