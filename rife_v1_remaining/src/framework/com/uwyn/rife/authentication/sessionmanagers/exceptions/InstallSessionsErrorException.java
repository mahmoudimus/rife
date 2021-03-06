/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: InstallSessionsErrorException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.authentication.sessionmanagers.exceptions;

import com.uwyn.rife.authentication.exceptions.SessionManagerException;
import com.uwyn.rife.database.exceptions.DatabaseException;

public class InstallSessionsErrorException extends SessionManagerException
{
	private static final long serialVersionUID = -2782754934511672351L;

	public InstallSessionsErrorException()
	{
		this(null);
	}

	public InstallSessionsErrorException(DatabaseException cause)
	{
		super("Can't install the session database structure.", cause);
	}
}
