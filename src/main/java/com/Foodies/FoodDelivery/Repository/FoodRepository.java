package com.Foodies.FoodDelivery.Repository;

import com.Foodies.FoodDelivery.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

}
