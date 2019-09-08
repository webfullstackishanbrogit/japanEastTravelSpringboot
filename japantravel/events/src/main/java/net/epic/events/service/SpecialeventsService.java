package net.epic.events.service;

import net.epic.events.dto.SpecialeventsDTO;

import java.util.List;

/**
 * @author uditha
 */
public interface SpecialeventsService {

    List<SpecialeventsDTO> getAllSpecialEvents() ;

    SpecialeventsDTO addSpecialEvents(SpecialeventsDTO reviewDTO);
}
