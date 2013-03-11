/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: TestJaiLoader.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.cmf.loader.image;

import com.uwyn.rife.resources.ResourceFinderClasspath;
import com.uwyn.rife.tools.FileUtils;
import java.awt.Image;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import junit.framework.TestCase;

public class TestJaiLoader extends TestCase
{
	public TestJaiLoader(String name)
	{
		super(name);
	}

	public void testIsBackendPresent()
	{
	    JaiLoader loader = new JaiLoader();
		assertTrue(loader.isBackendPresent());
	}

	public void testLoadSuccess()
	throws Exception
	{
	    JaiLoader loader = new JaiLoader();
		Set<String> errors = new HashSet<String>(); 
		URL image_resource = ResourceFinderClasspath.getInstance().getResource("uwyn.png");

		byte[] image_bytes = FileUtils.readBytes(image_resource);
		Image image = loader.load(image_bytes, false, errors);

		assertNotNull(image);
		assertEquals(0, errors.size());
	}

	public void testLoadUnsupportedType()
	throws Exception
	{
	    JaiLoader loader = new JaiLoader();
		Set<String> errors = new HashSet<String>(); 

		Image image = loader.load(new Object(), false, errors);

		assertNull(image);
		assertEquals(0, errors.size());
	}

	public void testLoadFromBytesSuccess()
	throws Exception
	{
	    JaiLoader loader = new JaiLoader();
		Set<String> errors = new HashSet<String>(); 
		URL image_resource = ResourceFinderClasspath.getInstance().getResource("uwyn.png");

		byte[] image_bytes = FileUtils.readBytes(image_resource);
		Image image = loader.loadFromBytes(image_bytes, errors);

		assertNotNull(image);
		assertEquals(0, errors.size());
	}

	public void testLoadFromBytesError()
	throws Exception
	{
	    JaiLoader loader = new JaiLoader();
		Set<String> errors = new HashSet<String>(); 

		byte[] image_bytes = new byte[] {2, 9, 7, 12, 45}; // just random values
		Image image = loader.loadFromBytes(image_bytes, errors);

		assertNull(image);
		assertEquals(1, errors.size());
	}

	public void testLoadFromBytesErrorNoList()
	throws Exception
	{
	    JaiLoader loader = new JaiLoader();

		byte[] image_bytes = new byte[] {2, 9, 7, 12, 45}; // just random values
		Image image = loader.loadFromBytes(image_bytes, null);

		assertNull(image);
	}
}
