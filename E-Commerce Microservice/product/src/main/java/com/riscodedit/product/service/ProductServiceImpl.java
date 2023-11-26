package com.riscodedit.product.service;


import com.riscodedit.product.domain.Product;
import com.riscodedit.product.domain.dto.ProductRequestDto;
import com.riscodedit.product.domain.dto.ProductResponseDto;
import com.riscodedit.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements  ProductService{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(ProductRequestDto productRequestDto) {
        Product product = Product.builder()
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice())
                .build();
        productRepository.save(product);
        log.info("product {} is saved", product.getId());
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();

        List<ProductResponseDto> productResponseDtos =  products.stream().map(product -> {
            return  ProductResponseDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .build();}).toList();

        return productResponseDtos;
    }
}
