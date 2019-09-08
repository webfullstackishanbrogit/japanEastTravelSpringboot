package net.epic.review.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Entity Class for the table of transportation_type_ratings
 * @author uditha
 */
@Entity
@Table(name = "transportation_type_ratings")
@XmlRootElement
public class TransportationTypeRatings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransportation_type_ratings")
    private Integer idtransportationTypeRatings;
    @Basic(optional = false)
    @Column(name = "star_count")
    private int starCount;
    @JoinColumn(name = "transportation_review_id", referencedColumnName = "idtransportation_review")
    @ManyToOne(optional = false)
    private TransportationReview transportationReviewId;
    @JoinColumn(name = "review_type_id", referencedColumnName = "idreview_types")
    @ManyToOne(optional = false)
    private ReviewTypes reviewTypeId;

    public TransportationTypeRatings() {
    }

    public TransportationTypeRatings(Integer idtransportationTypeRatings) {
        this.idtransportationTypeRatings = idtransportationTypeRatings;
    }

    public TransportationTypeRatings(Integer idtransportationTypeRatings, int starCount) {
        this.idtransportationTypeRatings = idtransportationTypeRatings;
        this.starCount = starCount;
    }

    public Integer getIdtransportationTypeRatings() {
        return idtransportationTypeRatings;
    }

    public void setIdtransportationTypeRatings(Integer idtransportationTypeRatings) {
        this.idtransportationTypeRatings = idtransportationTypeRatings;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public TransportationReview getTransportationReviewId() {
        return transportationReviewId;
    }

    public void setTransportationReviewId(TransportationReview transportationReviewId) {
        this.transportationReviewId = transportationReviewId;
    }

    public ReviewTypes getReviewTypeId() {
        return reviewTypeId;
    }

    public void setReviewTypeId(ReviewTypes reviewTypeId) {
        this.reviewTypeId = reviewTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransportationTypeRatings != null ? idtransportationTypeRatings.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransportationTypeRatings)) {
            return false;
        }
        TransportationTypeRatings other = (TransportationTypeRatings) object;
        if ((this.idtransportationTypeRatings == null && other.idtransportationTypeRatings != null) || (this.idtransportationTypeRatings != null && !this.idtransportationTypeRatings.equals(other.idtransportationTypeRatings))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.TransportationTypeRatings[ idtransportationTypeRatings=" + idtransportationTypeRatings + " ]";
    }

}
