package net.epic.review.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Data Transfer Object Class DTO
 * @author uditha
 */
@Data
public class TransportationReviewDTO implements Serializable {
    private Integer idtransportationReview;
    private Integer transportationId;
    private int userId;
    private String username;
    private int starsReview;
    private String comment;
    private String datetime;
    private String isUpdated;
    private String isApproved;
    private String title;
    private List<CommenStarReviewDTO> reviewDTOlist;

}
