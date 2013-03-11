/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: DefaultFocusSetter.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.swing;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class DefaultFocusSetter extends Thread
{
	private JComponent mComponentToFocus = null;

	public DefaultFocusSetter(DefaultFocused object)
	{
		mComponentToFocus = object.getDefaultFocus();
		SwingUtilities.invokeLater(this);
	}

	public void run()
	{
		if (null != mComponentToFocus)
		{
			mComponentToFocus.requestFocus();
		}
	}
}


