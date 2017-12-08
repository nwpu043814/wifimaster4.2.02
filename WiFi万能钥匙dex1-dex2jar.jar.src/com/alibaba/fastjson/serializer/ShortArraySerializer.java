package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class ShortArraySerializer
  implements ObjectSerializer
{
  public static ShortArraySerializer instance = new ShortArraySerializer();
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        paramJSONSerializer.write("[]");
      }
    }
    for (;;)
    {
      return;
      paramJSONSerializer.writeNull();
      continue;
      paramObject1 = (short[])paramObject1;
      paramJSONSerializer.write('[');
      for (int i = 0; i < paramObject1.length; i++)
      {
        if (i != 0) {
          paramJSONSerializer.write(',');
        }
        paramJSONSerializer.writeInt(paramObject1[i]);
      }
      paramJSONSerializer.write(']');
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ShortArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */