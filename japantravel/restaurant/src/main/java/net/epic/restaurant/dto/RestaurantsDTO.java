package net.epic.restaurant.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestaurantsDTO  implements Serializable {
    private Integer idrestaurants;
    private String restaurantsName;
    private Double ranking;
    private String description;
    private Integer countryId;
    private Integer districtId;
    private Double latitude;
    private Double longitude;
}
