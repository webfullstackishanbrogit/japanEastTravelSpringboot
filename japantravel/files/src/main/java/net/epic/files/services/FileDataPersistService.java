/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.files.services;

import net.epic.files.entity.FileStorage;
import net.epic.files.repository.FileStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * File Upload Database Layer Service
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Version 1.0.0
 */
@Service
public class FileDataPersistService {

    private FileStorageRepository fileStorageRepository;

    /**
     * Constructor for Spring Autowired dependencies
     *
     * @param fileStorageRepository CRUDRepository for FileStorage Entity
     */
    @Autowired
    public FileDataPersistService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }

    /**
     * Save file Details to DB
     *
     * @param relativePath Relative path of the uploaded file
     * @param absolutePath Absolute path in the File System
     * @param fileType     Type of the file. (pdf, jpg etc)
     * @param fileName     Original File Name
     * @param fileID       ID of the file generated as UUID
     * @return ID of the file after saving to DB (Same ID which was submitted as file ID above!)
     */
    String persistToDB(String relativePath, String absolutePath, String fileType, String fileName, String fileID) {
        FileStorage fileStorage = new FileStorage();
        fileStorage.setCreatedTime(new Date());
        fileStorage.setUpdatedTime(new Date());
        fileStorage.setAbsolutePath(absolutePath);
        fileStorage.setFileType(fileType);
        fileStorage.setRelativePath(relativePath);
        fileStorage.setOriginalName(fileName);
        fileStorage.setFileId(fileID);

        fileStorageRepository.save(fileStorage);

        return fileID;
    }

    /**
     * delete file according to file id
     *
     * @param id deleted file id
     * @return boolean value will be return
     */
    public Boolean deleteSpecificFile(String id) {

        if (id.isEmpty()) {
            return false;
        } else {
            fileStorageRepository.deleteById(id);
            return true;
        }

    }

}
