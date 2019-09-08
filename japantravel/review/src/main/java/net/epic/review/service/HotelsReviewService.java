package net.epic.review.service;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.HotelsReviewDTO;

import java.util.List;

/**
 * Interface
 * @author uditha
 */
public interface HotelsReviewService {
    List<HotelsReviewDTO> getAllReviews();

    List<CommenStarReviewDTO> getAllStarRatings(Integer hotelId);

    HotelsReviewDTO addReview(HotelsReviewDTO reviewDTO);

    HotelsReviewDTO updateReview(HotelsReviewDTO reviewDTO);

    public boolean deleteReview(String id);
}
