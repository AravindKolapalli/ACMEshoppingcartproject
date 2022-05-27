package io.recruitment.assessment.api.controllers;


import io.recruitment.assessment.api.DAO.ProductRepository;
import io.recruitment.assessment.api.model.Products;
import io.recruitment.assessment.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;


    @PostMapping("/addProducts")
    public ResponseEntity<String> addProduct(@RequestBody Products products) {
        return ResponseEntity.ok().body(this.productService.addProducts(products));
    }

    @GetMapping("/getAllProducts")
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/updateProducts")
    public ResponseEntity<String> updateProducts(@RequestBody Products products) {
        return ResponseEntity.ok().body(this.productService.updateProducts(products));
    }

    @GetMapping("/deleteProduct")
    public String deleteProductById(@RequestParam Integer productId) {
        return productService.deleteProduct(productId);
    }


    @RequestMapping("/searchAPI")
    public List<Products> searchAPI(@RequestParam String keyword) {
        List<Products> listProducts = productService.search(keyword);
        return listProducts;
    }
}
