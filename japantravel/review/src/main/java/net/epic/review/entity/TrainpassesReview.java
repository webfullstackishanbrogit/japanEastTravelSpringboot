package net.epic.review.entity;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Entity Class for the table of trainpasses_review
 * @author uditha
 */
@Entity
@Table(name = "trainpasses_review")
@XmlRootElement
public class TrainpassesReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtrainpasses_review")
    private Integer idtrainpassesReview;
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
    @Column(name = "trainpasses_id")
    private Integer trainpassesId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainpassesReviewId")
    private Collection<TrainpassesTypeRatings> trainpassesTypeRatingsCollection;

    public TrainpassesReview() {
    }

    public TrainpassesReview(Integer idtrainpassesReview) {
        this.idtrainpassesReview = idtrainpassesReview;
    }

    public TrainpassesReview(Integer idtrainpassesReview, int userId, String username, String isUpdated, String isApproved) {
        this.idtrainpassesReview = idtrainpassesReview;
        this.userId = userId;
        this.username = username;
        this.isUpdated = isUpdated;
        this.isApproved = isApproved;
    }

    public Integer getIdtrainpassesReview() {
        return idtrainpassesReview;
    }

    public void setIdtrainpassesReview(Integer idtrainpassesReview) {
        this.idtrainpassesReview = idtrainpassesReview;
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

    public Integer getTrainpassesId() {
        return trainpassesId;
    }

    public void setTrainpassesId(Integer trainpassesId) {
        this.trainpassesId = trainpassesId;
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
    public Collection<TrainpassesTypeRatings> getTrainpassesTypeRatingsCollection() {
        return trainpassesTypeRatingsCollection;
    }

    public void setTrainpassesTypeRatingsCollection(Collection<TrainpassesTypeRatings> trainpassesTypeRatingsCollection) {
        this.trainpassesTypeRatingsCollection = trainpassesTypeRatingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrainpassesReview != null ? idtrainpassesReview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainpassesReview)) {
            return false;
        }
        TrainpassesReview other = (TrainpassesReview) object;
        if ((this.idtrainpassesReview == null && other.idtrainpassesReview != null) || (this.idtrainpassesReview != null && !this.idtrainpassesReview.equals(other.idtrainpassesReview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.TrainpassesReview[ idtrainpassesReview=" + idtrainpassesReview + " ]";
    }

}
