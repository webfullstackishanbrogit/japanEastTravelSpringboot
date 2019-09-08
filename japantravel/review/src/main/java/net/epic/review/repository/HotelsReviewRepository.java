package net.epic.review.repository;

import net.epic.review.entity.HotelsReview;
import net.epic.review.repository.custom.HotelsReviewRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository extended Interface for the HotelsReview
 * @author uditha
 */
public interface HotelsReviewRepository extends JpaRepository<HotelsReview,Integer>, HotelsReviewRepositoryCustom {
}
