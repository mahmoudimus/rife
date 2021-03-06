/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: GetTaskIdErrorException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.scheduler.taskmanagers.exceptions;

import com.uwyn.rife.database.exceptions.DatabaseException;
import com.uwyn.rife.scheduler.exceptions.TaskManagerException;

public class GetTaskIdErrorException extends TaskManagerException
{
	private static final long serialVersionUID = -1558135834952131030L;

	public GetTaskIdErrorException()
	{
		this(null);
	}

	public GetTaskIdErrorException(DatabaseException cause)
	{
		super("Unable to get a task id.", cause);
	}
}
