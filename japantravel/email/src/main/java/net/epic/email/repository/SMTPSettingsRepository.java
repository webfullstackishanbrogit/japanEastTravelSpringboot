/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.email.repository;

import net.epic.email.entity.SMTPSettings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD Repository for {@link SMTPSettings}
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@Repository
public interface SMTPSettingsRepository extends CrudRepository<SMTPSettings, Integer> {

    /**
     * Fetch most recent configuration for SMTP settings
     *
     * @return SMTP Settings object
     */
    SMTPSettings findFirstByOrderByUpdatedTimeDesc();
}
