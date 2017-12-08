package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

public class DateFormatSerializer
  implements ObjectSerializer
{
  public static final DateFormatSerializer instance = new DateFormatSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramObject2 = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      ((SerializeWriter)paramObject2).writeNull();
    }
    for (;;)
    {
      return;
      String str = ((SimpleDateFormat)paramObject1).toPattern();
      if ((((SerializeWriter)paramObject2).isEnabled(SerializerFeature.WriteClassName)) && (paramObject1.getClass() != paramType))
      {
        ((SerializeWriter)paramObject2).write('{');
        ((SerializeWriter)paramObject2).writeFieldName(JSON.DEFAULT_TYPE_KEY);
        paramJSONSerializer.write(paramObject1.getClass().getName());
        ((SerializeWriter)paramObject2).writeFieldValue(',', "val", str);
        ((SerializeWriter)paramObject2).write('}');
      }
      else
      {
        ((SerializeWriter)paramObject2).writeString(str);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/DateFormatSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */