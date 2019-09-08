package net.epic.review.controllers;


import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.HotelsReviewDTO;
import net.epic.review.service.HotelsReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for the Hotel Reviews
 * @author uditha
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/hotels")
public class HotelsReviewController {

    private HotelsReviewService hotelsReviewService;

    /**
     * controller method for get all hotel reviews
     * @return List of HotelsReviewDTO
     * @throws Exception can be throws on hotelsReviewService.getAllReviews() method
     */
    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<HotelsReviewDTO>> getAllReviews() throws Exception{
        List<HotelsReviewDTO> allUsers = hotelsReviewService.getAllReviews();
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
        List<CommenStarReviewDTO> allUsers = hotelsReviewService.getAllStarRatings(1);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    /**
     * controller method for save new Hotel Review
     * @param reviewDTO RequestBody HotelsReviewDTO object
     * @return HotelsReviewDTO object
     * @throws Exception can be throws on  hotelsReviewService.addReview(reviewDTO) method
     */
    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public HotelsReviewDTO addReview(@RequestBody HotelsReviewDTO reviewDTO) throws Exception{
        return hotelsReviewService.addReview(reviewDTO);
    }

    /**
     * controller method for update hotel Review
     * @param reviewDTO RequestBody HotelsReviewDTO object
     * @ HotelsReviewDTO object
     * @throws Exception can be throws on  hotelsReviewService.updateReview(reviewDTO) method
     */
    @CrossOrigin("*")
    @PostMapping(value = "/update")
    public HotelsReviewDTO updateReview(@RequestBody HotelsReviewDTO reviewDTO) throws Exception{
        return hotelsReviewService.updateReview(reviewDTO);
    }

    /**
     * controller method for delete hotel Review
     * @param id String hotel Id
     * @return boolean
     */
    @CrossOrigin("*")
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteReview(@RequestParam("id") String id){
        return hotelsReviewService.deleteReview(id);
    }

    /**
     * default constructor
     * @param hotelsReviewService autowired defendence
     */
    @Autowired
    public HotelsReviewController(HotelsReviewService hotelsReviewService) {
        this.hotelsReviewService = hotelsReviewService;
    }
}
