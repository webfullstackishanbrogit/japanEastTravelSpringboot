package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Entity Class for the table of restaurants_review
 * @author uditha
 */
@Entity
@Table(name = "restaurants_review")
@XmlRootElement
public class RestaurantsReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrestaurants_review")
    private Integer idrestaurantsReview;
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
    @Column(name = "restaurant_id")
    private Integer restaurantId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantsReviewId")
    private Collection<RestaurantsTypeRatings> restaurantsTypeRatingsCollection;

    public RestaurantsReview() {
    }

    public RestaurantsReview(Integer idrestaurantsReview) {
        this.idrestaurantsReview = idrestaurantsReview;
    }

    public RestaurantsReview(Integer idrestaurantsReview, int userId, String username, String isUpdated, String isApproved) {
        this.idrestaurantsReview = idrestaurantsReview;
        this.userId = userId;
        this.username = username;
        this.isUpdated = isUpdated;
        this.isApproved = isApproved;
    }

    public Integer getIdrestaurantsReview() {
        return idrestaurantsReview;
    }

    public void setIdrestaurantsReview(Integer idrestaurantsReview) {
        this.idrestaurantsReview = idrestaurantsReview;
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

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
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
    public Collection<RestaurantsTypeRatings> getRestaurantsTypeRatingsCollection() {
        return restaurantsTypeRatingsCollection;
    }

    public void setRestaurantsTypeRatingsCollection(Collection<RestaurantsTypeRatings> restaurantsTypeRatingsCollection) {
        this.restaurantsTypeRatingsCollection = restaurantsTypeRatingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrestaurantsReview != null ? idrestaurantsReview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RestaurantsReview)) {
            return false;
        }
        RestaurantsReview other = (RestaurantsReview) object;
        if ((this.idrestaurantsReview == null && other.idrestaurantsReview != null) || (this.idrestaurantsReview != null && !this.idrestaurantsReview.equals(other.idrestaurantsReview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.RestaurantsReview[ idrestaurantsReview=" + idrestaurantsReview + " ]";
    }

}
