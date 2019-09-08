package net.epic.events.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Dto class for the SpecialeventsTags
 * @author uditha
 */
@Data
public class SpecialeventsTagsDTO implements Serializable {
    private Integer idspecialeventsTags;
    private String tag;
    private boolean isEnable;
    private Integer specialeventsId;
}
