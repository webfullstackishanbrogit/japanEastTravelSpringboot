package net.epic.review.controllers;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TrainpassesReviewDTO;
import net.epic.review.service.TrainpassesReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller class for the train passes review
 * @author uditha
 */
@RestController
@RequestMapping("/trainpass")
public class TrainpassesReviewController {

    private TrainpassesReviewService trainpassesReviewService;

    /**
     * controller method for get all train passes review
     * @return List of TrainpassesReviewDTO
     * @throws Exception can be throws on  trainpassesReviewService.getAllReviews() method
     */
    @GetMapping(value = "/all")
    public ResponseEntity<List<TrainpassesReviewDTO>> getAllReviews() throws Exception{
        List<TrainpassesReviewDTO> allUsers = trainpassesReviewService.getAllReviews();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    /**
     * controller method for get all ratings by hotel ID
     * @return List of CommenStarReviewDTO
     * @throws Exception can be throws on  hotelsReviewService.getAllStarRatings() method
     */
    @CrossOrigin("*")
    @GetMapping(value = "/allratings")
    public ResponseEntity<List<CommenStarReviewDTO>> getAllStarRatings() throws Exception {
        List<CommenStarReviewDTO> allUsers = trainpassesReviewService.getAllStarRatings(1);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    /**
     * controller method for save new train passes review
     * @param reviewDTO RequestBody TrainpassesReviewDTO
     * @return TrainpassesReviewDTO
     * @throws Exception can be throws on  trainpassesReviewService.addReview(reviewDTO) method
     */
    @PostMapping(value = "/add")
    public TrainpassesReviewDTO addReview(@RequestBody TrainpassesReviewDTO reviewDTO) throws Exception{
        return trainpassesReviewService.addReview(reviewDTO);
    }

    /**
     * controller method for update train passes review
     * @param reviewDTO  RequestBody  TrainpassesReviewDTO
     * @return TrainpassesReviewDTO
     * @throws Exception can be throws on  trainpassesReviewService.updateReview(reviewDTO) method
     */
    @PostMapping(value = "/update")
    public TrainpassesReviewDTO updateReview(@RequestBody TrainpassesReviewDTO reviewDTO) throws Exception{
        return  trainpassesReviewService.updateReview(reviewDTO);
    }

    /**
     * controller method for delete train passes review
     * @param id String trin passes id
     * @return boolean
     */
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteReview(@RequestParam("id") String id){
        return trainpassesReviewService.deleteReview(id);
    }

    /**
     * default constructor
     * @param trainpassesReviewService autowired defendence
     */
    @Autowired
    public TrainpassesReviewController(TrainpassesReviewService trainpassesReviewService) {
        this.trainpassesReviewService = trainpassesReviewService;
    }
}
