package net.epic.destinations.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Data transfer object class for the Destination tags
 * @author uditha
 */
@Data
public class DestinationTagsDTO implements Serializable {

    private Integer iddestinationTags;
    private String tag;
    private String isEnable;
    private Integer destinationId;
}
