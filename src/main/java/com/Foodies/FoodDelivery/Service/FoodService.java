package com.Foodies.FoodDelivery.Service;

import com.Foodies.FoodDelivery.Entity.Food;
import com.Foodies.FoodDelivery.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food getFoodById(int id) {
        return foodRepository.findById(id).orElse(null);
    }

    public Food updateFoodById(int id, Food foodDetails) {
        Food existingFood = foodRepository.findById(id).orElse(null);
        if (existingFood != null) {
            existingFood.setName(foodDetails.getName());
            existingFood.setDescription(foodDetails.getDescription());
            existingFood.setCost(foodDetails.getCost());
            existingFood.setRestaurant(foodDetails.getRestaurant());
            return foodRepository.save(existingFood);
        }
        return null;
    }

    public void deleteFood(int id) {
        foodRepository.deleteById(id);
    }

    public void deleteAllFoods() {
        foodRepository.deleteAll();
    }
}
