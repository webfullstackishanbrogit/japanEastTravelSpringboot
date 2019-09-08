package net.epic.review.service.impl;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.ExperienceReviewDTO;
import net.epic.review.entity.ExperienceReview;
import net.epic.review.repository.ExperienceReviewRepository;
import net.epic.review.service.ExperienceReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Service class for the Experience Review
 * @author uditha
 */
@Service
public class ExperienceReviewServiceImpl implements ExperienceReviewService {

    private ExperienceReviewRepository experienceReviewRepository;

    /**
     * service method for the get all Review
     * @return List of ExperienceReviewDTO
     * @throws Exception can be throws on experienceReviewRepository.findAll() method
     */
    @Override
    @Transactional(readOnly = true)
    public List<ExperienceReviewDTO> getAllReviews() {
        List<ExperienceReview> all = experienceReviewRepository.findAll();

        Locale locale = new Locale("en", "USA");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        List<ExperienceReviewDTO> dtoList = new ArrayList<>();
        ExperienceReviewDTO reviewDTO;
        for (ExperienceReview review : all) {
            reviewDTO = new ExperienceReviewDTO();
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
     * @param experiencelId Integer experiencelId
     * @return List of CommenStarReviewDTO
     */
    @Override
    public List<CommenStarReviewDTO> getAllStarRatings(Integer experiencelId) {
        return experienceReviewRepository.getAllStarRatings(experiencelId);
    }

    /**
     * service method for the get save Review
     * @param reviewDTO ExperienceReviewDTO
     * @return ExperienceReviewDTO
     * @throws Exception can be throws on experienceReviewRepository.save(review) method
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ExperienceReviewDTO addReview(ExperienceReviewDTO reviewDTO) {

        ExperienceReview save = experienceReviewRepository.saveReviewWithStars(reviewDTO);
        if (save != null) {
            return reviewDTO;
        } else {
            return null;
        }
    }

    /**
     * service method for the get update Review
     * @param reviewDTO ExperienceReviewDTO
     * @return ExperienceReviewDTO
     * @throws Exception
     */
    @Override
    @Transactional
    public ExperienceReviewDTO updateReview(ExperienceReviewDTO reviewDTO){
        return reviewDTO;
    }

    /**
     * service method for the get delete Review
     * @param id String experience id
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteReview(String id) {
        experienceReviewRepository.deleteById(Integer.parseInt(id));
        return true;
    }

    /**
     * default constructor
     * @param experienceReviewRepository autowired defendence
     */
    @Autowired
    public ExperienceReviewServiceImpl(ExperienceReviewRepository experienceReviewRepository) {
        this.experienceReviewRepository = experienceReviewRepository;
    }
}
