package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class ByteSerializer
  implements ObjectSerializer
{
  public static ByteSerializer instance = new ByteSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramObject2 = paramJSONSerializer.getWriter();
    if ((Number)paramObject1 == null) {
      if (((SerializeWriter)paramObject2).isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        ((SerializeWriter)paramObject2).write('0');
      }
    }
    for (;;)
    {
      return;
      ((SerializeWriter)paramObject2).writeNull();
      continue;
      ((SerializeWriter)paramObject2).writeInt(((Number)paramObject1).shortValue());
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName)) {
        ((SerializeWriter)paramObject2).write('B');
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ByteSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */