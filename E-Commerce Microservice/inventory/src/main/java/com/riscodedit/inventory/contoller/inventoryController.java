package com.riscodedit.inventory.contoller;


import com.riscodedit.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class inventoryController {
    private InventoryService inventoryService;

    public inventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping(path = "/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public  boolean isInStock(@RequestParam("skuCode") String skuCode){
       return inventoryService.checkIsInStock(skuCode);
    }
}
