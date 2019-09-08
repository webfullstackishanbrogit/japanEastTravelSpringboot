package net.epic.destinations.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Entity class for the DestinationImages
 * @author uditha
 */
@Entity
@Table(name = "destination_images")
@XmlRootElement
@Data
public class DestinationImages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddestination_images")
    private Integer iddestinationImages;
    @Basic(optional = false)
    @Column(name = "image_path_id")
    private String imagePathId;
    @JoinColumn(name = "destination_id", referencedColumnName = "iddestination")
    @ManyToOne(optional = false)
    private Destination destinationId;

}
