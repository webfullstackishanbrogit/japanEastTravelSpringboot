package net.epic.review.service.impl;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.SpecialeventsReviewDTO;
import net.epic.review.entity.SpecialeventsReview;
import net.epic.review.repository.SpecialeventsReviewRepository;
import net.epic.review.service.SpecialeventsReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Service class for the Specialevents Review
 * @author uditha
 */
@Service
public class SpecialeventsReviewServiceImpl implements SpecialeventsReviewService {

    private SpecialeventsReviewRepository specialeventsReviewRepository;

    /**
     * service method for the get all Reviews
     * @return  List of SpecialeventsReviewDTO
     */
    @Override
    @Transactional(readOnly = true)
    public List<SpecialeventsReviewDTO> getAllReviews(){
        List<SpecialeventsReview> all = specialeventsReviewRepository.findAll();


        Locale locale = new Locale("en", "USA");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        List<SpecialeventsReviewDTO> dtoList = new ArrayList<>();
        SpecialeventsReviewDTO reviewDTO;
        for (SpecialeventsReview review : all) {
            reviewDTO = new SpecialeventsReviewDTO();
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
    public List<CommenStarReviewDTO> getAllStarRatings(Integer hotelId) {
        return specialeventsReviewRepository.getAllStarRatings(hotelId);
    }

    /**
     * service method for the save Reviews
     * @param reviewDTO SpecialeventsReviewDTO
     * @return SpecialeventsReviewDTO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SpecialeventsReviewDTO addReview(SpecialeventsReviewDTO reviewDTO) {

        SpecialeventsReview save = specialeventsReviewRepository.saveReviewWithStars(reviewDTO);
        if (save != null) {
            return reviewDTO;
        } else {
            return null;
        }
    }

    /**
     *  service method for the update Reviews
     * @param reviewDTO SpecialeventsReviewDTO
     * @return SpecialeventsReviewDTO
     */
    @Override
    @Transactional
    public SpecialeventsReviewDTO updateReview(SpecialeventsReviewDTO reviewDTO) {
        return reviewDTO;
    }

    /**
     * service method for the delete Reviews
     * @param id  String special event id
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteReview(String id) {
        specialeventsReviewRepository.deleteById(Integer.parseInt(id));
        return true;
    }

    /**
     * default constructor
     * @param specialeventsReviewRepository Autowired defendence
     */
    @Autowired
    public SpecialeventsReviewServiceImpl(SpecialeventsReviewRepository specialeventsReviewRepository) {
        this.specialeventsReviewRepository = specialeventsReviewRepository;
    }
}
