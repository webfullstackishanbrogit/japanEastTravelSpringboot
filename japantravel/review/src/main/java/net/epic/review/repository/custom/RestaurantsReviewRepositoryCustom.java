package net.epic.review.repository.custom;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.RestaurantsReviewDTO;
import net.epic.review.entity.RestaurantsReview;

import java.util.List;

/**
 * Repository Custom Interface for the RestaurantsReview Repository implementation
 * @author uditha
 */
public interface RestaurantsReviewRepositoryCustom {
    public RestaurantsReview saveReviewWithStars(RestaurantsReviewDTO reviewDTO);
    public List<CommenStarReviewDTO> getAllStarRatings(Integer restaurantsId);
}
