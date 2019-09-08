package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Entity Class for the table of tourpackages_type_ratings
 * @author uditha
 */
@Entity
@Table(name = "tourpackages_type_ratings")
@XmlRootElement
public class TourpackagesTypeRatings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtourpackages_type_ratings")
    private Integer idtourpackagesTypeRatings;
    @Basic(optional = false)
    @Column(name = "star_count")
    private int starCount;
    @JoinColumn(name = "tourpackages_review_id", referencedColumnName = "idtourpackages_review")
    @ManyToOne(optional = false)
    private TourpackagesReview tourpackagesReviewId;
    @JoinColumn(name = "review_type_id", referencedColumnName = "idreview_types")
    @ManyToOne(optional = false)
    private ReviewTypes reviewTypeId;

    public TourpackagesTypeRatings() {
    }

    public TourpackagesTypeRatings(Integer idtourpackagesTypeRatings) {
        this.idtourpackagesTypeRatings = idtourpackagesTypeRatings;
    }

    public TourpackagesTypeRatings(Integer idtourpackagesTypeRatings, int starCount) {
        this.idtourpackagesTypeRatings = idtourpackagesTypeRatings;
        this.starCount = starCount;
    }

    public Integer getIdtourpackagesTypeRatings() {
        return idtourpackagesTypeRatings;
    }

    public void setIdtourpackagesTypeRatings(Integer idtourpackagesTypeRatings) {
        this.idtourpackagesTypeRatings = idtourpackagesTypeRatings;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public TourpackagesReview getTourpackagesReviewId() {
        return tourpackagesReviewId;
    }

    public void setTourpackagesReviewId(TourpackagesReview tourpackagesReviewId) {
        this.tourpackagesReviewId = tourpackagesReviewId;
    }

    public ReviewTypes getReviewTypeId() {
        return reviewTypeId;
    }

    public void setReviewTypeId(ReviewTypes reviewTypeId) {
        this.reviewTypeId = reviewTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtourpackagesTypeRatings != null ? idtourpackagesTypeRatings.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourpackagesTypeRatings)) {
            return false;
        }
        TourpackagesTypeRatings other = (TourpackagesTypeRatings) object;
        if ((this.idtourpackagesTypeRatings == null && other.idtourpackagesTypeRatings != null) || (this.idtourpackagesTypeRatings != null && !this.idtourpackagesTypeRatings.equals(other.idtourpackagesTypeRatings))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.TourpackagesTypeRatings[ idtourpackagesTypeRatings=" + idtourpackagesTypeRatings + " ]";
    }

}

