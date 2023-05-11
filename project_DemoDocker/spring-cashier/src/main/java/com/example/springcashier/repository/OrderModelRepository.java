package com.example.springcashier.repository;

import com.example.springcashier.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderModelRepository extends CrudRepository<Order, Integer> {
}
