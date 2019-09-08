package net.epic.review.service;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TourpackagesReviewDTO;

import java.util.List;

/**
 * Interface
 * @author uditha
 */
public interface TourpackagesReviewService {
    List<TourpackagesReviewDTO> getAllReviews();

    List<CommenStarReviewDTO> getAllStarRatings(Integer tourpackagesId);

    TourpackagesReviewDTO addReview(TourpackagesReviewDTO reviewDTO);

    TourpackagesReviewDTO updateReview(TourpackagesReviewDTO reviewDTO);

    public boolean deleteReview(String id);
}
