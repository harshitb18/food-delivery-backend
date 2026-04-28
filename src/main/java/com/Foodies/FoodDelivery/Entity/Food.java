package com.Foodies.FoodDelivery.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;

    private String name;

    private String description;

    private float cost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnoreProperties("foods")
    private Restaurant restaurant;

    public Food() {
    }

    public Food(int foodId, String name, String description, float cost, Restaurant restaurant) {
        this.foodId = foodId;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.restaurant = restaurant;
    }

    public Food(String name, String description, float cost, Restaurant restaurant) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.restaurant = restaurant;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", restaurant=" + restaurant +
                '}';
    }
}