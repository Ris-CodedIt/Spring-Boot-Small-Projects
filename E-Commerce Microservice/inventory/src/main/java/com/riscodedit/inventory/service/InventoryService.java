package com.riscodedit.inventory.service;

import com.riscodedit.inventory.domain.dto.InventoryResponseDto;

import java.util.List;

public interface InventoryService {
    List<InventoryResponseDto> checkIsInStock(List<String> skuCode);
}
