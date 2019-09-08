package net.epic.destinations.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Data transfer object class for the destinations
 * @author uditha
 */
@Data
public class DestinationDTO implements Serializable {
    private Integer iddestination;
    private String title;
    private String description;
    private String address;
    private String country;
    private Integer countryId;
    private Integer destrictId;
    private Double latitude;
    private Double longitude;
    private Double ranking;
    private List<DestinationTagsDTO> destinationTagsCollection;
    private List<DestinationImagesDTO> destinationImagesCollection;
}
