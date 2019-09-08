package net.epic.review.service.impl;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TourpackagesReviewDTO;
import net.epic.review.entity.TourpackagesReview;
import net.epic.review.repository.TourpackagesReviewRepository;
import net.epic.review.service.TourpackagesReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Service class for the TourpackagesReview Review
 * @author uditha
 */
@Service
public class TourpackagesReviewServiceImpl implements TourpackagesReviewService {

    private TourpackagesReviewRepository tourpackagesReviewRepository;

    /**
     * service method for the get all Reviews
     * @return  List of TourpackagesReviewDTO
     */
    @Override
    @Transactional(readOnly = true)
    public List<TourpackagesReviewDTO> getAllReviews() {
        List<TourpackagesReview> all = tourpackagesReviewRepository.findAll();

        Locale locale = new Locale("en", "USA");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        List<TourpackagesReviewDTO> dtoList = new ArrayList<>();
        TourpackagesReviewDTO reviewDTO;
        for (TourpackagesReview review : all) {
            reviewDTO = new TourpackagesReviewDTO();
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
    public List<CommenStarReviewDTO> getAllStarRatings(Integer tourpackagesId) {
        return tourpackagesReviewRepository.getAllStarRatings(tourpackagesId);
    }

    /**
     * service method for the save Reviews
     * @param reviewDTO TourpackagesReviewDTO
     * @return TourpackagesReviewDTO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TourpackagesReviewDTO addReview(TourpackagesReviewDTO reviewDTO){

        TourpackagesReview save = tourpackagesReviewRepository.saveReviewWithStars(reviewDTO);
        if (save != null) {
            return reviewDTO;
        } else {
            return null;
        }
    }

    /**
     * service method for the update Reviews
     * @param reviewDTO TourpackagesReviewDTO
     * @return TourpackagesReviewDTO
     * @throws Exception
     */
    @Override
    @Transactional
    public TourpackagesReviewDTO updateReview(TourpackagesReviewDTO reviewDTO) {
        return reviewDTO;
    }

    /**
     * service method for the delete Reviews
     * @param id String Tourpackages id
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteReview(String id) {
        tourpackagesReviewRepository.deleteById(Integer.parseInt(id));
        return true;
    }

    /**
     * default  constructor
     * @param tourpackagesReviewRepository Autowired defendence
     */
    @Autowired
    public TourpackagesReviewServiceImpl(TourpackagesReviewRepository tourpackagesReviewRepository) {
        this.tourpackagesReviewRepository = tourpackagesReviewRepository;
    }
}
