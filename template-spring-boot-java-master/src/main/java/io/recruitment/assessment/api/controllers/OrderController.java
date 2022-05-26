package io.recruitment.assessment.api.controllers;

import io.recruitment.assessment.api.DAO.OrderRepository;
import io.recruitment.assessment.api.service.OrderService;
import io.recruitment.assessment.api.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/createOrder")
    public ResponseEntity<Object> addProduct(@RequestBody Order order){
        return ResponseEntity.ok().body(this.orderRepository.save(order));
    }

}
