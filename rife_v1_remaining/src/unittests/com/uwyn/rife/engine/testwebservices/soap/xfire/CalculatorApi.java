/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: CalculatorApi.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.testwebservices.soap.xfire;

public interface CalculatorApi
{
	public int add(int value1, int value2);
	public int substract(int value1, int value2);
}
