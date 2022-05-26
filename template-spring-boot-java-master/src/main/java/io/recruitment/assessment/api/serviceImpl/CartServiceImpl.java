package io.recruitment.assessment.api.serviceImpl;


import io.recruitment.assessment.api.DAO.CartRepository;
import io.recruitment.assessment.api.DAO.ProductRepository;
import io.recruitment.assessment.api.model.Cart;
import io.recruitment.assessment.api.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    public Object saveSummary(String customerId) {
        System.out.println("customerId========>"+customerId);

        Cart c = cartRepository.findAllByCustomerId(customerId);

        List<Integer> productIds = c.getProductIdList();

        System.out.println("==================>"+productIds);

       int productPrice=0;
        for(Integer productId : productIds) {
            System.out.println("productId===>"+productId);
            Products p = productRepository.findAllByProductId(productId);

            System.out.println("price===>"+p.getProductPrice());

            productPrice=productPrice+p.getProductPrice();
            System.out.println("total price"+productPrice);
        }
        return "product price here is "+productPrice;
    }

}
