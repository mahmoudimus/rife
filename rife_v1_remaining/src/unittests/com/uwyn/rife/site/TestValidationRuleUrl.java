/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: TestValidationRuleUrl.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.site;

import junit.framework.TestCase;

public class TestValidationRuleUrl extends TestCase
{
	public TestValidationRuleUrl(String name)
	{
		super(name);
	}

	public void testInstantiation()
	{
		Bean bean = new Bean("http://www.test.com");
		ValidationRuleUrl rule = new ValidationRuleUrl("property").setBean(bean);
		assertNotNull(rule);
	}
	
	public void testValid()
	{
		Bean bean = new Bean("http://www.test.com");
		ValidationRuleUrl rule = new ValidationRuleUrl("property").setBean(bean);
		assertTrue(rule.validate());
	}
	
	public void testValidArray()
	{
		Bean bean = new Bean(new String[] {"http://www.test.com", "http://www.uwyn.com", "http://www.rifers.org"});
		ValidationRuleUrl rule = new ValidationRuleUrl("arrayProperty").setBean(bean);
		assertTrue(rule.validate());
	}
	
	public void testInvalid()
	{
		Bean bean = new Bean("htt:www/.test.com");
		ValidationRuleUrl rule = new ValidationRuleUrl("property").setBean(bean);
		assertFalse(rule.validate());
	}
	
	public void testInvalidArray()
	{
		Bean bean = new Bean(new String[] {"http://www.test.com", "http://www.uwyn.com", "htt:www/.rifersorg"});
		ValidationRuleUrl rule = new ValidationRuleUrl("arrayProperty").setBean(bean);
		assertFalse(rule.validate());
	}
	
	public void testUnknownProperty()
	{
		Bean bean = new Bean("http://www.test.com");
		ValidationRuleUrl rule = new ValidationRuleUrl("unknown_property").setBean(bean);
		assertTrue(rule.validate());
	}
	
	public void testGetError()
	{
		Bean bean = new Bean("http://www.test.com");
		ValidationRuleUrl rule = new ValidationRuleUrl("property").setBean(bean);
		ValidationError error = rule.getError();
		assertEquals(ValidationError.IDENTIFIER_INVALID, error.getIdentifier());
		assertEquals("property", error.getSubject());
		assertEquals(rule.getSubject(), error.getSubject());
	}
	
	public class Bean
	{
		private String		mProperty = null;
		private String[]	mArrayProperty = null;
		
		public Bean(String property)
		{
			mProperty = property;
		}
		
		public Bean(String[] arrayProperty)
		{
			mArrayProperty = arrayProperty;
		}
		
		public void setArrayProperty(String[] arrayProperty)
		{
			mArrayProperty = arrayProperty;
		}
		
		public String[] getArrayProperty()
		{
			return mArrayProperty;
		}
		
		public void setProperty(String property)
		{
			mProperty = property;
		}
		
		public String getProperty()
		{
			return mProperty;
		}
	}
}
