package net.epic.events.repository.custom;

import net.epic.events.dto.SpecialeventsDTO;
import net.epic.events.entity.Specialevents;

/**
 * @author uditha
 */
public interface SpecialeventsRepositoryCustom {
    public Specialevents saveDestination (SpecialeventsDTO reviewDTO);
}
