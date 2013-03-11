/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: BeanParent.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.testelements.inheritance;

import com.uwyn.rife.engine.Element;
import com.uwyn.rife.engine.testelements.outputs.BeanImpl;

public class BeanParent extends Element
{
	public void processElement()
	{
		if (hasSubmission("activatechild"))
		{
			BeanImpl bean = new BeanImpl();
			bean.setLong(34347897L);
			setOutputBean(bean);
		}
		
		print("<html><body><a href=\""+getSubmissionQueryUrl("activatechild")+"\">activate child</a></body></html>");
	}
	
	public boolean childTriggered(String name, String[] values)
	{
		if (name.equals("long") &&
			Long.parseLong(values[0]) > 20)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

