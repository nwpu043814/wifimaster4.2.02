package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class AppendableSerializer
  implements ObjectSerializer
{
  public static final AppendableSerializer instance = new AppendableSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null)
    {
      paramJSONSerializer = paramJSONSerializer.getWriter();
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
        paramJSONSerializer.writeString("");
      }
    }
    for (;;)
    {
      return;
      paramJSONSerializer.writeNull();
      continue;
      paramJSONSerializer.write(paramObject1.toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/AppendableSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */