package io.recruitment.assessment.api.DAO;

import io.recruitment.assessment.api.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Products, Integer> {

    Products findAllByProductId(Integer productId);
    List<Products> findAllByProductNameLike(String name);


}
