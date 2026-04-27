package com.Foodies.FoodDelivery.Controller;

import com.Foodies.FoodDelivery.Entity.User;
import com.Foodies.FoodDelivery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/phone/{phoneNo}")
    public User getUserByPhoneNo(@PathVariable Long phoneNo) {
        return userService.findByPhoneNo(phoneNo);
    }

    @PutMapping("/{id}")
    public User updateByUserId(@PathVariable int id, @RequestBody User user) {
        return userService.updateByUserId(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
    
    @DeleteMapping
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }
}
