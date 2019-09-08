package net.epic.review.service;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.SpecialeventsReviewDTO;

import java.util.List;

/**
 * Interface
 * @author uditha
 */
public interface SpecialeventsReviewService {

    List<SpecialeventsReviewDTO> getAllReviews();

    List<CommenStarReviewDTO> getAllStarRatings(Integer hotelId);
    
    SpecialeventsReviewDTO addReview(SpecialeventsReviewDTO reviewDTO);

    SpecialeventsReviewDTO updateReview(SpecialeventsReviewDTO reviewDTO);

    public boolean deleteReview(String id);
}
