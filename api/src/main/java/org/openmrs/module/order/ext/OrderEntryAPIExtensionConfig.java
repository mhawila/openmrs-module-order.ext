/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.order.ext;

import org.springframework.stereotype.Component;

/**
 * Contains module's config.
 */
@Component("order.ext.OrderEntryAPIExtensionConfig")
public class OrderEntryAPIExtensionConfig {
	
	public final static String MODULE_PRIVILEGE = "Order Entry API Extension Privilege";
	
	public final static String ORDER_NUMBER_GENERATOR_BEAN_ID = "orderEntry.CheckDigitOrderNumberGenerator";
}
