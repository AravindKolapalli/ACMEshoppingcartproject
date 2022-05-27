package io.recruitment.assessment.api.service;

import io.recruitment.assessment.api.model.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    String addCart(Cart cart);
}
