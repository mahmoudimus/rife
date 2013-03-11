/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: GetTasksToProcessErrorException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.scheduler.taskmanagers.exceptions;

import com.uwyn.rife.database.exceptions.DatabaseException;
import com.uwyn.rife.scheduler.exceptions.TaskManagerException;

public class GetTasksToProcessErrorException extends TaskManagerException
{
	private static final long serialVersionUID = -4883619369685381990L;

	public GetTasksToProcessErrorException()
	{
		this(null);
	}

	public GetTasksToProcessErrorException(DatabaseException cause)
	{
		super("Unable to get the tasks to process.", cause);
	}
}
