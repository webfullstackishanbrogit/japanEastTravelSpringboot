package net.epic.restaurant.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RestaurantItemsDTO implements Serializable {
    private Integer idrestaurantItems;
    private String itemName;
    private String introduction;
    private String description;
    private double price;
    private ItemCategoryDTO itemCategoryId;
    private List<RestaurantItemImagesDTO> restaurantItemImagesCollection;
    private Double ranking;
    private RestaurantsDTO restaurantId;
}
