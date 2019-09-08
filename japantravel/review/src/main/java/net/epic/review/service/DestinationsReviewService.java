package net.epic.review.service;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.DestinationsReviewDTO;

import java.util.List;

/**
 * Interface
 * @author uditha
 */
public interface DestinationsReviewService {

    List<DestinationsReviewDTO> getAllReviews() ;

    List<CommenStarReviewDTO> getAllStarRatings(Integer destinationId);

    DestinationsReviewDTO addReview(DestinationsReviewDTO reviewDTO);

    DestinationsReviewDTO updateReview(DestinationsReviewDTO reviewDTO);

    public boolean deleteReview(String id);


}
