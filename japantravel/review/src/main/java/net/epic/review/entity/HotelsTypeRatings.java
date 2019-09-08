package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Entity Class for the table of hotels_type_ratings
 * @author uditha
 */
@Entity
@Table(name = "hotels_type_ratings")
@XmlRootElement
public class HotelsTypeRatings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhotels_type_ratings")
    private Integer idhotelsTypeRatings;
    @Basic(optional = false)
    @Column(name = "star_count")
    private int starCount;
    @JoinColumn(name = "review_type_id", referencedColumnName = "idreview_types")
    @ManyToOne(optional = false)
    private ReviewTypes reviewTypeId;
    @JoinColumn(name = "hotels_review_id", referencedColumnName = "idhotels_review")
    @ManyToOne(optional = false)
    private HotelsReview hotelsReviewId;

    public HotelsTypeRatings() {
    }

    public HotelsTypeRatings(Integer idhotelsTypeRatings) {
        this.idhotelsTypeRatings = idhotelsTypeRatings;
    }

    public HotelsTypeRatings(Integer idhotelsTypeRatings, int starCount) {
        this.idhotelsTypeRatings = idhotelsTypeRatings;
        this.starCount = starCount;
    }

    public Integer getIdhotelsTypeRatings() {
        return idhotelsTypeRatings;
    }

    public void setIdhotelsTypeRatings(Integer idhotelsTypeRatings) {
        this.idhotelsTypeRatings = idhotelsTypeRatings;
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

    public HotelsReview getHotelsReviewId() {
        return hotelsReviewId;
    }

    public void setHotelsReviewId(HotelsReview hotelsReviewId) {
        this.hotelsReviewId = hotelsReviewId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhotelsTypeRatings != null ? idhotelsTypeRatings.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelsTypeRatings)) {
            return false;
        }
        HotelsTypeRatings other = (HotelsTypeRatings) object;
        if ((this.idhotelsTypeRatings == null && other.idhotelsTypeRatings != null) || (this.idhotelsTypeRatings != null && !this.idhotelsTypeRatings.equals(other.idhotelsTypeRatings))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.HotelsTypeRatings[ idhotelsTypeRatings=" + idhotelsTypeRatings + " ]";
    }

}
