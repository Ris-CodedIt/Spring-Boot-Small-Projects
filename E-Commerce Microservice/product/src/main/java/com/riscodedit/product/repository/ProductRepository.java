package com.riscodedit.product.repository;

import com.riscodedit.product.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}
