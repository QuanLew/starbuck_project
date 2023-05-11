package com.example.springcashier.service;

import com.example.springcashier.entity.Order;
import com.example.springcashier.repository.OrderQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderQueryRepository repository;

    public Order saveOrder(Order order){
        return repository.save(order);
    }


}
