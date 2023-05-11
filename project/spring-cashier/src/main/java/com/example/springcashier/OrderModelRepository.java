package com.example.springcashier;

import org.springframework.data.repository.CrudRepository;

public interface OrderModelRepository extends CrudRepository<Order, Integer> {
}
