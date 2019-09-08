package net.epic.review.repository;

import net.epic.review.entity.TrainpassesReview;
import net.epic.review.repository.custom.TrainpassesReviewRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository extended Interface for the TrainpassesReview
 * @author uditha
 */
public interface TrainpassesReviewRepository extends JpaRepository<TrainpassesReview,Integer>,TrainpassesReviewRepositoryCustom {
}
