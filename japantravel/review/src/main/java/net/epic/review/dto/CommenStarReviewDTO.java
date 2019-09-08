package net.epic.review.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Data Transfer Object Class DTO
 * @author uditha
 */
@Data
public class CommenStarReviewDTO implements Serializable {

    private Integer typeRatingId;
    private Integer starCount;
    private Integer reviewTypeId;
    private Integer reviewId;
    private String type;
    private String category;
    private Double avarage;
    private Double totalReviewsCount;

}
