package net.epic.events.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
/**
 * Entity class for the table specialevents_tags
 * @author uditha
 */
@Entity
@Table(name = "specialevents_tags")
@XmlRootElement
@Data
public class SpecialeventsTags implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspecialevents_tags")
    private Integer idspecialeventsTags;
    @Lob
    @Column(name = "tag")
    private String tag;
    @Basic(optional = false)
    @Column(name = "is_enable")
    private boolean isEnable;
    @JoinColumn(name = "specialevents_id", referencedColumnName = "idspecialevents")
    @ManyToOne(optional = false)
    private Specialevents specialeventsId;


}
