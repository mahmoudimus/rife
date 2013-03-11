/*B 'QUERY'*/CREATE/*V 'TEMPORARY'*//*-V*/ TABLE /*V 'TABLE'-*/ (/*V 'COLUMNS'-*//*V 'PRIMARY_KEYS'*//*-V*//*V 'FOREIGN_KEYS'*//*-V*//*V 'UNIQUE_CONSTRAINTS'*//*-V*//*V 'CHECKS'*//*-V*/)/*-B*/
/*B 'SEPERATOR'*/, /*-B*/
/*B 'TEMPORARY'*//*-B*/
/*B 'COLUMN'*//*V 'NAME'-*/ /*V 'TYPE'-*//*V 'DEFAULT'*//*-V*//*V 'NULLABLE'*//*-V*//*V 'CUSTOM_ATTRIBUTES'*//*-V*//*-B*/
/*B 'NULL'*/ /*-B*/
/*B 'NOTNULL'*/ NOT NULL/*-B*/
/*B 'DEFAULT'*/ DEFAULT /*V 'V'-*//*-B*/
/*B 'CUSTOM_ATTRIBUTES'*/ /*V 'V'-*//*-B*/
/*B 'PRIMARY_KEY'*//*V 'PRIMARY_KEY_NAME'*//*-V*/PRIMARY KEY (/*V 'COLUMN_NAMES'-*/)/*-B*/
/*B 'FOREIGN_KEY'*//*V 'FOREIGN_KEY_NAME'*//*-V*/FOREIGN KEY (/*V 'LOCAL_COLUMN_NAMES'-*/) REFERENCES /*V 'FOREIGN_TABLE'-*/ (/*V 'FOREIGN_COLUMN_NAMES'-*/)/*V 'VIOLATION_ACTIONS'*//*-V*//*B 'ON_DELETE'*/ ON DELETE /*V 'ON_DELETE_ACTION'-*//*-B*//*B 'ON_UPDATE'*/ ON UPDATE /*V 'ON_UPDATE_ACTION'-*//*-B*//*-B*/
/*B 'UNIQUE_CONSTRAINT'*//*V 'UNIQUE_CONSTRAINT_NAME'*//*-V*/UNIQUE (/*V 'COLUMN_NAMES'-*/)/*-B*/
/*B 'CHECK'*//*V 'CHECK_NAME'*//*-V*/CHECK (/*V 'EXPRESSION'-*/)/*-B*/
/*B 'PRIMARY_KEY_NAME'*/CONSTRAINT /*V 'NAME'-*/ /*-B*/
/*B 'FOREIGN_KEY_NAME'*/CONSTRAINT /*V 'NAME'-*/ /*-B*/
/*B 'UNIQUE_CONSTRAINT_NAME'*/CONSTRAINT /*V 'NAME'-*/ /*-B*/
/*B 'CHECK_NAME'*/CONSTRAINT /*V 'NAME'-*/ /*-B*/
/*B 'ON_UPDATE_NOACTION'*/NO ACTION/*-B*/
/*B 'ON_UPDATE_RESTRICT'*//*-B*/
/*B 'ON_UPDATE_CASCADE'*/CASCADE/*-B*/
/*B 'ON_UPDATE_SETNULL'*/SET NULL/*-B*/
/*B 'ON_UPDATE_SETDEFAULT'*/SET DEFAULT/*-B*/
/*B 'ON_DELETE_NOACTION'*/NO ACTION/*-B*/
/*B 'ON_DELETE_RESTRICT'*//*-B*/
/*B 'ON_DELETE_CASCADE'*/CASCADE/*-B*/
/*B 'ON_DELETE_SETNULL'*/SET NULL/*-B*/
/*B 'ON_DELETE_SETDEFAULT'*/SET DEFAULT/*-B*/
