package net.epic.restaurant.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "restaurant_items")
@XmlRootElement
@Data
public class RestaurantItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrestaurant_items")
    private Integer idrestaurantItems;
    @Basic(optional = false)
    @Column(name = "item_name")
    private String itemName;
    @Lob
    @Column(name = "introduction")
    private String introduction;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ranking")
    private Double ranking;
    @JoinColumn(name = "item_category_id", referencedColumnName = "iditem_category")
    @ManyToOne
    private ItemCategory itemCategoryId;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "idrestaurants")
    @ManyToOne
    private Restaurants restaurantId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantItemsId")
    private Collection<RestaurantItemImages> restaurantItemImagesCollection;

    @XmlTransient
    public Collection<RestaurantItemImages> getRestaurantItemImagesCollection() {
        return restaurantItemImagesCollection;
    }

    public void setRestaurantItemImagesCollection(Collection<RestaurantItemImages> restaurantItemImagesCollection) {
        this.restaurantItemImagesCollection = restaurantItemImagesCollection;
    }

}