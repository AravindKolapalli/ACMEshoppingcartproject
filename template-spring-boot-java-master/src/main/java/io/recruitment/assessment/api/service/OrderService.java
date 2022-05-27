package io.recruitment.assessment.api.service;

import io.recruitment.assessment.api.model.Order;
import org.springframework.stereotype.Service;
@Service
public interface OrderService {

    Object saveOrder(Order order);
}
