/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: DeleteContentDataErrorException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.cmf.dam.contentstores.exceptions;

import com.uwyn.rife.cmf.dam.exceptions.ContentManagerException;
import com.uwyn.rife.database.exceptions.DatabaseException;

public class DeleteContentDataErrorException extends ContentManagerException
{
	private static final long serialVersionUID = -3693774941096316094L;

	private int	mId = -1;
	
	public DeleteContentDataErrorException(int id, DatabaseException cause)
	{
		super("Unexpected error while deleting the content with the id '"+id+"'.", cause);
		
		mId = id;
	}
	
	public int getId()
	{
		return mId;
	}
}
