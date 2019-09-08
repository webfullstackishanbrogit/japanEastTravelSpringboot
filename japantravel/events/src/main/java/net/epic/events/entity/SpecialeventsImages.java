package net.epic.events.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Entity class for the table specialevents_images
 * @author uditha
 */
@Entity
@Table(name = "specialevents_images")
@XmlRootElement
@Data
public class SpecialeventsImages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspecialevents_images")
    private Integer idspecialeventsImages;
    @Column(name = "image_path_id")
    private String imagePathId;
    @JoinColumn(name = "specialevent_id", referencedColumnName = "idspecialevents")
    @ManyToOne(optional = false)
    private Specialevents specialeventId;
    
}
