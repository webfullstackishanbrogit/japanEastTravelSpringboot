/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.sms.repository;

import net.epic.sms.entity.TwillioSettings;
import org.springframework.data.repository.CrudRepository;

public interface TwillioSettingsRepository extends CrudRepository<TwillioSettings, String> {

    TwillioSettings findFirstByOrderByUpdatedAtDesc();
}
