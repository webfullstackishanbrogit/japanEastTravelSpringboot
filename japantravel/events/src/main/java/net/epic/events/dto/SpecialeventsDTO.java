package net.epic.events.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Dto class for  Specialevents
 * @author uditha 
 */
@Data
public class SpecialeventsDTO implements Serializable {
    private Integer idspecialevents;
    private String title;
    private String description;
    private String address;
    private Double latitude;
    private Double longitude;
    private Double ranking;
    private Integer locationId;
    private String eventDate;
    private List<SpecialeventsTagsDTO> specialeventsTagsCollection;
    private List<SpecialeventsImagesDTO> specialeventsImagesCollection;

}
