package net.epic.review.repository.custom.impl;

import net.epic.review.dto.CommenStarReviewDTO;
import net.epic.review.dto.DestinationsReviewDTO;
import net.epic.review.entity.DestinationTypeRatings;
import net.epic.review.entity.DestinationsReview;
import net.epic.review.entity.ReviewTypes;
import net.epic.review.repository.custom.DestinationsReviewRepositoryCustom;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implementation Class for the Destinations Review Repository Custom
 *
 * @author uditha
 */
public class DestinationsReviewRepositoryCustomImpl implements DestinationsReviewRepositoryCustom {

    private EntityManager entityManager;

    /**
     * Repository implementation method for the save reviews with star ratings
     * @param reviewDTO DestinationsReviewDTO
     * @return DestinationsReview
     */
    @Override
    public DestinationsReview saveReviewWithStars(DestinationsReviewDTO reviewDTO) {

        Session session = entityManager.unwrap(Session.class);

        DestinationsReview review = new DestinationsReview();
        review.setComment(reviewDTO.getComment());
        review.setUsername(reviewDTO.getUsername());
        review.setDatetime(new Date());
        review.setDestinationsId(1);
        review.setIsApproved("NO");
        review.setIsUpdated("NO");
        review.setUserId(1);
        review.setTitle(reviewDTO.getTitle());

        // to the calculate avarage Starrate
        double totalStars = 0.0;
        Double avarage = 0.0;
        double rateCount;


        if (reviewDTO.getReviewDTOlist() != null) {
            rateCount = reviewDTO.getReviewDTOlist().size();
            for (CommenStarReviewDTO commenDTO : reviewDTO.getReviewDTOlist()) {
                totalStars += commenDTO.getStarCount();
            }
            avarage = (totalStars / rateCount);
        }
        review.setStarsReview(avarage.intValue());

        session.save(review);

        DestinationTypeRatings typeRatings;
        List<CommenStarReviewDTO> reviewDTOlist = reviewDTO.getReviewDTOlist();
        if (reviewDTOlist != null) {
            for (CommenStarReviewDTO commenDTO : reviewDTOlist) {
                typeRatings = new DestinationTypeRatings();
                typeRatings.setDestinationReviewId(review);
                ReviewTypes reviewTypes = (ReviewTypes) session.createCriteria(ReviewTypes.class).add(Restrictions.eq("idreviewTypes", commenDTO.getTypeRatingId())).uniqueResult();
                typeRatings.setReviewTypeId(reviewTypes);
                typeRatings.setStarCount(commenDTO.getStarCount());
                session.save(typeRatings);
            }
        }


        return review;
    }

    /**
     * Repository implementation method for the get all star ratings by destination Id
     * @param destinationId integer Destination ID
     * @return List of CommenStarReviewDTO
     * @throws Exception
     */
    @Override
    public List<CommenStarReviewDTO> getAllStarRatings(Integer destinationId)  {
        Session session = entityManager.unwrap(Session.class);

        List<CommenStarReviewDTO> starReviewDTOList = new ArrayList<>();
        CommenStarReviewDTO dto;
        Criteria cr;
        long collCap;
        Integer reviewCount = 1;
        Long avarage;

        Long totalAvarage ;
        Integer totalReviews = 1;
        long totatlStars;

        Criteria cc = session.createCriteria(DestinationsReview.class).add(Restrictions.eq("destinationsId",destinationId));
        if(cc.list().size()==0){
            totalReviews = 1;
        }else{
            totalReviews = cc.list().size();
        }
        cc.setProjection(Projections.sum("starsReview"));

        if (cc.uniqueResult() != null) {
            totatlStars = (Long) cc.uniqueResult();
        } else {
            totatlStars = 0;
        }

        totalAvarage = (totatlStars/totalReviews);

        List<ReviewTypes> reviewTypesList = session.createCriteria(ReviewTypes.class).add(Restrictions.eq("category", "DESTINATIONS")).list();
        for (ReviewTypes types : reviewTypesList) {
            dto = new CommenStarReviewDTO();
            dto.setCategory(types.getCategory());
            dto.setReviewTypeId(types.getIdreviewTypes());
            dto.setType(types.getType());


            cr = session.createCriteria(DestinationTypeRatings.class, "de").createCriteria("de.destinationReviewId", "li");
            cr.add(Restrictions.eq("de.reviewTypeId", types));
            cr.add(Restrictions.eq("li.destinationsId", destinationId));

            if (!cr.list().isEmpty()) {
                reviewCount = cr.list().size();
            }
            cr.setProjection(Projections.sum("de.starCount"));

            if (cr.uniqueResult() != null) {
                collCap = (Long) cr.uniqueResult();
            } else {
                collCap = 0;
            }

            avarage = (collCap / reviewCount);
            dto.setStarCount(avarage.intValue());

            dto.setTotalReviewsCount(totalReviews.doubleValue());
            dto.setAvarage(totalAvarage.doubleValue());

            starReviewDTOList.add(dto);
        }

        return starReviewDTOList;
    }

    /**
     * default constructor
     * @param entityManager autowired defendence
     */
    @Autowired
    public DestinationsReviewRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}