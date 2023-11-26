package com.riscodedit.inventory.service;


import com.riscodedit.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService{
    private InventoryRepository inventoryRepository;
    @Override
    @Transactional(readOnly = true)
    public boolean checkIsInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
