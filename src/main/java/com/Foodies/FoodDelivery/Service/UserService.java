package com.Foodies.FoodDelivery.Service;

import com.Foodies.FoodDelivery.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
}
