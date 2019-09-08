package net.epic.review.controllers;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.DestinationsReviewDTO;
import net.epic.review.service.DestinationsReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for the Destination Reviews
 *
 * @author uditha
 */
@RestController
@RequestMapping("/destination")
public class DestinationsReviewController {

    private DestinationsReviewService destinationsReviewService;

    Logger logger = LoggerFactory.getLogger(DestinationsReviewController.class);

    /**
     * Controller Method for get All Reviews
     * @return List of DestinationsReviewDTO
     * @throws Exception can be throws on destinationsReviewService.getAllReviews() method
     */

    @CrossOrigin("*")
    @GetMapping(value = "/all")
    public ResponseEntity<List<DestinationsReviewDTO>> getAllReviews() throws Exception {
        List<DestinationsReviewDTO> allUsers = destinationsReviewService.getAllReviews();
        logger.info("Controller-destination/all");

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    /**
     * Controller method for get All Ratings by destination Id
     * @return List of CommenStarReviewDTO
     * @throws Exception can be throws on destinationsReviewService.getAllStarRatings(destinationId) method
     */
    @CrossOrigin("*")
    @GetMapping(value = "/allratings")
    public ResponseEntity<List<CommenStarReviewDTO>> getAllStarRatings() throws Exception {
        List<CommenStarReviewDTO> allUsers = destinationsReviewService.getAllStarRatings(1);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    /**
     * Controller method for save new destination Review
     * @param reviewDTO  RequestBody DestinationsReviewDTO object
     * @return DestinationsReviewDTO Object
     * @throws Exception can be throws on destinationsReviewService.addReview(reviewDTO) method
     */
    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public DestinationsReviewDTO addReview(@RequestBody DestinationsReviewDTO reviewDTO) throws Exception {
        return destinationsReviewService.addReview(reviewDTO);
    }

    /**
     * Controller method for update destination review
     * @param reviewDTO RequestBody DestinationsReviewDTO object
     * @return DestinationsReviewDTO Object
     * @throws Exception  can be throws on destinationsReviewService.updateReview(reviewDTO) method
     */
    @CrossOrigin("*")
    @PostMapping(value = "/update")
    public DestinationsReviewDTO updateReview(@RequestBody DestinationsReviewDTO reviewDTO) throws Exception {
        return destinationsReviewService.updateReview(reviewDTO);

    }

    /**
     * controller method for delete destination review
     * @param id String destination ID
     * @return boolean
     */
    @CrossOrigin("*")
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteReview(@RequestParam("id") String id) {
        return destinationsReviewService.deleteReview(id);
    }

    /**
     * Default constructor
     * @param destinationsReviewService spring autowired defendence
     */
    @Autowired
    public DestinationsReviewController(DestinationsReviewService destinationsReviewService) {
        this.destinationsReviewService = destinationsReviewService;
    }

}
