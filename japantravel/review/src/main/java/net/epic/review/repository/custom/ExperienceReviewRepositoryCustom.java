package net.epic.review.repository.custom;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.ExperienceReviewDTO;
import net.epic.review.entity.ExperienceReview;

import java.util.List;

/**
 * Repository Custom Interface for the ExperienceReview Repository implementation
 * @author uditha
 */
public interface ExperienceReviewRepositoryCustom {
    public ExperienceReview saveReviewWithStars(ExperienceReviewDTO reviewDTO);
    public List<CommenStarReviewDTO> getAllStarRatings(Integer experiencelId);
}
