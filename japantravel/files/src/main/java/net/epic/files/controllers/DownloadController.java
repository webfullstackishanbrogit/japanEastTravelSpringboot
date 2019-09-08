/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.files.controllers;

import net.epic.files.entity.FileStorage;
import net.epic.files.repository.FileStorageRepository;
import net.epic.files.services.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * File Downloads and Resource Linking Controller collection
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Version 1.0.0
 */
@RestController
@RequestMapping("/file")
public class DownloadController {

    private static final Logger logger = LoggerFactory.getLogger(DownloadController.class);
    private FileStorageRepository fileStorageRepository;
    private FileUploadService fileUploadService;

    /**
     * Spring Autowired constructor for dependency injection
     *
     * @param fileStorageRepository Spring Autowired dependency See {@link FileStorageRepository }
     * @param fileUploadService     Spring Autowired dependency See {@link FileUploadService }
     */
    @Autowired
    public DownloadController(FileStorageRepository fileStorageRepository, FileUploadService fileUploadService) {
        this.fileStorageRepository = fileStorageRepository;
        this.fileUploadService = fileUploadService;
    }

    /**
     * File download and resource linking controller endopont
     *
     * @param fileId ID of the file
     * @return The file as a resource OR and empty response with size 0Kb if not found
     */
    @GetMapping("/{fileId}")
    public ResponseEntity<Resource> fetchFile(@PathVariable("fileId") String fileId) {
        FileStorage fileDetails = fileStorageRepository.findByFileId(fileId);
        if (fileDetails == null) {
            logger.info("Requested resource is not found! {}", fileId);
            return null;
        }
        Resource resource = fileUploadService.loadFileAsResource(fileDetails.getAbsolutePath());

        if (resource == null) {
            logger.info("RESOURCE 404");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileDetails.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDetails.getOriginalName() + "\"")
                .body(resource);

    }
}
