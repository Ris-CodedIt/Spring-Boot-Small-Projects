package com.riscodedit.inventory.service;


import com.riscodedit.inventory.domain.dto.InventoryResponseDto;
import com.riscodedit.inventory.domain.entity.Inventory;
import com.riscodedit.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{
    private InventoryRepository inventoryRepository;
    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponseDto> checkIsInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(this::mapToDto)
                .toList();
    }

    private InventoryResponseDto mapToDto(Inventory inventory){
        return InventoryResponseDto.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();

    }
}
