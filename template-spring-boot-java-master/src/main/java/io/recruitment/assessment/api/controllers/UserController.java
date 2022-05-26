package io.recruitment.assessment.api.controllers;

import io.recruitment.assessment.api.DAO.UserRepository;
import io.recruitment.assessment.api.serviceImpl.UserServiceImpl;
import io.recruitment.assessment.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok().body(this.userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody User user){
        return ResponseEntity.ok().body(this.userServiceImpl.userLogin(user));
    }
}
