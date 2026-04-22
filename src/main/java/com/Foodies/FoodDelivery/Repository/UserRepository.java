package com.Foodies.FoodDelivery.Repository;

import com.Foodies.FoodDelivery.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>  {

}
