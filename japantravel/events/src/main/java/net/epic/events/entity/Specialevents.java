package net.epic.events.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


/**
 * Entity class for the table specialevents
 * @author uditha
 */
@Entity
@Table(name = "specialevents")
@XmlRootElement
@Data
public class Specialevents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspecialevents")
    private Integer idspecialevents;
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
    @Column(name = "location_id")
    private Integer locationId;
    @Column(name = "event_date")
    @Temporal(TemporalType.DATE)
    private Date eventDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialeventsId")
    private Collection<SpecialeventsTags> specialeventsTagsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialeventId")
    private Collection<SpecialeventsImages> specialeventsImagesCollection;

    @XmlTransient
    public Collection<SpecialeventsTags> getSpecialeventsTagsCollection() {
        return specialeventsTagsCollection;
    }

    public void setSpecialeventsTagsCollection(Collection<SpecialeventsTags> specialeventsTagsCollection) {
        this.specialeventsTagsCollection = specialeventsTagsCollection;
    }

    @XmlTransient
    public Collection<SpecialeventsImages> getSpecialeventsImagesCollection() {
        return specialeventsImagesCollection;
    }

    public void setSpecialeventsImagesCollection(Collection<SpecialeventsImages> specialeventsImagesCollection) {
        this.specialeventsImagesCollection = specialeventsImagesCollection;
    }

}
