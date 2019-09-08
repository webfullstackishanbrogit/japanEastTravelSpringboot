package net.epic.review.repository.custom;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TourpackagesReviewDTO;
import net.epic.review.entity.TourpackagesReview;

import java.util.List;

/**
 * Repository Custom Interface for the TourpackagesReview Repository implementation
 * @author uditha
 */
public interface TourpackagesReviewRepositoryCustom {
    public TourpackagesReview saveReviewWithStars(TourpackagesReviewDTO reviewDTO);
    public List<CommenStarReviewDTO> getAllStarRatings(Integer tourpackagesId);
}
