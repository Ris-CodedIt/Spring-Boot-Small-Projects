package com.riscodedit.order.domain.dto;

import com.riscodedit.order.domain.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
//    private String orderNumber;
    private List<OrderItemDto> orderItemDtoList;
}
