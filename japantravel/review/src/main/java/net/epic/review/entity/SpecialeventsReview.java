package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Entity Class for the table of specialevents_review
 * @author uditha
 */

@Entity
@Table(name = "specialevents_review")
@XmlRootElement
public class SpecialeventsReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspecialevents_review")
    private Integer idspecialeventsReview;
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
    @Column(name = "specialevents_id")
    private Integer specialeventsId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialeventsReviewId")
    private Collection<SpecialeventsTypeRatings> specialeventsTypeRatingsCollection;

    public SpecialeventsReview() {
    }

    public SpecialeventsReview(Integer idspecialeventsReview) {
        this.idspecialeventsReview = idspecialeventsReview;
    }

    public SpecialeventsReview(Integer idspecialeventsReview, int userId, String username, String isUpdated, String isApproved) {
        this.idspecialeventsReview = idspecialeventsReview;
        this.userId = userId;
        this.username = username;
        this.isUpdated = isUpdated;
        this.isApproved = isApproved;
    }

    public Integer getIdspecialeventsReview() {
        return idspecialeventsReview;
    }

    public void setIdspecialeventsReview(Integer idspecialeventsReview) {
        this.idspecialeventsReview = idspecialeventsReview;
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

    public Integer getSpecialeventsId() {
        return specialeventsId;
    }

    public void setSpecialeventsId(Integer specialeventsId) {
        this.specialeventsId = specialeventsId;
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
    public Collection<SpecialeventsTypeRatings> getSpecialeventsTypeRatingsCollection() {
        return specialeventsTypeRatingsCollection;
    }

    public void setSpecialeventsTypeRatingsCollection(Collection<SpecialeventsTypeRatings> specialeventsTypeRatingsCollection) {
        this.specialeventsTypeRatingsCollection = specialeventsTypeRatingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idspecialeventsReview != null ? idspecialeventsReview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialeventsReview)) {
            return false;
        }
        SpecialeventsReview other = (SpecialeventsReview) object;
        if ((this.idspecialeventsReview == null && other.idspecialeventsReview != null) || (this.idspecialeventsReview != null && !this.idspecialeventsReview.equals(other.idspecialeventsReview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.SpecialeventsReview[ idspecialeventsReview=" + idspecialeventsReview + " ]";
    }

}
