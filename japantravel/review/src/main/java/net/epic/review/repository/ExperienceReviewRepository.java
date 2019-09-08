package net.epic.review.repository;

import net.epic.review.entity.ExperienceReview;
import net.epic.review.repository.custom.ExperienceReviewRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository extended Interface for the ExperienceReview
 * @author uditha
 */
public interface ExperienceReviewRepository extends JpaRepository<ExperienceReview,Integer>,ExperienceReviewRepositoryCustom {
}
