/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.files.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author uditha
 */
@Entity
@Table(name = "file_metadata")
@XmlRootElement
@Data
public class FileMetadata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "file_id")
    private String fileId;
    @Lob
    @Column(name = "metadata")
    private Object metadata;
    @JoinColumn(name = "file_id", referencedColumnName = "file_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private FileStorage fileStorage;

}
