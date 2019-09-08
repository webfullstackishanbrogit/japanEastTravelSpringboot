package net.epic.restaurant.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestaurantItemImagesDTO implements Serializable {
    private Integer idrestaurantItemImages;
    private String imagePath;
    private RestaurantItemsDTO restaurantItemsId;
}
