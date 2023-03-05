/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.stackextend.training2.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.stackextend.training2.core.constants.Training2CoreConstants;
import com.stackextend.training2.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class Training2CoreManager extends GeneratedTraining2CoreManager
{
	public static final Training2CoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (Training2CoreManager) em.getExtension(Training2CoreConstants.EXTENSIONNAME);
	}
}
