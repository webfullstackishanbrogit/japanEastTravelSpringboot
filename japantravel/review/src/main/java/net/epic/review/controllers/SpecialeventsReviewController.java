package net.epic.review.controllers;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.SpecialeventsReviewDTO;
import net.epic.review.service.SpecialeventsReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for specialEvent Review
 * @author uditha
 */
@RestController
@RequestMapping("/specialevent")
public class SpecialeventsReviewController {

    private SpecialeventsReviewService specialeventsReviewService;

    /**
     * controller method for get all special events review
     * @return List of SpecialeventsReviewDTO
     * @throws Exception can be throws on specialeventsReviewService.getAllReviews() method
     */
    @GetMapping(value = "/all")
    public ResponseEntity<List<SpecialeventsReviewDTO>> getAllReviews() throws Exception{
        List<SpecialeventsReviewDTO> allUsers = specialeventsReviewService.getAllReviews();
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
        List<CommenStarReviewDTO> allUsers = specialeventsReviewService.getAllStarRatings(1);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    /**
     * controller method for save new special event review
     * @param reviewDTO requestBody SpecialeventsReviewDTO Object
     * @return SpecialeventsReviewDTO Object
     * @throws Exception can be throws on specialeventsReviewService.addReview(reviewDTO) method
     */
    @PostMapping(value = "/add")
    public SpecialeventsReviewDTO addReview(@RequestBody SpecialeventsReviewDTO reviewDTO) throws Exception{
        return specialeventsReviewService.addReview(reviewDTO);
    }

    /**
     * controller method for update special event Review
     * @param reviewDTO RequestBody SpecialeventsReviewDTO  object
     * @return RequestBody SpecialeventsReviewDTO object
     * @throws Exception can be throws on specialeventsReviewService.updateReview(reviewDTO) method
     */
    @PostMapping(value = "/update")
    public SpecialeventsReviewDTO updateReview(@RequestBody SpecialeventsReviewDTO reviewDTO) throws Exception{
        return specialeventsReviewService.updateReview(reviewDTO);
    }

    /**
     * controller method for delete special event review
     * @param id String special event id
     * @return boolean
     */
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteReview(@RequestParam("id") String id){
        return specialeventsReviewService.deleteReview(id);
    }

    /**
     * default constructor
     * @param specialeventsReviewService autowired defendece
     */
    @Autowired
    public SpecialeventsReviewController(SpecialeventsReviewService specialeventsReviewService) {
        this.specialeventsReviewService = specialeventsReviewService;
    }
}
