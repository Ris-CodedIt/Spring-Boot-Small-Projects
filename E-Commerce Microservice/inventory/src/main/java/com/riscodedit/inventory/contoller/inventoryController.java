package com.riscodedit.inventory.contoller;


import com.riscodedit.inventory.domain.dto.InventoryResponseDto;
import com.riscodedit.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class inventoryController {
    private InventoryService inventoryService;

    public inventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  List<InventoryResponseDto> isInStock(@RequestParam("skuCode") List<String> skuCode){
       return inventoryService.checkIsInStock(skuCode);
    }
}
