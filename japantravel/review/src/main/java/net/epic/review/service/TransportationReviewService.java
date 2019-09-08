package net.epic.review.service;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TransportationReviewDTO;

import java.util.List;

/**
 * Interface
 * @author uditha
 */
public interface TransportationReviewService {

    List<TransportationReviewDTO> getAllReviews();

    List<CommenStarReviewDTO> getAllStarRatings(Integer transportationId);

    TransportationReviewDTO addReview(TransportationReviewDTO reviewDTO);

    TransportationReviewDTO updateReview(TransportationReviewDTO reviewDTO);

    public boolean deleteReview(String id);

}
