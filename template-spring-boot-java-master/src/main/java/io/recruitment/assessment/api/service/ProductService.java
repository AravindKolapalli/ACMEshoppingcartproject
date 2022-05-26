package io.recruitment.assessment.api.service;

import io.recruitment.assessment.api.model.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Products> getAllProducts();

    String updateProducts(Products products, boolean isAdminLoggedIn);

    String deleteProduct(Integer productId,boolean isAdminLoggedIn);

    List<Products> search(String keyword);

}
