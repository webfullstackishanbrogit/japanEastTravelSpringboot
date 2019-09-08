package net.epic.review.repository;

import net.epic.review.entity.TourpackagesReview;
import net.epic.review.repository.custom.TourpackagesReviewRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * JpaRepository extended Interface for the TourpackagesReview
 * @author uditha
 */
public interface TourpackagesReviewRepository extends JpaRepository<TourpackagesReview,Integer>,TourpackagesReviewRepositoryCustom {
}
