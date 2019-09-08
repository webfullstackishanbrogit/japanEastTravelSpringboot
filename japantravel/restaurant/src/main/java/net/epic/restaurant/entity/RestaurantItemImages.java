package net.epic.restaurant.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "restaurant_item_images")
@XmlRootElement
@Data
public class RestaurantItemImages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrestaurant_item_images")
    private Integer idrestaurantItemImages;
    @Basic(optional = false)
    @Column(name = "image_path")
    private String imagePath;
    @JoinColumn(name = "restaurant_items_id", referencedColumnName = "idrestaurant_items")
    @ManyToOne(optional = false)
    private RestaurantItems restaurantItemsId;

}
