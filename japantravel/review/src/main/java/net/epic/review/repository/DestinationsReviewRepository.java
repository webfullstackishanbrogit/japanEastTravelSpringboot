package net.epic.review.repository;

import net.epic.review.entity.DestinationsReview;
import net.epic.review.repository.custom.DestinationsReviewRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository extended Interface for the DestinationsReview
 * @author uditha
 */
public interface DestinationsReviewRepository extends JpaRepository<DestinationsReview,Integer>,DestinationsReviewRepositoryCustom {
}
