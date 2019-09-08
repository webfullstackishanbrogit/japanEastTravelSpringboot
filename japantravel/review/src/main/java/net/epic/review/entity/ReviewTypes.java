package net.epic.review.entity;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 * Entity Class for the table of review_types
 * @author uditha
 */

@Entity
@Table(name = "review_types")
@XmlRootElement
public class ReviewTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreview_types")
    private Integer idreviewTypes;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewTypeId")
    private Collection<TourpackagesTypeRatings> tourpackagesTypeRatingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewTypeId")
    private Collection<HotelsTypeRatings> hotelsTypeRatingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewTypeId")
    private Collection<TransportationTypeRatings> transportationTypeRatingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewTypeId")
    private Collection<DestinationTypeRatings> destinationTypeRatingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewTypeId")
    private Collection<ExperienceTypeRatings> experienceTypeRatingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewTypeId")
    private Collection<TrainpassesTypeRatings> trainpassesTypeRatingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewTypeId")
    private Collection<RestaurantsTypeRatings> restaurantsTypeRatingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewTypeId")
    private Collection<SpecialeventsTypeRatings> specialeventsTypeRatingsCollection;

    public ReviewTypes() {
    }

    public ReviewTypes(Integer idreviewTypes) {
        this.idreviewTypes = idreviewTypes;
    }

    public ReviewTypes(Integer idreviewTypes, String type, String category) {
        this.idreviewTypes = idreviewTypes;
        this.type = type;
        this.category = category;
    }

    public Integer getIdreviewTypes() {
        return idreviewTypes;
    }

    public void setIdreviewTypes(Integer idreviewTypes) {
        this.idreviewTypes = idreviewTypes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlTransient
    public Collection<TourpackagesTypeRatings> getTourpackagesTypeRatingsCollection() {
        return tourpackagesTypeRatingsCollection;
    }

    public void setTourpackagesTypeRatingsCollection(Collection<TourpackagesTypeRatings> tourpackagesTypeRatingsCollection) {
        this.tourpackagesTypeRatingsCollection = tourpackagesTypeRatingsCollection;
    }

    @XmlTransient
    public Collection<HotelsTypeRatings> getHotelsTypeRatingsCollection() {
        return hotelsTypeRatingsCollection;
    }

    public void setHotelsTypeRatingsCollection(Collection<HotelsTypeRatings> hotelsTypeRatingsCollection) {
        this.hotelsTypeRatingsCollection = hotelsTypeRatingsCollection;
    }

    @XmlTransient
    public Collection<TransportationTypeRatings> getTransportationTypeRatingsCollection() {
        return transportationTypeRatingsCollection;
    }

    public void setTransportationTypeRatingsCollection(Collection<TransportationTypeRatings> transportationTypeRatingsCollection) {
        this.transportationTypeRatingsCollection = transportationTypeRatingsCollection;
    }

    @XmlTransient
    public Collection<DestinationTypeRatings> getDestinationTypeRatingsCollection() {
        return destinationTypeRatingsCollection;
    }

    public void setDestinationTypeRatingsCollection(Collection<DestinationTypeRatings> destinationTypeRatingsCollection) {
        this.destinationTypeRatingsCollection = destinationTypeRatingsCollection;
    }

    @XmlTransient
    public Collection<ExperienceTypeRatings> getExperienceTypeRatingsCollection() {
        return experienceTypeRatingsCollection;
    }

    public void setExperienceTypeRatingsCollection(Collection<ExperienceTypeRatings> experienceTypeRatingsCollection) {
        this.experienceTypeRatingsCollection = experienceTypeRatingsCollection;
    }

    @XmlTransient
    public Collection<TrainpassesTypeRatings> getTrainpassesTypeRatingsCollection() {
        return trainpassesTypeRatingsCollection;
    }

    public void setTrainpassesTypeRatingsCollection(Collection<TrainpassesTypeRatings> trainpassesTypeRatingsCollection) {
        this.trainpassesTypeRatingsCollection = trainpassesTypeRatingsCollection;
    }

    @XmlTransient
    public Collection<RestaurantsTypeRatings> getRestaurantsTypeRatingsCollection() {
        return restaurantsTypeRatingsCollection;
    }

    public void setRestaurantsTypeRatingsCollection(Collection<RestaurantsTypeRatings> restaurantsTypeRatingsCollection) {
        this.restaurantsTypeRatingsCollection = restaurantsTypeRatingsCollection;
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
        hash += (idreviewTypes != null ? idreviewTypes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewTypes)) {
            return false;
        }
        ReviewTypes other = (ReviewTypes) object;
        if ((this.idreviewTypes == null && other.idreviewTypes != null) || (this.idreviewTypes != null && !this.idreviewTypes.equals(other.idreviewTypes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateexample.hibernate.ReviewTypes[ idreviewTypes=" + idreviewTypes + " ]";
    }

}
