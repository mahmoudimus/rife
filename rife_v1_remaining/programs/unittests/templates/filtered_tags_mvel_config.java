//This config value expression is true '/*V 'MVEL:CONFIG:value1'-*/'.
//This config value expression is false '[!V 'MVEL:CONFIG:value2'/]'.
//This config value expression is dynamic '[!V 'MVEL:CONFIG:value3'/]'.
///*B 'MVEL:CONFIG:value1:[[ getBool("EXPRESSION_CONFIG_VALUE_BOOL") ]]'*/true value/*-B*/
//[!B 'MVEL:CONFIG:value2:[[ getString("EXPRESSION_CONFIG_VALUE") != "the value" ]]']false value[!/B]
///*B 'MVEL:CONFIG:value3:[[ getString("EXPRESSION_CONFIG_VALUE") == thevalue ]]'*/dynamic value/*-B*/
