package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Entity Class for the table of experience_review
 * @author uditha
 */

@Entity
@Table(name = "experience_review")
@XmlRootElement
public class ExperienceReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexperience_review")
    private Integer idexperienceReview;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Column(name = "stars_review")
    private Integer starsReview;
    @Lob
    @Column(name = "comment")
    private String comment;
    @Column(name = "experience_id")
    private Integer experienceId;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Basic(optional = false)
    @Column(name = "is_updated")
    private String isUpdated;
    @Basic(optional = false)
    @Column(name = "is_approved")
    private String isApproved;
    @Lob
    @Column(name = "title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "experienceReviewId")
    private Collection<ExperienceTypeRatings> experienceTypeRatingsCollection;

    public ExperienceReview() {
    }

    public ExperienceReview(Integer idexperienceReview) {
        this.idexperienceReview = idexperienceReview;
    }

    public ExperienceReview(Integer idexperienceReview, int userId, String username, String isUpdated, String isApproved) {
        this.idexperienceReview = idexperienceReview;
        this.userId = userId;
        this.username = username;
        this.isUpdated = isUpdated;
        this.isApproved = isApproved;
    }

    public Integer getIdexperienceReview() {
        return idexperienceReview;
    }

    public void setIdexperienceReview(Integer idexperienceReview) {
        this.idexperienceReview = idexperienceReview;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStarsReview() {
        return starsReview;
    }

    public void setStarsReview(Integer starsReview) {
        this.starsReview = starsReview;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Integer experienceId) {
        this.experienceId = experienceId;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getIsUpdated() {
        return isUpdated;
    }

    public void setIsUpdated(String isUpdated) {
        this.isUpdated = isUpdated;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public Collection<ExperienceTypeRatings> getExperienceTypeRatingsCollection() {
        return experienceTypeRatingsCollection;
    }

    public void setExperienceTypeRatingsCollection(Collection<ExperienceTypeRatings> experienceTypeRatingsCollection) {
        this.experienceTypeRatingsCollection = experienceTypeRatingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexperienceReview != null ? idexperienceReview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienceReview)) {
            return false;
        }
        ExperienceReview other = (ExperienceReview) object;
        if ((this.idexperienceReview == null && other.idexperienceReview != null) || (this.idexperienceReview != null && !this.idexperienceReview.equals(other.idexperienceReview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.ExperienceReview[ idexperienceReview=" + idexperienceReview + " ]";
    }

}
