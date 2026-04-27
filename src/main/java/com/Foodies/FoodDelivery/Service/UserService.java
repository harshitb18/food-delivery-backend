package com.Foodies.FoodDelivery.Service;

import com.Foodies.FoodDelivery.Entity.User;
import com.Foodies.FoodDelivery.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User saveUser(User user) {
        // Check if phone number is already registered before saving
        Optional<User> existingUser = userRepository.findByPhoneNo(user.getPhoneNo());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Phone number already registered.");
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByPhoneNo(Long phoneNo) {
        return userRepository.findByPhoneNo(phoneNo).orElse(null);
    }

    public User updateByUserId(int id, User userDetails) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // If the phone number is being changed, check if it's already in use
            if (!existingUser.getPhoneNo().equals(userDetails.getPhoneNo())) {
                Optional<User> userWithPhone = userRepository.findByPhoneNo(userDetails.getPhoneNo());
                if (userWithPhone.isPresent()) {
                    throw new IllegalArgumentException("Phone number already registered to another user.");
                }
            }

            existingUser.setUsername(userDetails.getUsername());
            existingUser.setEmailId(userDetails.getEmailId());
            existingUser.setPhoneNo(userDetails.getPhoneNo());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
