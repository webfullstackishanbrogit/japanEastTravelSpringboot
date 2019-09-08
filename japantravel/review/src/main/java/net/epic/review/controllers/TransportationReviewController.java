package net.epic.review.controllers;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.TransportationReviewDTO;
import net.epic.review.service.TransportationReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller class for the transportation review
 * @author uditha
 */
@RestController
@RequestMapping("/transportation")
public class TransportationReviewController {

    private TransportationReviewService transportationReviewService;

    /**
     * controller method for the get all transportation review
     * @return  List of TransportationReviewDTO
     * @throws Exception can be throws on  transportationReviewService.getAllReviews() method
     */
    @GetMapping(value = "/all")
    public ResponseEntity<List<TransportationReviewDTO>> getAllReviews() throws Exception{
        List<TransportationReviewDTO> allUsers = transportationReviewService.getAllReviews();
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
        List<CommenStarReviewDTO> allUsers = transportationReviewService.getAllStarRatings(1);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    /**
     * controller method for the save new transportation review
     * @param reviewDTO RequestBody TransportationReviewDTO
     * @return  TransportationReviewDTO
     * @throws Exception can be throws on  transportationReviewService.addReview(reviewDTO) method
     */
    @PostMapping(value = "/add")
    public TransportationReviewDTO addReview(@RequestBody TransportationReviewDTO reviewDTO) throws Exception{
        return transportationReviewService.addReview(reviewDTO);
    }

    /**
     * controller method for the update transportation review
     * @param reviewDTO RequestBody TransportationReviewDTO
     * @return  TransportationReviewDTO
     * @throws Exception can be throws on  transportationReviewService.updateReview(reviewDTO) method
     */
    @PostMapping(value = "/update")
    public TransportationReviewDTO updateReview(@RequestBody TransportationReviewDTO reviewDTO) throws Exception{
        return transportationReviewService.updateReview(reviewDTO);
    }

    /**
     * controller method for the delete transportation review
     * @param id String transportation review id
     * @return
     */
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteReview(@RequestParam("id") String id){
        return transportationReviewService.deleteReview(id);
    }

    /**
     * default constructor
     * @param transportationReviewService autowired defendence
     */
    @Autowired
    public TransportationReviewController(TransportationReviewService transportationReviewService) {
        this.transportationReviewService = transportationReviewService;
    }
}
