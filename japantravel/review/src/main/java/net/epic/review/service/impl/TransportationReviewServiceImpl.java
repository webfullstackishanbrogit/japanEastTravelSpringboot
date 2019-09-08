package net.epic.review.service.impl;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TransportationReviewDTO;
import net.epic.review.entity.TransportationReview;
import net.epic.review.repository.TransportationReviewRepository;
import net.epic.review.service.TransportationReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Service class for the Transportation Review
 * @author uditha
 */
@Service
public class TransportationReviewServiceImpl implements TransportationReviewService {

    private TransportationReviewRepository transportationReviewRepository;

    /**
     * service method for the get all Reviews
     * @return List of TransportationReviewDTO
     */
    @Override
    @Transactional(readOnly = true)
    public List<TransportationReviewDTO> getAllReviews()  {
        List<TransportationReview> all = transportationReviewRepository.findAll();

        Locale locale = new Locale("en", "USA");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        List<TransportationReviewDTO> dtoList = new ArrayList<>();
        TransportationReviewDTO reviewDTO;
        for (TransportationReview review : all) {
            reviewDTO = new TransportationReviewDTO();
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
    public List<CommenStarReviewDTO> getAllStarRatings(Integer transportationId) {
        return transportationReviewRepository.getAllStarRatings(transportationId);
    }

    /**
     * service method for the add Reviews
     * @param reviewDTO TransportationReviewDTO
     * @return TransportationReviewDTO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TransportationReviewDTO addReview(TransportationReviewDTO reviewDTO){

        TransportationReview save = transportationReviewRepository.saveReviewWithStars(reviewDTO);
        if (save != null) {
            return reviewDTO;
        } else {
            return null;
        }
    }

    /**
     * service method for the update Reviews
     * @param reviewDTO TransportationReviewDTO
     * @return TransportationReviewDTO
     */
    @Override
    @Transactional
    public TransportationReviewDTO updateReview(TransportationReviewDTO reviewDTO)  {
        return reviewDTO;
    }

    /**
     * service method for the delete Reviews
     * @param id String TransportationReview id
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteReview(String id) {
        transportationReviewRepository.deleteById(Integer.parseInt(id));
        return true;
    }

    /**
     * default constructor
     * @param transportationReviewRepository Autowired defendence
     */
    @Autowired
    public TransportationReviewServiceImpl(TransportationReviewRepository transportationReviewRepository) {
        this.transportationReviewRepository = transportationReviewRepository;
    }
}
