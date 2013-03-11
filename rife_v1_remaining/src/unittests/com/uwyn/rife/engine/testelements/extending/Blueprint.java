/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: Blueprint.java 3958 2008-05-26 12:04:14Z gbevin $
 */
package com.uwyn.rife.engine.testelements.extending;

import com.uwyn.rife.engine.Element;
import com.uwyn.rife.engine.annotations.Elem;

import javax.servlet.http.Cookie;

@Elem(
	url=""
)
public class Blueprint extends Element
{
	public void processElement()
	{
		if (hasInputValue("switch"))
		{
			setOutput("output1", "output1"+getInput("switch"));
			exit(getInput("switch"));
		}
		
		print("Blueprint");
		print(getPropertyString("property1"));
		print(getPropertyString("property2"));
		print(getInput("input1"));
		print(getInput("input2"));
		print(getCookie("incookie1").getValue());
		print(getCookie("incookie2").getValue());
		if (hasSubmission("submission1"))
		{
			print(getParameter("param1"));
			print(getParameter("param2"));
		}
		setCookie(new Cookie("outcookie1", "outcookie1elementvalue"));
	}
}

