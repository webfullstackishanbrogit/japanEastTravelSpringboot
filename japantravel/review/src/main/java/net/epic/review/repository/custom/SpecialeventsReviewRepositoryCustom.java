package net.epic.review.repository.custom;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.SpecialeventsReviewDTO;
import net.epic.review.entity.SpecialeventsReview;

import java.util.List;

/**
 * Repository Custom Interface for the SpecialeventsReview Repository implementation
 * @author uditha
 */
public interface SpecialeventsReviewRepositoryCustom {
    public SpecialeventsReview saveReviewWithStars(SpecialeventsReviewDTO reviewDTO);
    public List<CommenStarReviewDTO> getAllStarRatings(Integer specialeventsId);
}
