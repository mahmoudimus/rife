/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: TargetRetrievalChild.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.testelements.inheritance;

import com.uwyn.rife.engine.Element;

public class TargetRetrievalChild extends Element
{
	public void processElement()
	{
		print(getTarget().getDeclarationName()+" : this is the child");
	}
}

