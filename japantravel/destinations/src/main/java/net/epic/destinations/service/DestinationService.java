package net.epic.destinations.service;

import net.epic.destinations.dto.DestinationDTO;

import java.util.List;

/**
 * @author uditha
 */
public interface DestinationService {

    List<DestinationDTO> getAllDestination() ;

    List<DestinationDTO> getRatedDestinationsFour() ;

    DestinationDTO addDestination(DestinationDTO reviewDTO);
}
