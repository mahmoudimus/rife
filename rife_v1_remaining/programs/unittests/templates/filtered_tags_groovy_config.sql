This config value expression is true '/*V 'GROOVY:CONFIG:value1'-*/'.
This config value expression is false '[!V 'GROOVY:CONFIG:value2'/]'.
This config value expression is dynamic '[!V 'GROOVY:CONFIG:value3'/]'.
/*B 'GROOVY:CONFIG:value1:[[ config.getBool("EXPRESSION_CONFIG_VALUE_BOOL") ]]'*/true value/*-B*/
[!B 'GROOVY:CONFIG:value2:[[ config.getString("EXPRESSION_CONFIG_VALUE") != "the value" ]]']false value[!/B]
/*B 'GROOVY:CONFIG:value3:[[ config.getString("EXPRESSION_CONFIG_VALUE") == thevalue ]]'*/dynamic value/*-B*/
