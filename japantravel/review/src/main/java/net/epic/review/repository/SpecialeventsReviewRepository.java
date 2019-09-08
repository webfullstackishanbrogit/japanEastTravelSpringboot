package net.epic.review.repository;

import net.epic.review.entity.SpecialeventsReview;
import net.epic.review.repository.custom.SpecialeventsReviewRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository extended Interface for the SpecialeventsReview
 * @author uditha
 */
public interface SpecialeventsReviewRepository extends JpaRepository<SpecialeventsReview,Integer>,SpecialeventsReviewRepositoryCustom {
}
