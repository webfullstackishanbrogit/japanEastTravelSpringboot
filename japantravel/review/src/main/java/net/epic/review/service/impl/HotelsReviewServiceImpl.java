package net.epic.review.service.impl;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.HotelsReviewDTO;
import net.epic.review.entity.HotelsReview;
import net.epic.review.repository.HotelsReviewRepository;
import net.epic.review.service.HotelsReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Service class for the Hotels Review
 *
 * @author uditha
 */
@Service
public class HotelsReviewServiceImpl implements HotelsReviewService {


    private HotelsReviewRepository hotelsReviewRepository;

    /**
     * service method for the get all Review
     * @return List of HotelsReview
     */
    @Override
    @Transactional(readOnly = true)
    public List<HotelsReviewDTO> getAllReviews() {
        List<HotelsReview> all = hotelsReviewRepository.findAll();

        Locale locale = new Locale("en", "USA");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        List<HotelsReviewDTO> dtoList = new ArrayList<>();
        HotelsReviewDTO reviewDTO;
        for (HotelsReview review : all) {
            reviewDTO = new HotelsReviewDTO();
            reviewDTO.setComment(review.getComment());
            reviewDTO.setStarsReview(review.getStarsReview());
            reviewDTO.setUsername(review.getUsername());
            reviewDTO.setTitle(review.getTitle());
            reviewDTO.setDatetime(dateFormat.format(review.getDatetime()));

            dtoList.add(reviewDTO);
        }
        return dtoList;
    }

    /**
     * service method for the get All Star Ratings
     * @param hotelId Integer hotelId
     * @return List of CommenStarReviewDTO
     */
    @Override
    public List<CommenStarReviewDTO> getAllStarRatings(Integer hotelId){
        return hotelsReviewRepository.getAllStarRatings(hotelId);
    }

    /**
     * service method for the get All Star Ratings
     * @param reviewDTO HotelsReviewDTO
     * @return HotelsReviewDTO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public HotelsReviewDTO addReview(HotelsReviewDTO reviewDTO) {

        HotelsReview save = hotelsReviewRepository.saveReviewWithStars(reviewDTO);
        if (save != null) {
            return reviewDTO;
        } else {
            return null;
        }
    }

    /**
     * service method for the update Ratings
     * @param reviewDTO HotelsReviewDTO
     * @return HotelsReviewDTO
     */
    @Override
    @Transactional
    public HotelsReviewDTO updateReview(HotelsReviewDTO reviewDTO) {
        return reviewDTO;
    }

    /**
     * service method for the delete Ratings
     * @param id String hotel id
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteReview(String id) {
        hotelsReviewRepository.deleteById(Integer.parseInt(id));
        return true;
    }

    /**
     * default constructor
     * @param hotelsReviewRepository Autowired defendece
     */
    @Autowired
    public HotelsReviewServiceImpl(HotelsReviewRepository hotelsReviewRepository) {
        this.hotelsReviewRepository = hotelsReviewRepository;
    }
}
