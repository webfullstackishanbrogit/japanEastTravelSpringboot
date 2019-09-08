package net.epic.review.repository.custom;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.DestinationsReviewDTO;
import net.epic.review.entity.DestinationsReview;

import java.util.List;

/**
 * Repository Custom Interface for the DestinationsReview Repository implementation
 * @author uditha
 */
public interface DestinationsReviewRepositoryCustom {
    public DestinationsReview saveReviewWithStars(DestinationsReviewDTO reviewDTO);
    public List<CommenStarReviewDTO> getAllStarRatings(Integer destinationId);
}
