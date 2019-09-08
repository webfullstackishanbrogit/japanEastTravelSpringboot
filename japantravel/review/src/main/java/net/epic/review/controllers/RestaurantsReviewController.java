package net.epic.review.controllers;


import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.RestaurantsReviewDTO;
import net.epic.review.service.RestaurantsReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for restaurant Reviews
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/restaurant")
public class RestaurantsReviewController {

    private RestaurantsReviewService restaurantsReviewService;

    /**
     * controller method for get all restaurant reviews
     * @return  List of RestaurantsReviewDTO
     * @throws Exception can be throws on  restaurantsReviewService.getAllReviews() method
     */
    @GetMapping(value = "/all")
    public ResponseEntity<List<RestaurantsReviewDTO>> getAllReviews() throws Exception{
        List<RestaurantsReviewDTO> allUsers = restaurantsReviewService.getAllReviews();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    /**
     * controller method for get all ratings by restaurants ID
     * @return List of CommenStarReviewDTO
     * @throws Exception can be throws on  hotelsReviewService.getAllStarRatings() method
     */
    @CrossOrigin("*")
    @GetMapping(value = "/allratings")
    public ResponseEntity<List<CommenStarReviewDTO>> getAllStarRatings() throws Exception {
        List<CommenStarReviewDTO> allUsers = restaurantsReviewService.getAllStarRatings(1);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    /**
     * controller method for save new restaurant review
     * @param reviewDTO RequestBody RestaurantsReviewDTO object
     * @return RestaurantsReviewDTO object
     * @throws Exception can be throws on  restaurantsReviewService.addReview(reviewDTO) method
     */
    @PostMapping(value = "/add")
    public RestaurantsReviewDTO addReview(@RequestBody RestaurantsReviewDTO reviewDTO) throws Exception{
        return restaurantsReviewService.addReview(reviewDTO);
    }

    /**
     * controller method for update restaurant review
     * @param reviewDTO RequestBody RestaurantsReviewDTO object
     * @return RestaurantsReviewDTO object
     * @throws Exception can be throws on  restaurantsReviewService.updateReview(reviewDTO) method
     */
    @PostMapping(value = "/update")
    public RestaurantsReviewDTO updateReview(@RequestBody RestaurantsReviewDTO reviewDTO) throws Exception{
        return restaurantsReviewService.updateReview(reviewDTO);
    }

    /**
     * controller method for delete hotel review
     * @param id String hotel Id
     * @return boolean
     */
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteReview(@RequestParam("id") String id){
        return restaurantsReviewService.deleteReview(id);
    }

    /**
     * default constructor
     * @param restaurantsReviewService autowired defendece
     */
    @Autowired
    public RestaurantsReviewController(RestaurantsReviewService restaurantsReviewService) {
        this.restaurantsReviewService = restaurantsReviewService;
    }
}
