/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com> and
 * JR Boyens <gnu-jrb[remove] at gmx dot net>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: BinaryBean.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.database.querymanagers.generic.beans;

public class BinaryBean
{
	private int 	mId = -1;
	private byte[] 	mTheBytes;

	public void setId(int id)
	{
		mId = id;
	}

	public int getId()
	{
		return mId;
	}

	public byte[] getTheBytes()
	{
		return mTheBytes;
	}

	public void setTheBytes(byte[] binary)
	{
		mTheBytes = binary;
	}
}

