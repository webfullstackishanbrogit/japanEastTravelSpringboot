package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Entity Class for the table of restaurants_type_ratings
 * @author uditha
 */
@Entity
@Table(name = "restaurants_type_ratings")
@XmlRootElement
public class RestaurantsTypeRatings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrestaurants_type_ratings")
    private Integer idrestaurantsTypeRatings;
    @Basic(optional = false)
    @Column(name = "star_count")
    private int starCount;
    @JoinColumn(name = "review_type_id", referencedColumnName = "idreview_types")
    @ManyToOne(optional = false)
    private ReviewTypes reviewTypeId;
    @JoinColumn(name = "restaurants_review_id", referencedColumnName = "idrestaurants_review")
    @ManyToOne(optional = false)
    private RestaurantsReview restaurantsReviewId;

    public RestaurantsTypeRatings() {
    }

    public RestaurantsTypeRatings(Integer idrestaurantsTypeRatings) {
        this.idrestaurantsTypeRatings = idrestaurantsTypeRatings;
    }

    public RestaurantsTypeRatings(Integer idrestaurantsTypeRatings, int starCount) {
        this.idrestaurantsTypeRatings = idrestaurantsTypeRatings;
        this.starCount = starCount;
    }

    public Integer getIdrestaurantsTypeRatings() {
        return idrestaurantsTypeRatings;
    }

    public void setIdrestaurantsTypeRatings(Integer idrestaurantsTypeRatings) {
        this.idrestaurantsTypeRatings = idrestaurantsTypeRatings;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public ReviewTypes getReviewTypeId() {
        return reviewTypeId;
    }

    public void setReviewTypeId(ReviewTypes reviewTypeId) {
        this.reviewTypeId = reviewTypeId;
    }

    public RestaurantsReview getRestaurantsReviewId() {
        return restaurantsReviewId;
    }

    public void setRestaurantsReviewId(RestaurantsReview restaurantsReviewId) {
        this.restaurantsReviewId = restaurantsReviewId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrestaurantsTypeRatings != null ? idrestaurantsTypeRatings.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RestaurantsTypeRatings)) {
            return false;
        }
        RestaurantsTypeRatings other = (RestaurantsTypeRatings) object;
        if ((this.idrestaurantsTypeRatings == null && other.idrestaurantsTypeRatings != null) || (this.idrestaurantsTypeRatings != null && !this.idrestaurantsTypeRatings.equals(other.idrestaurantsTypeRatings))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.RestaurantsTypeRatings[ idrestaurantsTypeRatings=" + idrestaurantsTypeRatings + " ]";
    }

}
