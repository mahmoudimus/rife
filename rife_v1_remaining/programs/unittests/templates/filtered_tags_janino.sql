This expression is true '/*V 'JANINO:value1'-*/'.
This expression is false '[!V 'JANINO:value2'/]'.
This expression is dynamic '[!V 'JANINO:value3'/]'.
/*B 'JANINO:value1:[[ true ]]'*/true value/*-B*/
[!B 'JANINO:value2:[[ false ]]']false value[!/B]
[!B 'JANINO:value3:[[ ((Boolean)context.get("thevalue")).booleanValue() ]]']dynamic value[!/B]
