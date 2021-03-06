/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: ChainedCall3.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.testelements.continuations;

import com.uwyn.rife.engine.Element;

public class ChainedCall3 extends Element
{
	public void processElement()
	{
		String before = "before chained call 3";
		String after = "after chained call 3";
		
		print(before+"\n"+getContinuationId()+"\n");
		pause();
		print(after+"\n");
		answer();
	}
}

