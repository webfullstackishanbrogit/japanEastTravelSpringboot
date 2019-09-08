package net.epic.review.repository;

import net.epic.review.entity.RestaurantsReview;
import net.epic.review.repository.custom.RestaurantsReviewRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * JpaRepository extended Interface for the RestaurantsReview
 * @author uditha
 */
public interface RestaurantsReviewRepository extends JpaRepository<RestaurantsReview,Integer> ,RestaurantsReviewRepositoryCustom {
}
