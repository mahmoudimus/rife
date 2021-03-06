/*
 * Copyright 2001-2008 Geert Bevin <gbevin[remove] at uwyn dot com>
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: BeanNormalOutjection.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.testelements.outputs;

import com.uwyn.rife.engine.Element;
import java.util.ArrayList;

public class BeanNormalOutjection extends Element
{
	private BeanImpl mInbean;
	
	public void setInbean1(BeanImpl inbean)
	{
		mInbean = inbean;
	}
	
	public BeanImpl getOutbean1()
	{
		BeanImpl	bean = new BeanImpl();
		bean.setString("the string");
		bean.setStringbuffer(new StringBuffer("the stringbuffer"));
		bean.setInt(23154);
		bean.setInteger(new Integer(893749));
		bean.setChar('u');
		bean.setCharacter(new Character('R'));
		bean.setBoolean(true);
		bean.setBooleanObject(new Boolean(false));
		bean.setByte((byte)120);
		bean.setByteObject(new Byte((byte)21));
		bean.setDouble(34878.34);
		bean.setDoubleObject(new Double(25435.98));
		bean.setFloat((float)3434.76);
		bean.setFloatObject(new Float((float)6534.8));
		bean.setLong(34347897L);
		bean.setLongObject(new Long(2335454L));
		bean.setShort((short)32);
		bean.setShortObject(new Short((short)12));
		ArrayList list = new ArrayList();
		list.add("one");
		list.add(2);
		list.add("three");
		list.add(new Float(44.44));
		list.add(new StringBuffer("five"));
		bean.setArrayList(list);
		
		return bean;
	}
	
	public void processElement()
	{
		if (hasInputValue("string"))
		{
			print(getInput("string")+","+
				getInput("stringbuffer")+","+
				getInput("int")+","+
				getInput("integer")+","+
				getInput("char")+","+
				getElementInfo().containsInput("character")+","+
				getInput("boolean")+","+
				getInput("booleanObject")+","+
				getElementInfo().containsInput("byte")+","+
				getInput("byteObject")+","+
				getInput("double")+","+
				getInput("doubleObject")+","+
				getInput("float")+","+
				getInput("floatObject")+","+
				getInput("long")+","+
				getInput("longObject")+","+
				getInput("short")+","+
				getInput("shortObject")+","+
				getInput("arrayList"));
			print(mInbean);
		}
		else
		{
			exit("exit");
		}
	}
}

