package net.epic.restaurant.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "item_category")
@XmlRootElement
@Data
public class ItemCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iditem_category")
    private Integer iditemCategory;
    @Basic(optional = false)
    @Column(name = "item_category_name")
    private String itemCategoryName;
    @Column(name = "is_enable")
    private Boolean isEnable;
    @OneToMany(mappedBy = "itemCategoryId")
    private Collection<RestaurantItems> restaurantItemsCollection;

    @XmlTransient
    public Collection<RestaurantItems> getRestaurantItemsCollection() {
        return restaurantItemsCollection;
    }

    public void setRestaurantItemsCollection(Collection<RestaurantItems> restaurantItemsCollection) {
        this.restaurantItemsCollection = restaurantItemsCollection;
    }


}