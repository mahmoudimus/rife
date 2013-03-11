/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: ValidationRuleEmail.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.site;

import static com.uwyn.rife.site.ValidityChecks.checkEmail;

import java.lang.reflect.Array;

import com.uwyn.rife.tools.BeanUtils;
import com.uwyn.rife.tools.exceptions.BeanUtilsException;

public class ValidationRuleEmail extends PropertyValidationRule
{
	public ValidationRuleEmail(String propertyName)
	{
		super(propertyName);
	}
	
	public boolean validate()
	{
		Object value;
		try
		{
			value = BeanUtils.getPropertyValue(getBean(), getPropertyName());
		}
		catch (BeanUtilsException e)
		{
			// an error occurred when obtaining the value of the property
			// just consider it valid to skip over it
			return true;
		}
		
		if (null == value)
		{
			return true;
		}
		
		ConstrainedProperty constrained_property = ConstrainedUtils.getConstrainedProperty(getBean(), getPropertyName());
		if (value.getClass().isArray())
		{
			int length = Array.getLength(value);
			for (int i = 0; i < length; i++)
			{
				if (!checkEmail(BeanUtils.formatPropertyValue(Array.get(value, i), constrained_property)))
				{
					return false;
				}
			}
			
			return true;
		}
		else
		{
			return checkEmail(BeanUtils.formatPropertyValue(value, constrained_property));
		}
	}
	
	public ValidationError getError()
	{
		return new ValidationError.INVALID(getSubject());
	}
}
