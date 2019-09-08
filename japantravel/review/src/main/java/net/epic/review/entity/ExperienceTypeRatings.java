package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/**
 * Entity Class for the table of experience_type_ratings
 * @author uditha
 */
@Entity
@Table(name = "experience_type_ratings")
@XmlRootElement
public class ExperienceTypeRatings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexperience_type_ratings")
    private Integer idexperienceTypeRatings;
    @Basic(optional = false)
    @Column(name = "star_count")
    private int starCount;
    @JoinColumn(name = "review_type_id", referencedColumnName = "idreview_types")
    @ManyToOne(optional = false)
    private ReviewTypes reviewTypeId;
    @JoinColumn(name = "experience_review_id", referencedColumnName = "idexperience_review")
    @ManyToOne(optional = false)
    private ExperienceReview experienceReviewId;

    public ExperienceTypeRatings() {
    }

    public ExperienceTypeRatings(Integer idexperienceTypeRatings) {
        this.idexperienceTypeRatings = idexperienceTypeRatings;
    }

    public ExperienceTypeRatings(Integer idexperienceTypeRatings, int starCount) {
        this.idexperienceTypeRatings = idexperienceTypeRatings;
        this.starCount = starCount;
    }

    public Integer getIdexperienceTypeRatings() {
        return idexperienceTypeRatings;
    }

    public void setIdexperienceTypeRatings(Integer idexperienceTypeRatings) {
        this.idexperienceTypeRatings = idexperienceTypeRatings;
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

    public ExperienceReview getExperienceReviewId() {
        return experienceReviewId;
    }

    public void setExperienceReviewId(ExperienceReview experienceReviewId) {
        this.experienceReviewId = experienceReviewId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexperienceTypeRatings != null ? idexperienceTypeRatings.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienceTypeRatings)) {
            return false;
        }
        ExperienceTypeRatings other = (ExperienceTypeRatings) object;
        if ((this.idexperienceTypeRatings == null && other.idexperienceTypeRatings != null) || (this.idexperienceTypeRatings != null && !this.idexperienceTypeRatings.equals(other.idexperienceTypeRatings))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.ExperienceTypeRatings[ idexperienceTypeRatings=" + idexperienceTypeRatings + " ]";
    }

}
