package io.recruitment.assessment.api.serviceImpl;

import io.recruitment.assessment.api.DAO.ProductRepository;
import io.recruitment.assessment.api.DAO.UserRepository;
import io.recruitment.assessment.api.model.Products;
import io.recruitment.assessment.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static io.recruitment.assessment.api.serviceImpl.UserServiceImpl.isAdminLoggedIn;

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


    @Override
    public String addProducts(Products products) {
        if(isAdminLoggedIn) {
            productRepository.save(products);
            return "Added Products Successfully";
        }
        return "Products can only be added by Admin";
    }

    @Override
    public List<Products> getAllProducts() {
        return (List<Products>) productRepository.findAll();
    }
    @Override
    public String updateProducts(Products products) {
        if(isAdminLoggedIn) {
            if(productRepository.findAllByProductId(products.getProductId()) != null) {
                Optional<Products> product = productRepository.findById(products.getProductId());
                Products currProduct = product.get();

                if(products.getProductName() != "" && products.getProductName() != null)
                    currProduct.setProductName(products.getProductName());

                if(products.getProductPrice() != 0)
                    currProduct.setProductPrice(products.getProductPrice());

                if(products.getProductCategory() != "" && products.getProductCategory() != null)
                    currProduct.setProductCategory(products.getProductCategory());
                productRepository.save(currProduct);
                return "updated successfully";
            } else {
                return " Product cannot update as it is not present ";
            }
        } else {
            return "only Admin has the right to update / Product is not present";
        }
    }

    @Override
    public String deleteProduct(Integer productId) {

        if(isAdminLoggedIn) {

            if(productRepository.findAllByProductId(productId) != null) {
                productRepository.deleteById(productId);
                return "deleted successfully";
            } else {
                return "Product is not present";
            }
        } else {
            return "only Admin has the right to delete";
        }
    }

    public List<Products> search(String keyword) {

        List<Products> products = productRepository.findAllByProductNameLike("%"+keyword+"%");
        for(Products product : products) {
            System.out.println("plan--------->"+product.getProductId());
        }
        return products;
    }
}



