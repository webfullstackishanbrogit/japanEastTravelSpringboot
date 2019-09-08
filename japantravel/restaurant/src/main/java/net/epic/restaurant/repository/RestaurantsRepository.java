package net.epic.restaurant.repository;

import net.epic.restaurant.entity.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantsRepository extends JpaRepository<Restaurants,Integer> {
}
