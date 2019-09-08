package net.epic.restaurant.service;

import net.epic.restaurant.dto.RestaurantItemsDTO;
import net.epic.restaurant.dto.RestaurantsDTO;

import java.util.List;

public interface RestaurantService {
    RestaurantsDTO addRestaurant(RestaurantsDTO dto);
    RestaurantItemsDTO addRestaurantItem(RestaurantItemsDTO dto);
    List<RestaurantItemsDTO> getAllItems() ;
}