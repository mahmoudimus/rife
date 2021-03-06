/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: TestPauseInWhile.java 3941 2008-04-26 21:28:32Z gbevin $
 */
package com.uwyn.rife.continuations;

public class TestPauseInWhile extends AbstractContinuableObject
{
	public void execute()
	{
		int count = 5;

		while (count > 0)
		{
			pause();
			count--;
		}
	}
}