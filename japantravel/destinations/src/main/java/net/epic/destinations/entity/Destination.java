package net.epic.destinations.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 * Entity class for the Destination
 * @author uditha
 */
@Entity
@Table(name = "destination")
@XmlRootElement
@Data
public class Destination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddestination")
    private Integer iddestination;
    @Basic(optional = false)
    @Lob
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "address")
    private String address;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "ranking")
    private Double ranking;
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "destrict_id")
    private Integer destrictId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinationId")
    private Collection<DestinationTags> destinationTagsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinationId")
    private Collection<DestinationImages> destinationImagesCollection;

    @XmlTransient
    public Collection<DestinationTags> getDestinationTagsCollection() {
        return destinationTagsCollection;
    }

    public void setDestinationTagsCollection(Collection<DestinationTags> destinationTagsCollection) {
        this.destinationTagsCollection = destinationTagsCollection;
    }

    @XmlTransient
    public Collection<DestinationImages> getDestinationImagesCollection() {
        return destinationImagesCollection;
    }

    public void setDestinationImagesCollection(Collection<DestinationImages> destinationImagesCollection) {
        this.destinationImagesCollection = destinationImagesCollection;
    }


}
