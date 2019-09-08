package net.epic.review.repository;

import net.epic.review.entity.TransportationReview;
import net.epic.review.repository.custom.TransportationReviewRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository extended Interface for the TransportationReview
 * @author uditha
 */
public interface TransportationReviewRepository extends JpaRepository<TransportationReview,Integer>,TransportationReviewRepositoryCustom {
}
