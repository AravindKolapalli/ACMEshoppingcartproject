package io.recruitment.assessment.api.serviceImpl;


import io.recruitment.assessment.api.DAO.CartRepository;
import io.recruitment.assessment.api.DAO.ProductRepository;
import io.recruitment.assessment.api.model.Cart;
import io.recruitment.assessment.api.model.Products;
import io.recruitment.assessment.api.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.recruitment.assessment.api.serviceImpl.UserServiceImpl.isAdminLoggedIn;
import static io.recruitment.assessment.api.serviceImpl.UserServiceImpl.isUserLoggedIn;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String addCart(Cart cart) {
        if(isUserLoggedIn && ! isAdminLoggedIn) {
            cartRepository.save(cart);
            return "Added to Cart Successfully";
        }
        return "Please login as a Customer";
    }

    public Object saveSummary(String customerId) {
        if (isUserLoggedIn && !isAdminLoggedIn) {
            Cart c = cartRepository.findAllByCustomerId(customerId);
            List<Integer> productIds = c.getProductIdList();
            int productPrice = 0;
            for (Integer productId : productIds) {
                Products p = productRepository.findAllByProductId(productId);
                productPrice = productPrice + p.getProductPrice();
            }
            return "product price here is " + productPrice;
        }
        return "Please login as a Customer";
    }

}
