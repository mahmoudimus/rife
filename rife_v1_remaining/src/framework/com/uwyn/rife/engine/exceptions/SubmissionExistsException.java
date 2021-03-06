/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: SubmissionExistsException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.exceptions;

public class SubmissionExistsException extends EngineException
{
	private static final long serialVersionUID = 2521040713809669758L;

	private String	mDeclarationName = null;
	private String	mSubmissionName = null;

	public SubmissionExistsException(String declarationName, String submissionName)
	{
		super("The element '"+declarationName+"' already contains submission '"+submissionName+"'.");
		
		mDeclarationName = declarationName;
		mSubmissionName = submissionName;
	}
	
	public String getDeclarationName()
	{
		return mDeclarationName;
	}
	
	public String getSubmissionName()
	{
		return mSubmissionName;
	}
}
