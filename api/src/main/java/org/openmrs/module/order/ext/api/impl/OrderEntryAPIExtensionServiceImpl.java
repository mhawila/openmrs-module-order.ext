/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.order.ext.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.order.ext.api.OrderEntryAPIExtensionService;
import org.openmrs.module.order.ext.api.dao.OrderEntryAPIExtensionDao;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderEntryAPIExtensionServiceImpl extends BaseOpenmrsService implements OrderEntryAPIExtensionService {
	
	@Autowired
	OrderEntryAPIExtensionDao dao;
	
	public void setDao(OrderEntryAPIExtensionDao dao) {
		this.dao = dao;
	}
}
