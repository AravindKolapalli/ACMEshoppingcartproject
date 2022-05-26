package io.recruitment.assessment.api.DAO;

import io.recruitment.assessment.api.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Object> {
}
