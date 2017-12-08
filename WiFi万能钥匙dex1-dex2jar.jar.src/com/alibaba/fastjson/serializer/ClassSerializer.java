package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class ClassSerializer
  implements ObjectSerializer
{
  public static final ClassSerializer instance = new ClassSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer.getWriter().writeString(((Class)paramObject1).getName());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ClassSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */