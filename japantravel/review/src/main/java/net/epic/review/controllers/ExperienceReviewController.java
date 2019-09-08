package net.epic.review.controllers;


import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.ExperienceReviewDTO;
import net.epic.review.service.ExperienceReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for the Destination Reviews
 * @author uditha
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/experiences")
public class ExperienceReviewController {

    private ExperienceReviewService experienceReviewService;

    /**
     * controller method for get all experience Reviews
     * @return List of ExperienceReviewDTO
     * @throws Exception can be throws on experienceReviewService.getAllReviews() method
     */
    @GetMapping(value = "/all")
    public ResponseEntity<List<ExperienceReviewDTO>> getAllReviews() throws Exception{
        List<ExperienceReviewDTO> allUsers = experienceReviewService.getAllReviews();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    /**
     * controller method for get all ratings by experience ID
     * @return List of CommenStarReviewDTO
     * @throws Exception can be throws on  experienceReviewService.getAllStarRatings() method
     */
    @CrossOrigin("*")
    @GetMapping(value = "/allratings")
    public ResponseEntity<List<CommenStarReviewDTO>> getAllStarRatings() throws Exception {
        List<CommenStarReviewDTO> allUsers = experienceReviewService.getAllStarRatings(1);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    /**
     * controller method for save new experience Review
     * @param reviewDTO RequestBody ExperienceReviewDTO object
     * @return ExperienceReviewDTO object
     * @throws Exception can be throws on experienceReviewService.addReview(reviewDTO) method
     */
    @PostMapping(value = "/add")
    public ExperienceReviewDTO addReview(@RequestBody ExperienceReviewDTO reviewDTO) throws Exception{
        return experienceReviewService.addReview(reviewDTO);
    }

    /**
     * controller method for update experience Review
     * @param reviewDTO RequestBody ExperienceReviewDTO object
     * @return ExperienceReviewDTO object
     * @throws Exception can be throws on experienceReviewService.updateReview(reviewDTO) method
     */
    @PostMapping(value = "/update")
    public ExperienceReviewDTO updateReview(@RequestBody ExperienceReviewDTO reviewDTO) throws Exception{
        return experienceReviewService.updateReview(reviewDTO);
    }

    /**
     * controller method for delete experience review
     * @param id String experience review id
     * @return boolean
     */
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteReview(@RequestParam("id") String id){
       return experienceReviewService.deleteReview(id);
    }

    /**
     * Default constructor
     * @param experienceReviewService spring autowired defendence
     */
    @Autowired
    public ExperienceReviewController(ExperienceReviewService experienceReviewService) {
        this.experienceReviewService = experienceReviewService;
    }
}
