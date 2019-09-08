package net.epic.restaurant.repository;

import net.epic.restaurant.entity.RestaurantItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantItemsRepository extends JpaRepository<RestaurantItems,Integer> {

    List<RestaurantItems> findAllByOrderByRankingDesc();

}
