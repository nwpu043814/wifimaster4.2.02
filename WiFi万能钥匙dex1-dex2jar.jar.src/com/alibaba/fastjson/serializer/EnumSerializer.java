package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class EnumSerializer
  implements ObjectSerializer
{
  public static final EnumSerializer instance = new EnumSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramObject2 = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      paramJSONSerializer.getWriter().writeNull();
    }
    for (;;)
    {
      return;
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteEnumUsingToString)) {
        paramJSONSerializer.write(((Enum)paramObject1).name());
      } else {
        ((SerializeWriter)paramObject2).writeInt(((Enum)paramObject1).ordinal());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/EnumSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */