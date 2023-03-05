/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.stackextend.training2.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.stackextend.training2.fulfilmentprocess.constants.Training2FulfilmentProcessConstants;

public class Training2FulfilmentProcessManager extends GeneratedTraining2FulfilmentProcessManager
{
	public static final Training2FulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (Training2FulfilmentProcessManager) em.getExtension(Training2FulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
