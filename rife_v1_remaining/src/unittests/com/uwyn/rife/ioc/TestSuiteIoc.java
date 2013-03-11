/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: TestSuiteIoc.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.ioc;

import com.uwyn.rife.RifeTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TestSuiteIoc extends TestSuite
{
	public static Test suite()
	{
		RifeTestSuite suite = new RifeTestSuite("IoC test suite");
		
		suite.addTestSuite(com.uwyn.rife.ioc.TestHierarchicalProperties.class);
		suite.addTestSuite(com.uwyn.rife.ioc.TestPropertyValueList.class);
		suite.addTestSuite(com.uwyn.rife.ioc.TestPropertyValueObject.class);
		suite.addTestSuite(com.uwyn.rife.ioc.TestPropertyValueParticipant.class);
		suite.addTestSuite(com.uwyn.rife.ioc.TestPropertyValueTemplate.class);
		
		return suite;
	}
}
