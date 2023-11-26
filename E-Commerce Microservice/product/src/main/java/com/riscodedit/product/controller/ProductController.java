package com.riscodedit.product.controller;


import com.riscodedit.product.domain.dto.ProductRequestDto;
import com.riscodedit.product.domain.dto.ProductResponseDto;
import com.riscodedit.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequestDto productRequestDto){
      productService.createProduct(productRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }
}
