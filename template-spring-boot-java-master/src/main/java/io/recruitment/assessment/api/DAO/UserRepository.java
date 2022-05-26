package io.recruitment.assessment.api.DAO;

import io.recruitment.assessment.api.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {

    List<User> UserNameAndPassword(String userName, String password);
    List<User> UserType(String userName);

}
