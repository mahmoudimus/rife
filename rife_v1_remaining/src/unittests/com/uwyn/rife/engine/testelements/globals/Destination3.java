/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: Destination3.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.testelements.globals;

import com.uwyn.rife.engine.Element;
import com.uwyn.rife.tools.StringUtils;

public class Destination3 extends Element
{
	public void processElement()
	{
		print("global exit : "+getInput("globalvar1")+","+StringUtils.join(getInputValues("globalvar2"),"|"));
	}
}

