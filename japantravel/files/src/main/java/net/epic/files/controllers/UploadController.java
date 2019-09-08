/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 *
 *
 */

package net.epic.files.controllers;

import net.epic.files.feign.SMSClient;
import net.epic.files.services.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * File Upload Controller collection
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Version 1.0.0
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    private FileUploadService fileUploadService;
    private SMSClient smsClient;

    /**
     * Spring Autowired constructor for constructor
     *
     * @param fileUploadService Spring Autowired dependency. See {@link FileUploadService}
     */
    @Autowired
    public UploadController(FileUploadService fileUploadService, SMSClient smsClient) {
        this.fileUploadService = fileUploadService;
        this.smsClient = smsClient;
    }

    /**
     * Single file upload controller endpoint
     *
     * @param file Multipart file which contains file to be uploaded
     * @return ID of the file saved after copying to file system. (ID is generated as a UUID String and is the primary key for backtracking the uploaded file)
     */
    @PostMapping("/")
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
            String fileID = fileUploadService.uploadFile(file);
        logger.info(fileID);
        return fileID;
    }

    @GetMapping("/test")
    public String test() {
        return smsClient.checkStatus();
    }

}
