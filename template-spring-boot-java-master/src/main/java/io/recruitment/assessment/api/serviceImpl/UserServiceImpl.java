package io.recruitment.assessment.api.serviceImpl;

import io.recruitment.assessment.api.DAO.UserRepository;
import io.recruitment.assessment.api.model.User;
import io.recruitment.assessment.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    protected static boolean isUserLoggedIn = false;
    protected static boolean isAdminLoggedIn = false;

    protected static User currUser;

    public void userLogout(User user) {
        isUserLoggedIn = false;
        isAdminLoggedIn = false;
        currUser = new User();
    }

    public String userLogin(User user) {
        // checking if the any user with entered email id and password exists
        List users = userRepository.UserNameAndPassword(user.getUserName(), user.getPassword());
        // if user details are valid, showing welcome message, player details, and players in transfer list (if any)
        if(!users.isEmpty()) {
            isUserLoggedIn = true;
            currUser = (User) users.get(0);
            String type = currUser.getUserType();
            if(type.equals("Admin")){
                isAdminLoggedIn =true;
                return "admin logged in successfully";
            } else if(type.equals("Customer")){
                isAdminLoggedIn=false;
                return "customer logged in successfully";
            }
            return "Welcome "+currUser.getFirstName();
        } else {
            userLogout(currUser);
            return "Invalid email id or password.";
        }
    }
}
