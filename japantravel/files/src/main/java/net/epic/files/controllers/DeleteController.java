package net.epic.files.controllers;

import net.epic.files.services.FileDataPersistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is used to call file delete REST controller
 *
 * @author ishan
 * @version 1.0.0
 * @since Version 1.0.0
 */
@RestController
@RequestMapping("/delete")

public class DeleteController {
    private static final Logger logger = LoggerFactory.getLogger(DeleteController.class);
    private FileDataPersistService fileDataPersistService;

    /**
     * Spring Autowired Constructor for dependency injection
     *
     * @param fileDataPersistService Upload Database Layer Service See {@link FileDataPersistService}
     */
    @Autowired
    public DeleteController(FileDataPersistService fileDataPersistService) {
        this.fileDataPersistService = fileDataPersistService;
    }

    /**
     * @param id delete file id(string type)
     * @return boolean value will be return
     */
    @DeleteMapping(value = "/delete{id}")
    public Boolean deleteFile(@PathVariable("id") String id) {
        Boolean status = fileDataPersistService.deleteSpecificFile(id);
        logger.error("error when getting return id");
        return status;
    }
}
