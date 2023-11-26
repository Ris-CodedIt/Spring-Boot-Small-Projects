package com.riscodedit.order.repository;

import com.riscodedit.order.domain.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
