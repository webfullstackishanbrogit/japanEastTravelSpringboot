package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Entity Class for the table of specialevents_type_ratings
 * @author uditha
 */
@Entity
@Table(name = "specialevents_type_ratings")
@XmlRootElement
public class SpecialeventsTypeRatings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspecialevents_type_ratings")
    private Integer idspecialeventsTypeRatings;
    @Basic(optional = false)
    @Column(name = "star_count")
    private int starCount;
    @JoinColumn(name = "review_type_id", referencedColumnName = "idreview_types")
    @ManyToOne(optional = false)
    private ReviewTypes reviewTypeId;
    @JoinColumn(name = "specialevents_review_id", referencedColumnName = "idspecialevents_review")
    @ManyToOne(optional = false)
    private SpecialeventsReview specialeventsReviewId;

    public SpecialeventsTypeRatings() {
    }

    public SpecialeventsTypeRatings(Integer idspecialeventsTypeRatings) {
        this.idspecialeventsTypeRatings = idspecialeventsTypeRatings;
    }

    public SpecialeventsTypeRatings(Integer idspecialeventsTypeRatings, int starCount) {
        this.idspecialeventsTypeRatings = idspecialeventsTypeRatings;
        this.starCount = starCount;
    }

    public Integer getIdspecialeventsTypeRatings() {
        return idspecialeventsTypeRatings;
    }

    public void setIdspecialeventsTypeRatings(Integer idspecialeventsTypeRatings) {
        this.idspecialeventsTypeRatings = idspecialeventsTypeRatings;
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

    public SpecialeventsReview getSpecialeventsReviewId() {
        return specialeventsReviewId;
    }

    public void setSpecialeventsReviewId(SpecialeventsReview specialeventsReviewId) {
        this.specialeventsReviewId = specialeventsReviewId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idspecialeventsTypeRatings != null ? idspecialeventsTypeRatings.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialeventsTypeRatings)) {
            return false;
        }
        SpecialeventsTypeRatings other = (SpecialeventsTypeRatings) object;
        if ((this.idspecialeventsTypeRatings == null && other.idspecialeventsTypeRatings != null) || (this.idspecialeventsTypeRatings != null && !this.idspecialeventsTypeRatings.equals(other.idspecialeventsTypeRatings))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.SpecialeventsTypeRatings[ idspecialeventsTypeRatings=" + idspecialeventsTypeRatings + " ]";
    }

}
