/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: Deployment.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.testelements.engine;

import com.uwyn.rife.engine.Element;

public class Deployment extends Element
{
	public void processElement()
	{
		print(((DeploymentDeployer)getDeployer()).getParam()+":"+((DeploymentDeployer)getDeployer()).getCount());
	}
	
	public Class getDeploymentClass()
	{
		return DeploymentDeployer.class;
	}
}

