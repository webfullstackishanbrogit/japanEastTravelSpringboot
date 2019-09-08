package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Entity Class for the table of tourpackages_review
 * @author uditha
 */
@Entity
@Table(name = "tourpackages_review")
@XmlRootElement
public class TourpackagesReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtourpackages_review")
    private Integer idtourpackagesReview;
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
    @Column(name = "tourpackages_id")
    private Integer tourpackagesId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourpackagesReviewId")
    private Collection<TourpackagesTypeRatings> tourpackagesTypeRatingsCollection;

    public TourpackagesReview() {
    }

    public TourpackagesReview(Integer idtourpackagesReview) {
        this.idtourpackagesReview = idtourpackagesReview;
    }

    public TourpackagesReview(Integer idtourpackagesReview, int userId, String username, String isUpdated, String isApproved) {
        this.idtourpackagesReview = idtourpackagesReview;
        this.userId = userId;
        this.username = username;
        this.isUpdated = isUpdated;
        this.isApproved = isApproved;
    }

    public Integer getIdtourpackagesReview() {
        return idtourpackagesReview;
    }

    public void setIdtourpackagesReview(Integer idtourpackagesReview) {
        this.idtourpackagesReview = idtourpackagesReview;
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

    public Integer getTourpackagesId() {
        return tourpackagesId;
    }

    public void setTourpackagesId(Integer tourpackagesId) {
        this.tourpackagesId = tourpackagesId;
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
    public Collection<TourpackagesTypeRatings> getTourpackagesTypeRatingsCollection() {
        return tourpackagesTypeRatingsCollection;
    }

    public void setTourpackagesTypeRatingsCollection(Collection<TourpackagesTypeRatings> tourpackagesTypeRatingsCollection) {
        this.tourpackagesTypeRatingsCollection = tourpackagesTypeRatingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtourpackagesReview != null ? idtourpackagesReview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourpackagesReview)) {
            return false;
        }
        TourpackagesReview other = (TourpackagesReview) object;
        if ((this.idtourpackagesReview == null && other.idtourpackagesReview != null) || (this.idtourpackagesReview != null && !this.idtourpackagesReview.equals(other.idtourpackagesReview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.TourpackagesReview[ idtourpackagesReview=" + idtourpackagesReview + " ]";
    }

}
