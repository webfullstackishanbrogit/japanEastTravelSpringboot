package net.epic.destinations.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Data transfer object class for the DestinationImages
 * @author uditha
 */
@Data
public class DestinationImagesDTO implements Serializable {
    private Integer iddestinationImages;
    private String imagePathId;
    private Integer destinationId;
}
