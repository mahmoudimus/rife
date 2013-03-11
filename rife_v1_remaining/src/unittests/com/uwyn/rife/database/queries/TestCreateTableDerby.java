/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: TestCreateTableDerby.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.database.queries;

import com.uwyn.rife.database.BeanImpl;
import com.uwyn.rife.database.BeanImplConstrained;
import com.uwyn.rife.database.exceptions.ColumnsRequiredException;
import com.uwyn.rife.database.exceptions.TableNameRequiredException;
import com.uwyn.rife.database.exceptions.UnsupportedSqlFeatureException;
import java.math.BigDecimal;
import java.sql.Blob;

public class TestCreateTableDerby extends TestCreateTable
{
	public TestCreateTableDerby(String name)
	{
		super(name);
	}

	public void testInstantiationDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		assertNotNull(query);
		try
		{
			query.getSql();
			fail();
		}
		catch (TableNameRequiredException e)
		{
			assertEquals(e.getQueryName(), "CreateTable");
		}
	}

	public void testIncompleteQueryDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		try
		{
			query.getSql();
			fail();
		}
		catch (TableNameRequiredException e)
		{
			assertEquals(e.getQueryName(), "CreateTable");
		}
		query.table("tablename");
		try
		{
			query.getSql();
			fail();
		}
		catch (ColumnsRequiredException e)
		{
			assertEquals(e.getQueryName(), "CreateTable");
		}
		query.table("tablename")
			.column("string", String.class);
		assertNotNull(query.getSql());
	}

	public void testClearDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("string", String.class);
		assertNotNull(query.getSql());
		query.clear();
		try
		{
			query.getSql();
			fail();
		}
		catch (TableNameRequiredException e)
		{
			assertEquals(e.getQueryName(), "CreateTable");
		}
	}

	public void testColumnDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename1")
			.column("string", String.class)
			.column("stringbuffer", StringBuffer.class)
			.column("characterobject", Character.class)
			.column("booleanobject", Boolean.class)
			.column("byteobject", Byte.class)
			.column("doubleobject", Double.class)
			.column("floatobject", Float.class)
			.column("integerobject", Integer.class)
			.column("longobject", Long.class)
			.column("shortobject", Short.class)
			.column("bigdecimal", BigDecimal.class)
			.column("charcolumn", char.class)
			.column("booleancolumn", boolean.class)
			.column("bytecolumn", byte.class)
			.column("doublecolumn", double.class)
			.column("floatcolumn", float.class)
			.column("intcolumn", int.class)
			.column("longcolumn", long.class)
			.column("shortcolumn", short.class)
			.column("blobcolumn", Blob.class);
		assertEquals(query.getSql(), "CREATE TABLE tablename1 (string VARCHAR(32672), stringbuffer VARCHAR(32672), characterobject CHAR, booleanobject NUMERIC(1), byteobject SMALLINT, doubleobject FLOAT, floatobject FLOAT, integerobject INTEGER, longobject BIGINT, shortobject SMALLINT, bigdecimal NUMERIC, charcolumn CHAR, booleancolumn NUMERIC(1), bytecolumn SMALLINT, doublecolumn FLOAT, floatcolumn FLOAT, intcolumn INTEGER, longcolumn BIGINT, shortcolumn SMALLINT, blobcolumn BLOB)");
		execute(query);
	}

	public void testColumnPrecisionDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename1")
			.column("string", String.class, 255)
			.column("stringbuffer", StringBuffer.class, 100)
			.column("characterobject", Character.class, 20)
			.column("booleanobject", Boolean.class, 7)
			.column("byteobject", Byte.class, 9)
			.column("doubleobject", Double.class, 30, 2)
			.column("floatobject", Float.class, 20, 2)
			.column("integerobject", Integer.class, 10)
			.column("longobject", Long.class, 8)
			.column("shortobject", Short.class, 8)
			.column("bigdecimal", BigDecimal.class, 19, 9)
			.column("charcolumn", char.class, 10)
			.column("booleancolumn", boolean.class, 4)
			.column("bytecolumn", byte.class, 8)
			.column("doublecolumn", double.class, 12, 3)
			.column("floatcolumn", float.class, 13, 2)
			.column("intcolumn", int.class, 10)
			.column("longcolumn", long.class, 12)
			.column("shortcolumn", short.class, 9)
			.column("blobcolumn", Blob.class, 20);
		assertEquals(query.getSql(), "CREATE TABLE tablename1 (string VARCHAR(255), stringbuffer VARCHAR(100), characterobject CHAR(20), booleanobject NUMERIC(1), byteobject SMALLINT, doubleobject FLOAT, floatobject FLOAT, integerobject INTEGER, longobject BIGINT, shortobject SMALLINT, bigdecimal NUMERIC(19,9), charcolumn CHAR(10), booleancolumn NUMERIC(1), bytecolumn SMALLINT, doublecolumn FLOAT, floatcolumn FLOAT, intcolumn INTEGER, longcolumn BIGINT, shortcolumn SMALLINT, blobcolumn BLOB)");
		execute(query);
	}

	public void testColumnsBeanDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.columns(BeanImpl.class);
		assertEquals(query.getSql(), "CREATE TABLE tablename (propertyBigDecimal NUMERIC, propertyBoolean NUMERIC(1), propertyBooleanObject NUMERIC(1), propertyByte SMALLINT, propertyByteObject SMALLINT, propertyCalendar TIMESTAMP, propertyChar CHAR, propertyCharacterObject CHAR, propertyDate TIMESTAMP, propertyDouble FLOAT, propertyDoubleObject FLOAT, propertyEnum VARCHAR(255), propertyFloat FLOAT, propertyFloatObject FLOAT, propertyInt INTEGER, propertyIntegerObject INTEGER, propertyLong BIGINT, propertyLongObject BIGINT, propertyShort SMALLINT, propertyShortObject SMALLINT, propertySqlDate DATE, propertyString VARCHAR(32672), propertyStringbuffer VARCHAR(32672), propertyTime TIME, propertyTimestamp TIMESTAMP, CHECK (propertyEnum IS NULL OR propertyEnum IN ('VALUE_ONE','VALUE_TWO','VALUE_THREE')))");
		execute(query);
	}

	public void testColumnsBeanIncludedDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.columnsIncluded(BeanImpl.class, new String[] {"propertyBigDecimal", "propertyByte", "propertyFloat", "propertyStringbuffer", "propertyTime"});
		assertEquals(query.getSql(), "CREATE TABLE tablename (propertyBigDecimal NUMERIC, propertyByte SMALLINT, propertyFloat FLOAT, propertyStringbuffer VARCHAR(32672), propertyTime TIME)");
		execute(query);
	}

	public void testColumnsBeanExcludedDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.columnsExcluded(BeanImpl.class, new String[] {"propertyBigDecimal", "propertyByte", "propertyFloat", "propertyStringbuffer", "propertyTime"});
		assertEquals(query.getSql(), "CREATE TABLE tablename (propertyBoolean NUMERIC(1), propertyBooleanObject NUMERIC(1), propertyByteObject SMALLINT, propertyCalendar TIMESTAMP, propertyChar CHAR, propertyCharacterObject CHAR, propertyDate TIMESTAMP, propertyDouble FLOAT, propertyDoubleObject FLOAT, propertyEnum VARCHAR(255), propertyFloatObject FLOAT, propertyInt INTEGER, propertyIntegerObject INTEGER, propertyLong BIGINT, propertyLongObject BIGINT, propertyShort SMALLINT, propertyShortObject SMALLINT, propertySqlDate DATE, propertyString VARCHAR(32672), propertyTimestamp TIMESTAMP, CHECK (propertyEnum IS NULL OR propertyEnum IN ('VALUE_ONE','VALUE_TWO','VALUE_THREE')))");
		execute(query);
	}

	public void testColumnsBeanFilteredDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.columnsFiltered(BeanImpl.class, new String[] {"propertyBigDecimal", "propertyByte", "propertyFloat", "propertyStringbuffer", "propertyTime"}, new String[] {"propertyByte","propertyStringbuffer"});
		assertEquals(query.getSql(), "CREATE TABLE tablename (propertyBigDecimal NUMERIC, propertyFloat FLOAT, propertyTime TIME)");
		execute(query);
	}

	public void testColumnsBeanPrecisionDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.columns(BeanImpl.class)
			.precision("propertyBigDecimal", 19, 9)
			.precision("propertyBoolean", 4)
			.precision("propertyBooleanObject", 7)
			.precision("propertyByte", 8)
			.precision("propertyByteObject", 9)
			.precision("propertyCalendar", 20)
			.precision("propertyChar", 10)
			.precision("propertyCharacterObject", 12)
			.precision("propertyDate", 7)
			.precision("propertyDouble", 12, 3)
			.precision("propertyDoubleObject", 14, 4)
			.precision("propertyFloat", 13, 2)
			.precision("propertyFloatObject", 12, 1)
			.precision("propertyInt", 10)
			.precision("propertyIntegerObject", 8)
			.precision("propertyLong", 12)
			.precision("propertyLongObject", 11)
			.precision("propertyShort", 9)
			.precision("propertyShortObject", 6)
			.precision("propertySqlDate", 8)
			.precision("propertyString", 255)
			.precision("propertyStringbuffer", 100)
			.precision("propertyTime", 9)
			.precision("propertyTimestamp", 30, 2)
			.precision("propertyEnum", 12);
		assertEquals(query.getSql(), "CREATE TABLE tablename (propertyBigDecimal NUMERIC(19,9), propertyBoolean NUMERIC(1), propertyBooleanObject NUMERIC(1), propertyByte SMALLINT, propertyByteObject SMALLINT, propertyCalendar TIMESTAMP, propertyChar CHAR(10), propertyCharacterObject CHAR(12), propertyDate TIMESTAMP, propertyDouble FLOAT, propertyDoubleObject FLOAT, propertyEnum VARCHAR(255), propertyFloat FLOAT, propertyFloatObject FLOAT, propertyInt INTEGER, propertyIntegerObject INTEGER, propertyLong BIGINT, propertyLongObject BIGINT, propertyShort SMALLINT, propertyShortObject SMALLINT, propertySqlDate DATE, propertyString VARCHAR(255), propertyStringbuffer VARCHAR(100), propertyTime TIME, propertyTimestamp TIMESTAMP, CHECK (propertyEnum IS NULL OR propertyEnum IN ('VALUE_ONE','VALUE_TWO','VALUE_THREE')))");
		execute(query);
	}

	public void testColumnsBeanConstrainedDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.columns(BeanImplConstrained.class);
		assertEquals(query.getSql(), "CREATE TABLE tablename (propertyBigDecimal NUMERIC(17,6), propertyBoolean NUMERIC(1), propertyBooleanObject NUMERIC(1), propertyByte SMALLINT, propertyByteObject SMALLINT NOT NULL, propertyCalendar TIMESTAMP, propertyChar CHAR, propertyCharacterObject CHAR, propertyDate TIMESTAMP, propertyDouble FLOAT, propertyDoubleObject FLOAT, propertyFloat FLOAT, propertyFloatObject FLOAT, propertyInt INTEGER DEFAULT 23, propertyIntegerObject INTEGER, propertyLongObject BIGINT, propertyShort SMALLINT, propertySqlDate DATE, propertyString VARCHAR(30) DEFAULT 'one' NOT NULL, propertyStringbuffer VARCHAR(20) NOT NULL, propertyTime TIME, propertyTimestamp TIMESTAMP, PRIMARY KEY (propertyString), UNIQUE (propertyStringbuffer, propertyByteObject), UNIQUE (propertyStringbuffer), CHECK (propertyByteObject != -1), CHECK (propertyInt != 0), CHECK (propertyLongObject IS NULL OR propertyLongObject IN (89,1221,66875,878)), CHECK (propertyString IS NULL OR propertyString IN ('one','tw''''o','someotherstring')), CHECK (propertyStringbuffer != ''), CHECK (propertyStringbuffer != 'some''blurp'))");
		execute(query);
	}

	public void testNullableDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn1", int.class, CreateTable.NULL)
			.column("stringColumn", String.class, 12, CreateTable.NOTNULL)
			.column("intColumn2", int.class)
			.column("intColumn3", int.class)
			.column("floatColumn", float.class, 13, 6, CreateTable.NOTNULL)
			.nullable("intColumn2", CreateTable.NULL)
			.nullable("intColumn3", CreateTable.NOTNULL)
			.nullable("floatColumn", null);
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn1 INTEGER , stringColumn VARCHAR(12) NOT NULL, intColumn2 INTEGER , intColumn3 INTEGER NOT NULL, floatColumn FLOAT)");
		execute(query);
	}

	public void testDefaultDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename1")
			.column("string", String.class, 255)
			.column("stringbuffer", StringBuffer.class, 100)
			.column("characterobject", Character.class, 22)
			.column("booleanobject", Boolean.class, 7)
			.column("byteobject", Byte.class, 9)
			.column("doubleobject", Double.class, 30, 2)
			.column("floatobject", Float.class, 20, 2)
			.column("integerobject", Integer.class, 10)
			.column("longobject", Long.class, 8)
			.column("shortobject", Short.class, 8)
			.column("bigdecimal", BigDecimal.class, 19, 9)
			.column("charcolumn", char.class, 10)
			.column("booleancolumn", boolean.class, 4)
			.column("bytecolumn", byte.class, 8)
			.column("doublecolumn", double.class, 12, 3)
			.column("floatcolumn", float.class, 13, 2)
			.column("intcolumn", int.class, 10)
			.column("longcolumn", long.class, 12)
			.column("shortcolumn", short.class, 9)
			.defaultValue("string", "stringDefault")
			.defaultValue("stringbuffer", "stringbufferDefault")
			.defaultValue("characterobject", "characterobjectDefault")
			.defaultValue("booleanobject", new Boolean(true))
			.defaultValue("byteobject", new Byte((byte)34))
			.defaultValue("doubleobject", new Double(234.87d))
			.defaultValue("floatobject", new Float(834.43f))
			.defaultValue("integerobject", new Integer(463))
			.defaultValue("longobject", new Long(34876L))
			.defaultValue("shortobject", new Short((short)98))
			.defaultValue("bigdecimal", new BigDecimal("347.14"))
			.defaultValue("charcolumn", "OSJFDZ")
			.defaultValue("booleancolumn", false)
			.defaultValue("bytecolumn", (byte)27)
			.defaultValue("doublecolumn", 934.5d)
			.defaultValue("floatcolumn", 35.87f)
			.defaultValue("intcolumn", 983734)
			.defaultValue("longcolumn", 2343345L)
			.defaultValue("shortcolumn", 12);
		assertEquals(query.getSql(), "CREATE TABLE tablename1 (string VARCHAR(255) DEFAULT 'stringDefault', stringbuffer VARCHAR(100) DEFAULT 'stringbufferDefault', characterobject CHAR(22) DEFAULT 'characterobjectDefault', booleanobject NUMERIC(1) DEFAULT 1, byteobject SMALLINT DEFAULT 34, doubleobject FLOAT DEFAULT 234.87, floatobject FLOAT DEFAULT 834.43, integerobject INTEGER DEFAULT 463, longobject BIGINT DEFAULT 34876, shortobject SMALLINT DEFAULT 98, bigdecimal NUMERIC(19,9) DEFAULT 347.14, charcolumn CHAR(10) DEFAULT 'OSJFDZ', booleancolumn NUMERIC(1) DEFAULT 0, bytecolumn SMALLINT DEFAULT 27, doublecolumn FLOAT DEFAULT 934.5, floatcolumn FLOAT DEFAULT 35.87, intcolumn INTEGER DEFAULT 983734, longcolumn BIGINT DEFAULT 2343345, shortcolumn SMALLINT DEFAULT 12)");
		execute(query);
	}

	public void testDefaultFunctionDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename1")
			.column("dateobject", java.sql.Date.class)
			.defaultFunction("dateobject", "CURRENT_DATE");
		assertEquals(query.getSql(), "CREATE TABLE tablename1 (dateobject DATE DEFAULT CURRENT_DATE)");
		execute(query);
	}

	public void testCustomAttributeDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename1")
			.column("intColumn", Integer.class)
			.customAttribute("intColumn", "CHECK (intColumn > 0)");
		assertEquals(query.getSql(), "CREATE TABLE tablename1 (intColumn INTEGER CHECK (intColumn > 0))");
		execute(query);
	}

	public void testTemporaryDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.temporary(true)
			.column("boolColumn", boolean.class);
		try
		{
			query.getSql();
			fail();
		}
		catch (UnsupportedSqlFeatureException e)
		{
			assertTrue(true);
		}
	}

	public void testPrimaryKeySimpleDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.primaryKey("intColumn");
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER NOT NULL, PRIMARY KEY (intColumn))");
		execute(query);
	}

	public void testPrimaryKeyMultipleDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.column("stringColumn", String.class, 50)
			.primaryKey(new String[] {"intColumn", "stringColumn"});
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER NOT NULL, stringColumn VARCHAR(50) NOT NULL, PRIMARY KEY (intColumn, stringColumn))");
		execute(query);
	}

	public void testPrimaryKeyNamedDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.primaryKey("constraint_name", "intColumn");
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER NOT NULL, CONSTRAINT constraint_name PRIMARY KEY (intColumn))");
		execute(query);
	}

	public void testPrimaryKeyMultipleNamedDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.column("stringColumn", String.class, 50)
			.primaryKey("constraint_name", new String[] {"intColumn", "stringColumn"});
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER NOT NULL, stringColumn VARCHAR(50) NOT NULL, CONSTRAINT constraint_name PRIMARY KEY (intColumn, stringColumn))");
		execute(query);
	}

	public void testUniqueSimpleDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class, CreateTable.NOTNULL)
			.unique("intColumn");
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER NOT NULL, UNIQUE (intColumn))");
		execute(query);
	}

	public void testUniqueMultipleDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class, CreateTable.NOTNULL)
			.column("stringColumn", String.class, 50, CreateTable.NOTNULL)
			.unique(new String[] {"intColumn", "stringColumn"});
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER NOT NULL, stringColumn VARCHAR(50) NOT NULL, UNIQUE (intColumn, stringColumn))");
		execute(query);
	}

	public void testUniqueNamedDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class, CreateTable.NOTNULL)
			.unique("constraint_name", "intColumn");
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER NOT NULL, CONSTRAINT constraint_name UNIQUE (intColumn))");
		execute(query);
	}

	public void testUniqueMultipleNamedDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class, CreateTable.NOTNULL)
			.column("stringColumn", String.class, 50, CreateTable.NOTNULL)
			.unique("constraint_name", new String[] {"intColumn", "stringColumn"});
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER NOT NULL, stringColumn VARCHAR(50) NOT NULL, CONSTRAINT constraint_name UNIQUE (intColumn, stringColumn))");
		execute(query);
	}

	public void testForeignKeySimpleDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn");
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, FOREIGN KEY (intColumn) REFERENCES foreigntable (foreignIntColumn))");
		execute(query);
	}

	public void testForeignKeyMultipleDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.column("stringColumn", String.class, 50)
			.foreignKey("foreigntable", new String[] {"intColumn", "foreignIntColumn", "stringColumn", "foreignStringColumn"});
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, stringColumn VARCHAR(50), FOREIGN KEY (intColumn, stringColumn) REFERENCES foreigntable (foreignIntColumn, foreignStringColumn))");
		execute(query);
	}

	public void testForeignKeySimpleNamedDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("constraint_name", "foreigntable", "intColumn", "foreignIntColumn");
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, CONSTRAINT constraint_name FOREIGN KEY (intColumn) REFERENCES foreigntable (foreignIntColumn))");
		execute(query);
	}

	public void testForeignKeyMultipleNamedDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.column("stringColumn", String.class, 50)
			.foreignKey("constraint_name", "foreigntable", new String[] {"intColumn", "foreignIntColumn", "stringColumn", "foreignStringColumn"});
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, stringColumn VARCHAR(50), CONSTRAINT constraint_name FOREIGN KEY (intColumn, stringColumn) REFERENCES foreigntable (foreignIntColumn, foreignStringColumn))");
		execute(query);
	}

	public void testForeignKeyViolationsSingleDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn", CreateTable.CASCADE, null);
		try
		{
			query.getSql();
			fail();
		}
		catch (UnsupportedSqlFeatureException e)
		{
			assertTrue(true);
		}
		query.clear();

		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn", CreateTable.NOACTION, null);
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, FOREIGN KEY (intColumn) REFERENCES foreigntable (foreignIntColumn) ON UPDATE NO ACTION)");
		execute(query);
		query.clear();

		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn", CreateTable.RESTRICT, null);
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, FOREIGN KEY (intColumn) REFERENCES foreigntable (foreignIntColumn) ON UPDATE RESTRICT)");
		execute(query);
		query.clear();

		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn", CreateTable.SETDEFAULT, null);
		try
		{
			query.getSql();
			fail();
		}
		catch (UnsupportedSqlFeatureException e)
		{
			assertTrue(true);
		}
		query.clear();

		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn", CreateTable.SETNULL, null);
		try
		{
			query.getSql();
			fail();
		}
		catch (UnsupportedSqlFeatureException e)
		{
			assertTrue(true);
		}
		query.clear();

		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn", null, CreateTable.CASCADE);
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, FOREIGN KEY (intColumn) REFERENCES foreigntable (foreignIntColumn) ON DELETE CASCADE)");
		execute(query);
		query.clear();

		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn", null, CreateTable.NOACTION);
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, FOREIGN KEY (intColumn) REFERENCES foreigntable (foreignIntColumn) ON DELETE NO ACTION)");
		execute(query);
		query.clear();

		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn", null, CreateTable.RESTRICT);
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, FOREIGN KEY (intColumn) REFERENCES foreigntable (foreignIntColumn) ON DELETE RESTRICT)");
		execute(query);
		query.clear();

		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn", null, CreateTable.SETDEFAULT);
		try
		{
			query.getSql();
			fail();
		}
		catch (UnsupportedSqlFeatureException e)
		{
			assertTrue(true);
		}
		query.clear();

		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn", null, CreateTable.SETNULL);
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, FOREIGN KEY (intColumn) REFERENCES foreigntable (foreignIntColumn) ON DELETE SET NULL)");
		execute(query);
		query.clear();
	}

	public void testForeignKeyViolationsDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.foreignKey("foreigntable", "intColumn", "foreignIntColumn", CreateTable.RESTRICT, CreateTable.NOACTION);
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, FOREIGN KEY (intColumn) REFERENCES foreigntable (foreignIntColumn) ON UPDATE RESTRICT ON DELETE NO ACTION)");
		execute(query);
	}

	public void testForeignKeyMultipleViolationsDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.column("stringColumn", String.class, 50)
			.foreignKey("foreigntable", new String[] {"intColumn", "foreignIntColumn", "stringColumn", "foreignStringColumn"}, CreateTable.RESTRICT, CreateTable.CASCADE);
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, stringColumn VARCHAR(50), FOREIGN KEY (intColumn, stringColumn) REFERENCES foreigntable (foreignIntColumn, foreignStringColumn) ON UPDATE RESTRICT ON DELETE CASCADE)");
		execute(query);
	}

	public void testCheckSimpleDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.check("intColumn > 0");
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, CHECK (intColumn > 0))");
		execute(query);
	}

	public void testCheckNamedDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.column("intColumn", int.class)
			.check("NAME_CK", "intColumn > 0");
		assertEquals(query.getSql(), "CREATE TABLE tablename (intColumn INTEGER, CONSTRAINT NAME_CK CHECK (intColumn > 0))");
		execute(query);
	}

	public void testCloneDerby()
	{
		CreateTable query = new CreateTable(mDerby);
		query.table("tablename")
			.columns(BeanImpl.class)
			.precision("propertyBigDecimal", 19, 9)
			.precision("propertyBoolean", 4)
			.precision("propertyByte", 8)
			.precision("propertyCalendar", 20)
			.precision("propertyChar", 10)
			.precision("propertyDate", 7)
			.precision("propertyDouble", 12, 3)
			.precision("propertyFloat", 13, 2)
			.precision("propertyInt", 10)
			.precision("propertyLong", 12)
			.precision("propertyShort", 9)
			.precision("propertySqlDate", 8)
			.precision("propertyString", 255)
			.precision("propertyStringbuffer", 100)
			.precision("propertyTime", 9)
			.precision("propertyTimestamp", 30, 2)
			.nullable("propertyString", CreateTable.NULL)
			.nullable("propertyLong", CreateTable.NOTNULL)
			.defaultValue("propertyString", "stringDefault")
			.defaultFunction("propertyDate", "CURRENT_TIMESTAMP")
			.customAttribute("propertyInt", "CHECK (propertyInt > 0)")
//			.temporary(true)
			.primaryKey("constraint_name1", new String[] {"propertyInt", "propertyString"})
			.unique("constraint_name2", new String[] {"propertyLong", "propertyString"})
			.foreignKey("foreigntable", new String[] {"propertyInt", "foreignIntColumn"}, CreateTable.RESTRICT, CreateTable.CASCADE)
			.check("NAME_CK", "propertyInt > 0");
		CreateTable query_clone = query.clone();
		assertEquals(query.getSql(), query_clone.getSql());
		assertTrue(query != query_clone);
		execute(query_clone);
	}
}
