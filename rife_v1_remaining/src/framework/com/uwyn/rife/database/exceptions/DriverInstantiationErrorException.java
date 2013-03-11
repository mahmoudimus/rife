/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: DriverInstantiationErrorException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.database.exceptions;

public class DriverInstantiationErrorException extends DatabaseException
{
	private static final long serialVersionUID = -8357643089890580253L;

	private String mDriver = null;

	public DriverInstantiationErrorException(String driver, Throwable cause)
	{
		super("Couldn't instantiate the JDBC driver '"+driver+"'.", cause);
		mDriver = driver;
	}

	public String getDriver()
	{
		return mDriver;
	}
}
