package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Entity Class for the table of transportation_review
 * @author uditha
 */
@Entity
@Table(name = "transportation_review")
@XmlRootElement
public class TransportationReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransportation_review")
    private Integer idtransportationReview;
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
    @Column(name = "transportation_id")
    private Integer transportationId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportationReviewId")
    private Collection<TransportationTypeRatings> transportationTypeRatingsCollection;

    public TransportationReview() {
    }

    public TransportationReview(Integer idtransportationReview) {
        this.idtransportationReview = idtransportationReview;
    }

    public TransportationReview(Integer idtransportationReview, int userId, String username, String isUpdated, String isApproved) {
        this.idtransportationReview = idtransportationReview;
        this.userId = userId;
        this.username = username;
        this.isUpdated = isUpdated;
        this.isApproved = isApproved;
    }

    public Integer getIdtransportationReview() {
        return idtransportationReview;
    }

    public void setIdtransportationReview(Integer idtransportationReview) {
        this.idtransportationReview = idtransportationReview;
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

    public Integer getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(Integer transportationId) {
        this.transportationId = transportationId;
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
    public Collection<TransportationTypeRatings> getTransportationTypeRatingsCollection() {
        return transportationTypeRatingsCollection;
    }

    public void setTransportationTypeRatingsCollection(Collection<TransportationTypeRatings> transportationTypeRatingsCollection) {
        this.transportationTypeRatingsCollection = transportationTypeRatingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransportationReview != null ? idtransportationReview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransportationReview)) {
            return false;
        }
        TransportationReview other = (TransportationReview) object;
        if ((this.idtransportationReview == null && other.idtransportationReview != null) || (this.idtransportationReview != null && !this.idtransportationReview.equals(other.idtransportationReview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.TransportationReview[ idtransportationReview=" + idtransportationReview + " ]";
    }

}
