package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanSerializer
  implements ObjectSerializer
{
  public static final AtomicBooleanSerializer instance = new AtomicBooleanSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer = paramJSONSerializer.getWriter();
    if (((AtomicBoolean)paramObject1).get()) {
      paramJSONSerializer.append("true");
    }
    for (;;)
    {
      return;
      paramJSONSerializer.append("false");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/AtomicBooleanSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */