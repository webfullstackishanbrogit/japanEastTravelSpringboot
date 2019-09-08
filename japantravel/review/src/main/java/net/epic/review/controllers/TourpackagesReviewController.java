package net.epic.review.controllers;


import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TourpackagesReviewDTO;
import net.epic.review.service.TourpackagesReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for tour Packages Review
 * @author uditha
 */
@RestController
@RequestMapping("/tourpackage")
public class TourpackagesReviewController {

    private TourpackagesReviewService tourpackagesReviewService;

    /**
     * controller method for get all tour package reviews
     * @return List of TourpackagesReviewDTO
     * @throws Exception can be throws on tourpackagesReviewService.getAllReviews() method
     */
    @GetMapping(value = "/all")
    public ResponseEntity<List<TourpackagesReviewDTO>> getAllReviews() throws Exception {
        List<TourpackagesReviewDTO> allUsers = tourpackagesReviewService.getAllReviews();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    /**
     * controller method for get all ratings by tourpackages ID
     * @return List of CommenStarReviewDTO
     * @throws Exception can be throws on  hotelsReviewService.getAllStarRatings() method
     */
    @CrossOrigin("*")
    @GetMapping(value = "/allratings")
    public ResponseEntity<List<CommenStarReviewDTO>> getAllStarRatings() throws Exception {
        List<CommenStarReviewDTO> allUsers = tourpackagesReviewService.getAllStarRatings(1);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    /**
     * controller method for save new tour package review
     * @param reviewDTO RequestBody TourpackagesReviewDTO object
     * @return TourpackagesReviewDTO object
     * @throws Exception can be throws on tourpackagesReviewService.addReview(reviewDTO) method
     */
    @PostMapping(value = "/add")
    public TourpackagesReviewDTO addReview(@RequestBody TourpackagesReviewDTO reviewDTO) throws Exception {
        return tourpackagesReviewService.addReview(reviewDTO);
    }

    /**
     * controller method for update tour packages review
     * @param reviewDTO RequestBody TourpackagesReviewDTO
     * @return TourpackagesReviewDTO object
     * @throws Exception
     */
    @PostMapping(value = "/update")
    public TourpackagesReviewDTO updateReview(@RequestBody TourpackagesReviewDTO reviewDTO) throws Exception {
        return tourpackagesReviewService.updateReview(reviewDTO);
    }

    /**
     * controller method for delete tourpackage review
     * @param id String tour package Id
     * @return boolean
     */
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteReview(@RequestParam("id") String id) {
        return tourpackagesReviewService.deleteReview(id);
    }

    /**
     * default constructor
     * @param tourpackagesReviewService autowired defendece
     */
    @Autowired
    public TourpackagesReviewController(TourpackagesReviewService tourpackagesReviewService) {
        this.tourpackagesReviewService = tourpackagesReviewService;
    }
}
