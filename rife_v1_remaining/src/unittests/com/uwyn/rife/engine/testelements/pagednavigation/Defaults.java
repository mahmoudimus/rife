/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: Defaults.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.testelements.pagednavigation;

import com.uwyn.rife.engine.Element;
import com.uwyn.rife.template.Template;
import com.uwyn.rife.site.PagedNavigation;
import com.uwyn.rife.tools.Convert;

public class Defaults extends Element
{
	public void processElement()
	{
		Template t = getHtmlTemplate(getPropertyString("template"));
		int offset = getInputInt("offset", 0);
		t.setValue("offset", offset);
		PagedNavigation.generateNavigation(this, t, Convert.toInt(getProperty("count"), 0), Convert.toInt(getProperty("limit"), 0), offset, Convert.toInt(getProperty("span"), 0), PagedNavigation.DEFAULT_EXIT, PagedNavigation.DEFAULT_OUTPUT, getPropertyString("pathinfo"));
		print(t.getBlock("content"));
	}
}
