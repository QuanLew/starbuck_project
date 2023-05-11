package com.example.springcashier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderQueryRepository extends JpaRepository<Order, Integer> {
}
