package com.Foodies.FoodDelivery.Repository;

import com.Foodies.FoodDelivery.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}