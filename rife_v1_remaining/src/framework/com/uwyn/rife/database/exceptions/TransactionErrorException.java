/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: TransactionErrorException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.database.exceptions;

import com.uwyn.rife.database.Datasource;

public class TransactionErrorException extends DatabaseException
{
	private static final long serialVersionUID = -5022112556565975376L;

	private Datasource	mDatasource = null;

	TransactionErrorException(String action, Datasource datasource, Throwable cause)
	{
		super(action, cause);
		mDatasource = datasource;
	}

	public Datasource getDatasource()
	{
		return mDatasource;
	}
}
