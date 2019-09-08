package net.epic.review.repository.custom;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TrainpassesReviewDTO;
import net.epic.review.entity.TrainpassesReview;

import java.util.List;

/**
 * Repository Custom Interface for the TrainpassesReview Repository implementation
 * @author uditha
 */
public interface TrainpassesReviewRepositoryCustom {
    public TrainpassesReview saveReviewWithStars(TrainpassesReviewDTO reviewDTO);
    public List<CommenStarReviewDTO> getAllStarRatings(Integer trainpassesId);
}
