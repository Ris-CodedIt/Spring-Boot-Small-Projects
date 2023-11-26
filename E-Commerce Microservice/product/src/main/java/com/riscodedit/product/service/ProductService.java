package com.riscodedit.product.service;

import com.riscodedit.product.domain.dto.ProductRequestDto;
import com.riscodedit.product.domain.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    public void createProduct(ProductRequestDto productRequestDto);

    List<ProductResponseDto> getAllProducts();
}
