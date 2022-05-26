package io.recruitment.assessment.api.serviceImpl;

import io.recruitment.assessment.api.DAO.ProductRepository;
import io.recruitment.assessment.api.DAO.UserRepository;
import io.recruitment.assessment.api.model.Products;
import io.recruitment.assessment.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductService {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private UserRepository userRepository;

    public List<Products> search(String keyword) {

        List<Products> products = productRepository.findAllByProductNameLike("%"+keyword+"%");
        for(Products product : products) {
            System.out.println("plan--------->"+product.getProductId());
        }
        return products;
    }

    @Override
    public List<Products> getAllProducts() {
        return (List<Products>) productRepository.findAll();
    }

    @Override
    public String updateProducts(Products products,boolean isAdminLoggedIn) {

        if(isAdminLoggedIn) {
            products.setProductName(products.getProductName());
            products.setProductPrice(products.getProductPrice());
            products.setProductCategory(products.getProductCategory());
            productRepository.save(products);
            return "updated successfully";
        } else {
            return "only Admin has the right to delete";
        }
    }

    @Override
    public String deleteProduct(Integer productId, boolean isAdminLoggedIn) {
        if(isAdminLoggedIn) {
            productRepository.deleteById(productId);
            return "deleted successfully";
        }
        else{

            return "only Admin has the right to delete";

        }
    }
}



