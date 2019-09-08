package net.epic.destinations.repository;

import net.epic.destinations.entity.Destination;
import net.epic.destinations.repository.custom.DestinationsRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author uditha
 */
public interface DestinationsRepository extends JpaRepository<Destination,Integer>,DestinationsRepositoryCustom {

    List<Destination> findTop4ByOrderByRankingDesc();
}
