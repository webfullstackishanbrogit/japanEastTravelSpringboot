package net.epic.events.controller;


import net.epic.events.dto.SpecialeventsDTO;
import net.epic.events.service.SpecialeventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for the Specialevents
 * @author uditha
 */
@RestController
@RequestMapping("/events")
public class SpecialeventsController {

    private SpecialeventsService specialeventsService;
    /**
     * controller method for save new special event
     * @param reviewDTO  SpecialeventsDTO
     * @return  SpecialeventsDTO
     */
    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public SpecialeventsDTO addSpecialEvents(@RequestBody SpecialeventsDTO reviewDTO) {
        return specialeventsService.addSpecialEvents(reviewDTO);
    }

    /**
     * controller method for get all special events
     * @return  List of SpecialeventsDTO
     */
    @CrossOrigin("*")
    @GetMapping(value = "/all")
    public ResponseEntity<List<SpecialeventsDTO>> getAllSpecialEvents() {
        List<SpecialeventsDTO> all = specialeventsService.getAllSpecialEvents();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    /**
     * default constructor
     * @param specialeventsService Autowired defendence
     */
    @Autowired
    public SpecialeventsController(SpecialeventsService specialeventsService) {
        this.specialeventsService = specialeventsService;
    }
}
