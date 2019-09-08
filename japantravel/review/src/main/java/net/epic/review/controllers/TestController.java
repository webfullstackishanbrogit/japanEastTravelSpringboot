package net.epic.review.controllers;

import net.epic.review.dto.DestinationsReviewDTO;
import net.epic.review.service.DestinationsReviewService;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Test Controller for checking functional status manually
 *
 * @author Ayesh Jayasekara
 * @version 1 (7/25/2019)
 */
@RestController
public class TestController {

    @Autowired
    private DestinationsReviewService destinationsReviewService;

    @Autowired
    AccessToken accessToken;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return "Test";
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<DestinationsReviewDTO>> getAllReviews() throws Exception {
        List<DestinationsReviewDTO> allUsers = destinationsReviewService.getAllReviews();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public DestinationsReviewDTO addReview(@RequestBody DestinationsReviewDTO reviewDTO) throws Exception {
        DestinationsReviewDTO dto = destinationsReviewService.addReview(reviewDTO);
        return dto;
    }

    @PostMapping(value = "/update")
    public DestinationsReviewDTO updateReview(@RequestBody DestinationsReviewDTO reviewDTO) throws Exception {
        DestinationsReviewDTO dto = destinationsReviewService.updateReview(reviewDTO);
        return dto;
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteReview(@RequestParam("id") String id){
        return destinationsReviewService.deleteReview(id);
    }



}
