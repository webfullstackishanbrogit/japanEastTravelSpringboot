/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

/**
 * Package containing mail method for service invocation.
 * <p>
 * The confiugurations are fetched from DB during the application boot phase. Any update to configurations during
 * runtime will require reboot or refresh endpoint to be called to refresh scoped beans and apply new configurations.
 * <p>
 * FlyWay is used for migrating DB. A new database is required and other tables will
 * automatically be populated during the first boot of the application.
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
package net.epic.email;