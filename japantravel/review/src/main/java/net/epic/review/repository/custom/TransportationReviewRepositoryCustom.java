package net.epic.review.repository.custom;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TransportationReviewDTO;
import net.epic.review.entity.TransportationReview;

import java.util.List;

/**
 * Repository Custom Interface for the TransportationReview Repository implementation
 * @author uditha
 */
public interface TransportationReviewRepositoryCustom {
    public TransportationReview saveReviewWithStars(TransportationReviewDTO reviewDTO);
    public List<CommenStarReviewDTO> getAllStarRatings(Integer transportationId);
}
