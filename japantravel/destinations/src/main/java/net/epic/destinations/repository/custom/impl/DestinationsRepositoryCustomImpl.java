package net.epic.destinations.repository.custom.impl;

import net.epic.destinations.entity.Destination;
import net.epic.destinations.repository.custom.DestinationsRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Implementation class for the DestinationsRepositoryCustom
 * @author uditha 
 */
public class DestinationsRepositoryCustomImpl implements DestinationsRepositoryCustom {

    private EntityManager entityManager;
    @Override
    public List<Destination> getRatedDestinationsFour() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Destination> criteriaQuery = cb.createQuery(Destination.class);
        Root<Destination> root = criteriaQuery.from(Destination.class);
        criteriaQuery.select(root);
        criteriaQuery.orderBy(cb.asc(root.get("ranking")));

        TypedQuery<Destination> query = entityManager.createQuery(criteriaQuery);
        
        List<Destination> list = query.getResultList();
        for (Destination employee : list) {
            System.out.println("EMP NAME="+employee.getTitle()+"\t SALARY="+employee.getDescription());
        }


        return null;
    }

    @Autowired
    public DestinationsRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
