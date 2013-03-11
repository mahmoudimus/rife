/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: InputParameterConflictException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.exceptions;

public class InputParameterConflictException extends DeclarationConflictException
{
	private static final long serialVersionUID = 5132755621936743013L;

	private String	mSubmissionName = null;

	public InputParameterConflictException(String declarationName, String conflictName, String submissionName)
	{
		super("The input '"+conflictName+"' of element '"+declarationName+"' conflicts with an existing parameter of submission '"+submissionName+"'.", declarationName, conflictName);
		
		mSubmissionName = submissionName;
	}
	
	public String getSubmissionName()
	{
		return mSubmissionName;
	}
}
