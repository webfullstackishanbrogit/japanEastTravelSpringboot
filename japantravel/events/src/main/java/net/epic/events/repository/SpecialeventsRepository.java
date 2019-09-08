package net.epic.events.repository;

import net.epic.events.entity.Specialevents;
import net.epic.events.repository.custom.SpecialeventsRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author uditha
 */
public interface SpecialeventsRepository extends JpaRepository<Specialevents,Integer>,SpecialeventsRepositoryCustom {

    List<Specialevents> findAllByOrderByEventDateAsc();
}
