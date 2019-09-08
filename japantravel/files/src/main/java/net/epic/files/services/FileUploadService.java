/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.files.services;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

/**
 * File Upload File System Layer Service
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Version 1.0.0
 */
@Service("fileUploadService")
public class FileUploadService {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadService.class);
    private final Path fileStorageLocation;
    private FileDataPersistService fileDataPersistService;
    private String uploadDirectory;

    /**
     * Spring Autowired Constructor for dependency injection
     *
     * @param fileUploadLocation     File Upload location read from the configuration properties
     * @param fileDataPersistService File Upload Database Layer Service See {@link FileDataPersistService}
     */
    public FileUploadService(@Value("${fileUploadPath}") String fileUploadLocation,
                             FileDataPersistService fileDataPersistService) {

        this.fileDataPersistService = fileDataPersistService;
        this.uploadDirectory = fileUploadLocation;
        this.fileStorageLocation = Paths.get(fileUploadLocation)
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            logger.error("FAILED TO CREATE FILE UPLOAD LOCATION. CHECK PERMISSIONS & PATH IN BOOT PROPERTIES!");
        }

    }

    /**
     * Handles Single file uploading by unwrapping MultipartFile Object
     *
     * @param file {@link MultipartFile} Object containing file to be uploaded
     * @return ID of the file uploaded. (ID which refers to the file in the DB; Rest of the information are kept in DB)
     */
    public String uploadFile(MultipartFile file) {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        if (fileName.contains("..")) {
            logger.error("Sorry! Filename contains invalid path sequence!");
            return null;
        }

        try {

            UUID uuid = UUID.randomUUID();
            String fileID = uuid.toString();
            String fileExt = FilenameUtils.getExtension(fileName);
            String fileStoreAlias = fileID.concat(".").concat(fileExt);

            logger.info("UPLOADING..");
            Path targetLocation = this.fileStorageLocation.resolve(fileStoreAlias);

            File fileToUpload = targetLocation.toFile();

            FileUtils.copyInputStreamToFile(file.getInputStream(), fileToUpload);

            fileDataPersistService.persistToDB(fileToUpload.getAbsolutePath().substring(uploadDirectory.length()), targetLocation.toString(), resolveMediaTypeByExtension(fileExt), fileName, fileID);
            logger.info("File Upload success.");

            return fileID;

        } catch (IOException ex) {
            logger.info("Could not store file " + fileName + ". Please try again!", ex);
            return null;
        }

    }

    /**
     * Load the given file as a resource to Boot Application
     *
     * @param absolutePath Absolute path to the file to be loaded
     * @return {@link Resource} Object wrapped by file loaded
     */
    public Resource loadFileAsResource(String absolutePath) {
        try {
            Path filePath = this.fileStorageLocation.resolve(absolutePath).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                logger.info("FILE NOT FOUND!");
                return null;
            }
        } catch (MalformedURLException ex) {
            logger.info("FILE PATH IS INVALID!");
            return null;
        }
    }

    /**
     * Method to resolve {@link org.springframework.http.MediaType} from the file extension
     *
     * @param ext Extension of the uploaded file
     * @return The media type from the associated with the extention
     */
    private String resolveMediaTypeByExtension(String ext) {
        switch (ext) {
            case "png":
                return "image/png";
            case "jpeg":
            case "jpg":
                return "image/jpeg";
            case "pdf":
                return "application/pdf";
            case "txt":
                return "text/plain";
            default:
                return "application/octet-stream";
        }
    }

}
