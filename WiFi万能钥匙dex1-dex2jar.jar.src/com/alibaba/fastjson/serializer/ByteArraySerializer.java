package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class ByteArraySerializer
  implements ObjectSerializer
{
  public static ByteArraySerializer instance = new ByteArraySerializer();
  
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
      paramJSONSerializer.writeByteArray((byte[])paramObject1);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ByteArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */