/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: UnsupportedManyToOneValueTypeException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.database.querymanagers.generic.exceptions;

import com.uwyn.rife.database.exceptions.DatabaseException;

public class UnsupportedManyToOneValueTypeException extends DatabaseException
{
	private Class mBeanClass;
	private String mPropertyName;
	private Object mValue;
	
	public UnsupportedManyToOneValueTypeException(Class beanClass, String propertyName, Object value)
	{
		super("The bean '"+beanClass.getName()+"' declares a many-to-one relationship on property '"+propertyName+"', however the property's value type '"+value.getClass().getName()+"' is not supported. Only classes that implement the interfaces java.util.Collection can be used.");
		
		mBeanClass = beanClass;
		mPropertyName = propertyName;
		mValue = value;
	}
	
	public Class getBeanClass()
	{
		return mBeanClass;
	}
	
	public String getPropertyName()
	{
		return mPropertyName;
	}
	
	public Object getValue()
	{
		return mValue;
	}
}
