package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Entity Class for the table of trainpasses_type_ratings
 * @author uditha
 */
@Entity
@Table(name = "trainpasses_type_ratings")
@XmlRootElement
public class TrainpassesTypeRatings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtrainpasses_type_ratings")
    private Integer idtrainpassesTypeRatings;
    @Basic(optional = false)
    @Column(name = "star_count")
    private int starCount;
    @JoinColumn(name = "review_type_id", referencedColumnName = "idreview_types")
    @ManyToOne(optional = false)
    private ReviewTypes reviewTypeId;
    @JoinColumn(name = "trainpasses_review_id", referencedColumnName = "idtrainpasses_review")
    @ManyToOne(optional = false)
    private TrainpassesReview trainpassesReviewId;

    public TrainpassesTypeRatings() {
    }

    public TrainpassesTypeRatings(Integer idtrainpassesTypeRatings) {
        this.idtrainpassesTypeRatings = idtrainpassesTypeRatings;
    }

    public TrainpassesTypeRatings(Integer idtrainpassesTypeRatings, int starCount) {
        this.idtrainpassesTypeRatings = idtrainpassesTypeRatings;
        this.starCount = starCount;
    }

    public Integer getIdtrainpassesTypeRatings() {
        return idtrainpassesTypeRatings;
    }

    public void setIdtrainpassesTypeRatings(Integer idtrainpassesTypeRatings) {
        this.idtrainpassesTypeRatings = idtrainpassesTypeRatings;
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

    public TrainpassesReview getTrainpassesReviewId() {
        return trainpassesReviewId;
    }

    public void setTrainpassesReviewId(TrainpassesReview trainpassesReviewId) {
        this.trainpassesReviewId = trainpassesReviewId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrainpassesTypeRatings != null ? idtrainpassesTypeRatings.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainpassesTypeRatings)) {
            return false;
        }
        TrainpassesTypeRatings other = (TrainpassesTypeRatings) object;
        if ((this.idtrainpassesTypeRatings == null && other.idtrainpassesTypeRatings != null) || (this.idtrainpassesTypeRatings != null && !this.idtrainpassesTypeRatings.equals(other.idtrainpassesTypeRatings))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.TrainpassesTypeRatings[ idtrainpassesTypeRatings=" + idtrainpassesTypeRatings + " ]";
    }

}
