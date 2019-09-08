package net.epic.review.service.impl;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TrainpassesReviewDTO;
import net.epic.review.entity.TrainpassesReview;
import net.epic.review.repository.TrainpassesReviewRepository;
import net.epic.review.service.TrainpassesReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Service class for the Trainpasses Review
 * @author uditha
 */
@Service
public class TrainpassesReviewServiceImpl implements TrainpassesReviewService {

    private TrainpassesReviewRepository trainpassesReviewRepository;

    /**
     * service method for the get all Reviews
     * @return  List of TrainpassesReviewDTO
     */
    @Override
    @Transactional(readOnly = true)
    public List<TrainpassesReviewDTO> getAllReviews()  {
        List<TrainpassesReview> all = trainpassesReviewRepository.findAll();

        Locale locale = new Locale("en", "USA");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        List<TrainpassesReviewDTO> dtoList = new ArrayList<>();
        TrainpassesReviewDTO reviewDTO;
        for (TrainpassesReview review : all) {
            reviewDTO = new TrainpassesReviewDTO();
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
    public List<CommenStarReviewDTO> getAllStarRatings(Integer trainpassesId) {
        return trainpassesReviewRepository.getAllStarRatings(trainpassesId);
    }

    /**
     * service method for the save new Reviews
     * @param reviewDTO TrainpassesReviewDTO
     * @return TrainpassesReviewDTO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TrainpassesReviewDTO addReview(TrainpassesReviewDTO reviewDTO) {

        TrainpassesReview save = trainpassesReviewRepository.saveReviewWithStars(reviewDTO);
        if (save != null) {
            return reviewDTO;
        } else {
            return null;
        }
    }

    /**
     * service method for the update new Reviews
     * @param reviewDTO TrainpassesReviewDTO
     * @return TrainpassesReviewDTO
     */
    @Override
    @Transactional
    public TrainpassesReviewDTO updateReview(TrainpassesReviewDTO reviewDTO)  {
        return reviewDTO;
    }

    /**
     * service method for the delete Reviews
     * @param id string Trainpasses iD
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteReview(String id) {
        trainpassesReviewRepository.deleteById(Integer.parseInt(id));
        return true;
    }

    /**
     * default constructor
     * @param trainpassesReviewRepository Autowired defendence
     */
    @Autowired
    public TrainpassesReviewServiceImpl(TrainpassesReviewRepository trainpassesReviewRepository) {
        this.trainpassesReviewRepository = trainpassesReviewRepository;
    }
}
