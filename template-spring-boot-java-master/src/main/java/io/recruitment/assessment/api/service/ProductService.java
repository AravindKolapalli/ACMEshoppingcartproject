package io.recruitment.assessment.api.service;

import io.recruitment.assessment.api.model.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Products> getAllProducts();

    String addProducts(Products products);

    String updateProducts(Products products);

    String deleteProduct(Integer productId);

    List<Products> search(String keyword);

}
