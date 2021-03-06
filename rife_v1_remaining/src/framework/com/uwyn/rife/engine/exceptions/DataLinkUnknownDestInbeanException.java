/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: DataLinkUnknownDestInbeanException.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.exceptions;

public class DataLinkUnknownDestInbeanException extends EngineException
{
	private static final long serialVersionUID = -2840600084761475650L;

	private String	mSiteDeclarationName = null;
	private String	mDestInbean = null;
	private String	mElementId = null;
	private String	mDestinationId = null;
	private boolean	mSnapback = false;

	public DataLinkUnknownDestInbeanException(String siteDeclarationName, String destinbean, String elementId, String destinationId, boolean snapback)
	{
		super("The site '"+siteDeclarationName+"' references an unknown destination element inbean '"+destinbean+"' in the "+(!snapback ? "" : "snapback ")+"datalink that originates at the element '"+elementId+"'"+(null == destinationId ? "" : " towards the element'"+destinationId+"'")+".");
		
		mSiteDeclarationName = siteDeclarationName;
		mDestInbean = destinbean;
		mElementId = elementId;
		mDestinationId = destinationId;
		mSnapback = snapback;
	}
	
	public String getSiteDeclarationName()
	{
		return mSiteDeclarationName;
	}
	
	public String getDestInbean()
	{
		return mDestInbean;
	}
	
	public String getElementId()
	{
		return mElementId;
	}
	
	public String getDestinationId()
	{
		return mDestinationId;
	}
	
	public boolean getSnapback()
	{
		return mSnapback;
	}
}
