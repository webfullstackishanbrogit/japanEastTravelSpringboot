package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Entity Class for the table of destination_type_ratings
 * @author uditha
 */
@Entity
@Table(name = "destination_type_ratings")
@XmlRootElement
public class DestinationTypeRatings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddestination_type_ratings")
    private Integer iddestinationTypeRatings;
    @Basic(optional = false)
    @Column(name = "star_count")
    private int starCount;
    @JoinColumn(name = "review_type_id", referencedColumnName = "idreview_types")
    @ManyToOne(optional = false)
    private ReviewTypes reviewTypeId;
    @JoinColumn(name = "destination_review_id", referencedColumnName = "iddestinations_review")
    @ManyToOne(optional = false)
    private DestinationsReview destinationReviewId;

    public DestinationTypeRatings() {
    }

    public DestinationTypeRatings(Integer iddestinationTypeRatings) {
        this.iddestinationTypeRatings = iddestinationTypeRatings;
    }

    public DestinationTypeRatings(Integer iddestinationTypeRatings, int starCount) {
        this.iddestinationTypeRatings = iddestinationTypeRatings;
        this.starCount = starCount;
    }

    public Integer getIddestinationTypeRatings() {
        return iddestinationTypeRatings;
    }

    public void setIddestinationTypeRatings(Integer iddestinationTypeRatings) {
        this.iddestinationTypeRatings = iddestinationTypeRatings;
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

    public DestinationsReview getDestinationReviewId() {
        return destinationReviewId;
    }

    public void setDestinationReviewId(DestinationsReview destinationReviewId) {
        this.destinationReviewId = destinationReviewId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddestinationTypeRatings != null ? iddestinationTypeRatings.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DestinationTypeRatings)) {
            return false;
        }
        DestinationTypeRatings other = (DestinationTypeRatings) object;
        if ((this.iddestinationTypeRatings == null && other.iddestinationTypeRatings != null) || (this.iddestinationTypeRatings != null && !this.iddestinationTypeRatings.equals(other.iddestinationTypeRatings))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.DestinationTypeRatings[ iddestinationTypeRatings=" + iddestinationTypeRatings + " ]";
    }

}
