package net.epic.review.service;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.ExperienceReviewDTO;

import java.util.List;

/**
 * Interface
 * @author uditha
 */
public interface ExperienceReviewService {

    List<ExperienceReviewDTO> getAllReviews();

    List<CommenStarReviewDTO> getAllStarRatings(Integer experiencelId);

    ExperienceReviewDTO addReview(ExperienceReviewDTO reviewDTO);

    ExperienceReviewDTO updateReview(ExperienceReviewDTO reviewDTO);

    public boolean deleteReview(String id);
}
