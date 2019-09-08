package net.epic.review.service;


import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.RestaurantsReviewDTO;

import java.util.List;

/**
 * Interface
 * @author uditha
 */
public interface RestaurantsReviewService {
    List<RestaurantsReviewDTO> getAllReviews();

    List<CommenStarReviewDTO> getAllStarRatings(Integer  restaurantsId);

    RestaurantsReviewDTO addReview(RestaurantsReviewDTO reviewDTO);

    RestaurantsReviewDTO updateReview(RestaurantsReviewDTO reviewDTO);

    public boolean deleteReview(String id);
}
