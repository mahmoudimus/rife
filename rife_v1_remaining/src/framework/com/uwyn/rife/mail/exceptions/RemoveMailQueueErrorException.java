/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: RemoveMailQueueErrorException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.mail.exceptions;

import com.uwyn.rife.database.exceptions.DatabaseException;

public class RemoveMailQueueErrorException extends MailQueueManagerException
{
	private static final long serialVersionUID = 3868589784026081158L;

	public RemoveMailQueueErrorException(DatabaseException cause)
	{
		super("Can't remove the mail queue database structure.", cause);
	}
}
