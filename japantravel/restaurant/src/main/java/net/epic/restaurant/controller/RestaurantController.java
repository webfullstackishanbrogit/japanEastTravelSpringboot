package net.epic.restaurant.controller;

import net.epic.restaurant.dto.RestaurantItemsDTO;
import net.epic.restaurant.dto.RestaurantsDTO;
import net.epic.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private RestaurantService restaurantService;

    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public RestaurantsDTO addRestaurant(@RequestBody RestaurantsDTO dto) {
        return restaurantService.addRestaurant(dto);
    }

    @CrossOrigin("*")
    @PostMapping(value = "/additem")
    public RestaurantItemsDTO addRestaurantItem(@RequestBody RestaurantItemsDTO dto) {
        return restaurantService.addRestaurantItem(dto);
    }


    @CrossOrigin("*")
    @GetMapping(value = "/allitems")
    public ResponseEntity<List<RestaurantItemsDTO>> getAllRestaurantItems() {
        List<RestaurantItemsDTO> allUsers = restaurantService.getAllItems();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    
}
