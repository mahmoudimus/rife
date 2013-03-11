/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: InitConfigServlet.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine;

import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class InitConfigServlet implements InitConfig
{
	private ServletConfig	mConfig = null;
	
	public InitConfigServlet(ServletConfig config)
	{
		assert config != null;
		
		mConfig = config;
	}
	
	public Enumeration getInitParameterNames()
	{
		return mConfig.getInitParameterNames();
	}
	
	public String getInitParameter(String name)
	{
		return mConfig.getInitParameter(name);
	}

	public ServletContext getServletContext()
	{
		return mConfig.getServletContext();
	}
}


