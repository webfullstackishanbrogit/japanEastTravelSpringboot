package net.epic.review.service.impl;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.RestaurantsReviewDTO;
import net.epic.review.entity.RestaurantsReview;
import net.epic.review.repository.RestaurantsReviewRepository;
import net.epic.review.service.RestaurantsReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Service class for the Restaurants Review
 *
 * @author uditha
 */
@Service
public class RestaurantsReviewServiceImpl implements RestaurantsReviewService {

    private RestaurantsReviewRepository restaurantsReviewRepository;

    /**
     * service method for the get All Reviews
     *
     * @return List of RestaurantsReviewDTO
     */
    @Override
    @Transactional(readOnly = true)
    public List<RestaurantsReviewDTO> getAllReviews() {
        List<RestaurantsReview> all = restaurantsReviewRepository.findAll();
        Locale locale = new Locale("en", "USA");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        List<RestaurantsReviewDTO> dtoList = new ArrayList<>();
        RestaurantsReviewDTO reviewDTO;
        for (RestaurantsReview review : all) {
            reviewDTO = new RestaurantsReviewDTO();
            reviewDTO.setComment(review.getComment());
            reviewDTO.setStarsReview(review.getStarsReview());
            reviewDTO.setUsername(review.getUsername());
            reviewDTO.setTitle(review.getTitle());
            reviewDTO.setDatetime(dateFormat.format(review.getDatetime()));

            dtoList.add(reviewDTO);
        }
        return dtoList;
    }

    @Override
    public List<CommenStarReviewDTO> getAllStarRatings(Integer restaurantsId) {
        return restaurantsReviewRepository.getAllStarRatings(restaurantsId);
    }

    /**
     * service method for the save Reviews
     *
     * @param reviewDTO RestaurantsReviewDTO
     * @return RestaurantsReviewDTO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public RestaurantsReviewDTO addReview(RestaurantsReviewDTO reviewDTO) {

        RestaurantsReview save = restaurantsReviewRepository.saveReviewWithStars(reviewDTO);
        if (save != null) {
            return reviewDTO;
        } else {
            return null;
        }
    }

    /**
     * service method for the update Reviews
     *
     * @param reviewDTO RestaurantsReviewDTO
     * @return RestaurantsReviewDTO
     */
    @Override
    @Transactional
    public RestaurantsReviewDTO updateReview(RestaurantsReviewDTO reviewDTO){
        return reviewDTO;
    }

    /**
     * service method for the delete Reviews
     *
     * @param id String restaurant id
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteReview(String id) {
        restaurantsReviewRepository.deleteById(Integer.parseInt(id));
        return true;
    }

    /**
     * default constructor
     * @param restaurantsReviewRepository Autowired defendence
     */
    @Autowired
    public RestaurantsReviewServiceImpl(RestaurantsReviewRepository restaurantsReviewRepository) {
        this.restaurantsReviewRepository = restaurantsReviewRepository;
    }
}
