package com.example.springcashier.repository;

import com.example.springcashier.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderQueryRepository extends JpaRepository<Order, Integer> {
}
