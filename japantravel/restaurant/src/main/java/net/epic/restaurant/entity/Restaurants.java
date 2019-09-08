package net.epic.restaurant.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "restaurants")
@XmlRootElement
@Data
public class Restaurants implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrestaurants")
    private Integer idrestaurants;
    @Basic(optional = false)
    @Column(name = "restaurants_name")
    private String restaurantsName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ranking")
    private Double ranking;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "district_id")
    private Integer districtId;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;

}