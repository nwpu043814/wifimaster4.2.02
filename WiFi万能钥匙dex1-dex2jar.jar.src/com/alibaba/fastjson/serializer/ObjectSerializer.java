package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public abstract interface ObjectSerializer
{
  public abstract void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ObjectSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */