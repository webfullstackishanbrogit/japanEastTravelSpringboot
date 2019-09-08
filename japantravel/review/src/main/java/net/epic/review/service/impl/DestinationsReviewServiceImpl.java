package net.epic.review.service.impl;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.DestinationsReviewDTO;
import net.epic.review.entity.DestinationsReview;
import net.epic.review.repository.DestinationsReviewRepository;
import net.epic.review.service.DestinationsReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Service class for the Destinations Review
 *
 * @author uditha
 */
@Service
public class DestinationsReviewServiceImpl implements DestinationsReviewService {

    private DestinationsReviewRepository destinationsReviewRepository;

    /**
     * service method for the get all reviews
     * @return List of DestinationsReviewDTO
     */
    @Override
    @Transactional(readOnly = true)
    public List<DestinationsReviewDTO> getAllReviews() {
        List<DestinationsReview> all = destinationsReviewRepository.findAll();

        Locale locale = new Locale("en", "USA");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        List<DestinationsReviewDTO> dtoList = new ArrayList<>();
        DestinationsReviewDTO reviewDTO;
        for (DestinationsReview review : all) {
            reviewDTO = new DestinationsReviewDTO();
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
     * service method for the get all StarRatings
     * @param destinationId  destination Id
     * @return List CommenStarReviewDTO
     * @throws Exception  can be throws on destinationsReviewRepository.getAllStarRatings(destinationId) method
     */
    @Override
    public List<CommenStarReviewDTO> getAllStarRatings(Integer destinationId){
       return destinationsReviewRepository.getAllStarRatings(destinationId);
    }

    /**
     * service method for the add Review
     * @param reviewDTO DestinationsReviewDTO
     * @return DestinationsReviewDTO
     * @throws Exception can be throws on destinationsReviewRepository.saveReviewWithStars(reviewDTO) method
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public DestinationsReviewDTO addReview(DestinationsReviewDTO reviewDTO) {

        DestinationsReview save = destinationsReviewRepository.saveReviewWithStars(reviewDTO);
        if (save != null) {
            return reviewDTO;
        } else {
            return null;
        }
    }

    /**
     * service method for the updateReview Review
     * @param reviewDTO DestinationsReviewDTO
     * @return DestinationsReviewDTO
     * @throws Exception
     */
    @Override
    @Transactional
    public DestinationsReviewDTO updateReview(DestinationsReviewDTO reviewDTO) {
        return reviewDTO;
    }

    /**
     * service method for the delete Review
     * @param id String destination id
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteReview(String id) {
        destinationsReviewRepository.deleteById(Integer.parseInt(id));
        return true;
    }

    /**
     * default constructor
     * @param destinationsReviewRepository autowired defendece
     */
    @Autowired
    public DestinationsReviewServiceImpl(DestinationsReviewRepository destinationsReviewRepository) {
        this.destinationsReviewRepository = destinationsReviewRepository;
    }
}
