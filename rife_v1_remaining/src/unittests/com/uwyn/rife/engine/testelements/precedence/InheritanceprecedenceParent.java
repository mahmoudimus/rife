/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: InheritanceprecedenceParent.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.testelements.precedence;

import com.uwyn.rife.engine.Element;

public class InheritanceprecedenceParent extends Element
{
	public void processElement()
	{
		print("This is the inheritance precedence parent content");
	}
	
	public boolean childTriggered(String name, String[] values)
	{
		if (name.equals("trigger"))
		{
			return true;
		}
		
		return false;
	}
}
