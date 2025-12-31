package com.voice_food_order.vfo.controller;

import com.voice_food_order.vfo.model.Order;
import com.voice_food_order.vfo.repository.OrderRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    private final OrderRepository repo;

    public OrderController(OrderRepository r) {
        this.repo = r;
    }

    @GetMapping
    public List<Order> history() {
        return repo.findAll();
    }
}
