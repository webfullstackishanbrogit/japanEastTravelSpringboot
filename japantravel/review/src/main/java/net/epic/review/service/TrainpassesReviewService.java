package net.epic.review.service;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TrainpassesReviewDTO;

import java.util.List;

/**
 * Interface
 * @author uditha
 */
public interface TrainpassesReviewService {

    List<TrainpassesReviewDTO> getAllReviews();

    List<CommenStarReviewDTO> getAllStarRatings(Integer trainpassesId);

    TrainpassesReviewDTO addReview(TrainpassesReviewDTO reviewDTO);

    TrainpassesReviewDTO updateReview(TrainpassesReviewDTO reviewDTO);

    public boolean deleteReview(String id);
}
