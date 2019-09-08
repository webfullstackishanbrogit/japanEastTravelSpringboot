package net.epic.events.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Dto class for the SpecialeventsImagesDTO
 * @author uditha
 */
@Data
public class SpecialeventsImagesDTO implements Serializable {
    private Integer idspecialeventsImages;
    private String imagePathId;
    private Integer specialeventId;
}
