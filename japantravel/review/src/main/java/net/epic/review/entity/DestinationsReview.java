package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Entity Class for the table of destinations_review
 * @author uditha
 */

@Entity
@Table(name = "destinations_review")
@XmlRootElement
public class DestinationsReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddestinations_review")
    private Integer iddestinationsReview;
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
    @Column(name = "destinations_id")
    private Integer destinationsId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinationReviewId")
    private Collection<DestinationTypeRatings> destinationTypeRatingsCollection;

    public DestinationsReview() {
    }

    public DestinationsReview(Integer iddestinationsReview) {
        this.iddestinationsReview = iddestinationsReview;
    }

    public DestinationsReview(Integer iddestinationsReview, int userId, String username, String isUpdated, String isApproved) {
        this.iddestinationsReview = iddestinationsReview;
        this.userId = userId;
        this.username = username;
        this.isUpdated = isUpdated;
        this.isApproved = isApproved;
    }

    public Integer getIddestinationsReview() {
        return iddestinationsReview;
    }

    public void setIddestinationsReview(Integer iddestinationsReview) {
        this.iddestinationsReview = iddestinationsReview;
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

    public Integer getDestinationsId() {
        return destinationsId;
    }

    public void setDestinationsId(Integer destinationsId) {
        this.destinationsId = destinationsId;
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
    public Collection<DestinationTypeRatings> getDestinationTypeRatingsCollection() {
        return destinationTypeRatingsCollection;
    }

    public void setDestinationTypeRatingsCollection(Collection<DestinationTypeRatings> destinationTypeRatingsCollection) {
        this.destinationTypeRatingsCollection = destinationTypeRatingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddestinationsReview != null ? iddestinationsReview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DestinationsReview)) {
            return false;
        }
        DestinationsReview other = (DestinationsReview) object;
        if ((this.iddestinationsReview == null && other.iddestinationsReview != null) || (this.iddestinationsReview != null && !this.iddestinationsReview.equals(other.iddestinationsReview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.DestinationsReview[ iddestinationsReview=" + iddestinationsReview + " ]";
    }

}
