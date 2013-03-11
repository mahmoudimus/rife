/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: ExitTarget.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.testelements.submission;

import com.uwyn.rife.engine.Element;

public class ExitTarget extends Element
{
	public void processElement()
	{
		if (hasSubmission("activate_exit"))
		{
			print("got submission, but I shouldn't, so this is a bug");
		}
		print("exit target : "+getInput("received_value"));
	}
}

