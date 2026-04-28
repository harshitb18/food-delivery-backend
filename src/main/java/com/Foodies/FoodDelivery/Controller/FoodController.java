package com.Foodies.FoodDelivery.Controller;

import com.Foodies.FoodDelivery.Entity.Food;
import com.Foodies.FoodDelivery.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public Food saveFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable int id) {
        return foodService.getFoodById(id);
    }

    @PutMapping("/{id}")
    public Food updateFoodById(@PathVariable int id, @RequestBody Food food) {
        return foodService.updateFoodById(id, food);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable int id) {
        foodService.deleteFood(id);
    }

    @DeleteMapping
    public void deleteAllFoods() {
        foodService.deleteAllFoods();
    }
}
