package io.recruitment.assessment.api.controllers;

import io.recruitment.assessment.api.DAO.CartRepository;
import io.recruitment.assessment.api.service.CartService;
import io.recruitment.assessment.api.serviceImpl.CartServiceImpl;
import io.recruitment.assessment.api.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartServiceImpl cartServiceImpl;

    @Autowired
    private CartService cartService;

    @PostMapping("/addCart")
    public ResponseEntity<String> addCart(@RequestBody Cart cart){
        return ResponseEntity.ok().body(this.cartService.addCart(cart));
    }

    @PostMapping("/createSummary")
    public ResponseEntity addProduct(@RequestParam String customerId){
        return ResponseEntity.ok().body(this.cartServiceImpl.saveSummary(customerId));
    }
}
