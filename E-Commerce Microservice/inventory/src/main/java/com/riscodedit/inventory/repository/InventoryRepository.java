package com.riscodedit.inventory.repository;

import com.riscodedit.inventory.domain.entity.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Optional<Inventory> findBySkuCode(String skuCode);
}
