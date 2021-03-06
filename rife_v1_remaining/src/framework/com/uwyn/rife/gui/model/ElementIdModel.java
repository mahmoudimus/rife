/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: ElementIdModel.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.gui.model;

import com.uwyn.rife.gui.model.exceptions.GuiModelException;

public class ElementIdModel extends ElementPropertyModel
{
	ElementIdModel(ElementModel element, String name)
	throws GuiModelException
	{
		super(element, name);
	}

    protected static ParticlePropertyModel findConflictingProperty(ParticleModel particle, Class type, String name)
	{
		assert particle != null;
		assert type != null;
		assert name != null;
		assert name.length() > 0;
		
		ParticleModel parent_particle = particle.getParent();
        if (parent_particle != null)
        {
            ElementIdModel	sibling_title = null;
			
			for (ParticleModel sibling : parent_particle.getChildren())
            {
                if (sibling instanceof ElementModel)
                {
                    sibling_title = ((ElementModel)sibling).getId();
                    if (sibling_title.getName().equals(name))
                    {
                        return sibling_title;
                    }
                }
            }
        }
		
		return null;
	}
}


