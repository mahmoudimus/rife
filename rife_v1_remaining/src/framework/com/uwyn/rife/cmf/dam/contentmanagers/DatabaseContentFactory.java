/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: DatabaseContentFactory.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.cmf.dam.contentmanagers;

import com.uwyn.rife.database.Datasource;
import com.uwyn.rife.database.DbQueryManagerCache;
import com.uwyn.rife.database.DbQueryManagerFactory;

public abstract class DatabaseContentFactory extends DbQueryManagerFactory
{
	public static final String	MANAGER_PACKAGE_NAME = DatabaseContentFactory.class.getPackage().getName()+".databasedrivers.";
	
	private static DbQueryManagerCache	mCache = new DbQueryManagerCache();
	
	public static DatabaseContent getInstance(Datasource datasource)
	{
		return (DatabaseContent)getInstance(MANAGER_PACKAGE_NAME, mCache, datasource);
	}
}

