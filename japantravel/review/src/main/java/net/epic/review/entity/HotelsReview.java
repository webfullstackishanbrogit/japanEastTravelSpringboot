package net.epic.review.entity;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Entity Class for the table of hotels_review
 * @author uditha
 */
@Entity
@Table(name = "hotels_review")
@XmlRootElement
public class HotelsReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhotels_review")
    private Integer idhotelsReview;
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
    @Column(name = "hotels_id")
    private Integer hotelsId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelsReviewId")
    private Collection<HotelsTypeRatings> hotelsTypeRatingsCollection;

    public HotelsReview() {
    }

    public HotelsReview(Integer idhotelsReview) {
        this.idhotelsReview = idhotelsReview;
    }

    public HotelsReview(Integer idhotelsReview, int userId, String username, String isUpdated, String isApproved) {
        this.idhotelsReview = idhotelsReview;
        this.userId = userId;
        this.username = username;
        this.isUpdated = isUpdated;
        this.isApproved = isApproved;
    }

    public Integer getIdhotelsReview() {
        return idhotelsReview;
    }

    public void setIdhotelsReview(Integer idhotelsReview) {
        this.idhotelsReview = idhotelsReview;
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

    public Integer getHotelsId() {
        return hotelsId;
    }

    public void setHotelsId(Integer hotelsId) {
        this.hotelsId = hotelsId;
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
    public Collection<HotelsTypeRatings> getHotelsTypeRatingsCollection() {
        return hotelsTypeRatingsCollection;
    }

    public void setHotelsTypeRatingsCollection(Collection<HotelsTypeRatings> hotelsTypeRatingsCollection) {
        this.hotelsTypeRatingsCollection = hotelsTypeRatingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhotelsReview != null ? idhotelsReview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelsReview)) {
            return false;
        }
        HotelsReview other = (HotelsReview) object;
        if ((this.idhotelsReview == null && other.idhotelsReview != null) || (this.idhotelsReview != null && !this.idhotelsReview.equals(other.idhotelsReview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.HotelsReview[ idhotelsReview=" + idhotelsReview + " ]";
    }

}
