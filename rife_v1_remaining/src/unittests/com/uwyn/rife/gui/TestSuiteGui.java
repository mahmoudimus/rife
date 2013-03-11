/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: TestSuiteGui.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.gui;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestSuiteGui extends TestSuite
{
	public static Test suite()
	{
		TestSuite suite = new TestSuite("Gui API test suite");

		suite.addTest(com.uwyn.rife.gui.model.TestSuiteModel.suite());

		return suite;
	}
}

