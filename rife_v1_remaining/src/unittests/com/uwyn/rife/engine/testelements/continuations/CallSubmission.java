/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: CallSubmission.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.testelements.continuations;

import com.uwyn.rife.engine.Element;

public class CallSubmission extends Element
{
	public void processElement()
	{
		print("<a href=\""+getSubmissionQueryUrl("submission")+"\">submission</a>");
		pause();
		
		if (hasSubmission("submission"))
		{
			Boolean answer = (Boolean)call("exit");
			if (answer.booleanValue())
			{
				print("received yes"+getInput("input1"));
			}
			else
			{
				print("received no"+getInput("input1"));
			}
		}
	}
}

