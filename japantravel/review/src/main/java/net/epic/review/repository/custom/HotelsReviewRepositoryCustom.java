package net.epic.review.repository.custom;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.HotelsReviewDTO;
import net.epic.review.entity.HotelsReview;

import java.util.List;

/**
 * Repository Custom Interface for the  HotelsReview Repository implementation
 * @author uditha
 */
public interface HotelsReviewRepositoryCustom {
    public HotelsReview saveReviewWithStars(HotelsReviewDTO reviewDTO);
    public List<CommenStarReviewDTO> getAllStarRatings(Integer hotelId);
}
