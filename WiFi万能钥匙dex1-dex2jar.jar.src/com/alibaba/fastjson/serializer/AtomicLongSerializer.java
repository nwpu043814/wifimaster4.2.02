package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongSerializer
  implements ObjectSerializer
{
  public static final AtomicLongSerializer instance = new AtomicLongSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer.getWriter().writeLong(((AtomicLong)paramObject1).get());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/AtomicLongSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */