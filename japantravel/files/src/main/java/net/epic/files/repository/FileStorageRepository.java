/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.files.repository;

import net.epic.files.entity.FileStorage;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring DataJPA CrudRepository for {@link FileStorage} Entity
 */
public interface FileStorageRepository extends CrudRepository<FileStorage, String> {

    /**
     * Find file From Database
     *
     * @param fileId ID of the file to be searched for
     * @return {@link FileStorage} Entity of searched file OR null if not found on DB
     */
    FileStorage findByFileId(String fileId);


}
