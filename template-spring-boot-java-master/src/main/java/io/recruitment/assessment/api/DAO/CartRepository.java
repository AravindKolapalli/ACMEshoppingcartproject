package io.recruitment.assessment.api.DAO;

import io.recruitment.assessment.api.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

    Cart findAllByCustomerId(String customerId);

}
