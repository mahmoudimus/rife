/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: NamedSubmissionBeanExistsException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.exceptions;

public class NamedSubmissionBeanExistsException extends EngineException
{
	private static final long serialVersionUID = 2104467187586278268L;

	private String	mDeclarationName = null;
	private String	mSubmissionName = null;
	private String	mBeanName = null;

	public NamedSubmissionBeanExistsException(String declarationName, String submissionName, String beanName)
	{
		super("The submission '"+submissionName+"' of element '"+declarationName+"' already contains the named bean '"+beanName+"'.");
		
		mDeclarationName = declarationName;
		mSubmissionName = submissionName;
		mBeanName = beanName;
	}
	
	public String getDeclarationName()
	{
		return mDeclarationName;
	}
	
	public String getSubmissionName()
	{
		return mSubmissionName;
	}
	
	public String getBeanName()
	{
		return mBeanName;
	}
}
