package net.epic.destinations.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Entity class for the DestinationTags
 * @author uditha
 */
@Entity
@Table(name = "destination_tags")
@XmlRootElement
@Data
public class DestinationTags implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddestination_tags")
    private Integer iddestinationTags;
    @Basic(optional = false)
    @Lob
    @Column(name = "tag")
    private String tag;
    @Basic(optional = false)
    @Column(name = "is_enable")
    private String isEnable;
    @JoinColumn(name = "destination_id", referencedColumnName = "iddestination")
    @ManyToOne(optional = false)
    private Destination destinationId;

}
