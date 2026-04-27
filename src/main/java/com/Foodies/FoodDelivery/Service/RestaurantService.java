package com.Foodies.FoodDelivery.Service;

import com.Foodies.FoodDelivery.Entity.Restaurant;
import com.Foodies.FoodDelivery.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(int id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public void deleteRestaurant(int id) {
        restaurantRepository.deleteById(id);
    }
    
    public void deleteAllRestaurants() {
        restaurantRepository.deleteAll();
    }
}
