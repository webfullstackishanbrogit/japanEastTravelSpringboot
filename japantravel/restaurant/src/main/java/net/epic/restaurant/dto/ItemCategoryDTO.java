package net.epic.restaurant.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class ItemCategoryDTO implements Serializable {
    private Integer iditemCategory;
    private String itemCategoryName;
    private Boolean isEnable;
    private Collection<RestaurantItemsDTO> restaurantItemsCollection;
}
