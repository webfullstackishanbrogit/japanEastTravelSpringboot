package net.epic.destinations.controller;


import net.epic.destinations.dto.DestinationDTO;
import net.epic.destinations.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller class for the destination
 * @author uditha
 */
@RestController
@RequestMapping("/dest")
public class DestinationController {

    private DestinationService destinationService;

    /**
     * controller method for the save new destination with image path list and tag list
     * @param reviewDTO  DestinationDTO with DestinationTagsDTO list and DestinationImagesDTO List
     * @return  DestinationDTO
     */
    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public DestinationDTO addDestination(@RequestBody DestinationDTO reviewDTO) {
        return destinationService.addDestination(reviewDTO);
    }

    /**
     * controller method for the get all destinations
     * @return  List of DestinationDTO
     */
    @CrossOrigin("*")
    @GetMapping(value = "/all")
    public ResponseEntity<List<DestinationDTO>> getAllDestination() {
        List<DestinationDTO> allUsers = destinationService.getAllDestination();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @GetMapping(value = "/ratedfour")
    public ResponseEntity<List<DestinationDTO>> getRatedDestinationsFour() {
        List<DestinationDTO> allUsers = destinationService.getRatedDestinationsFour();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    /**
     * default constructor
     * @param destinationService  Autowired defendence
     */
    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }
}
