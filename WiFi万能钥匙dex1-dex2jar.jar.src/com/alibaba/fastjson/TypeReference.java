package com.alibaba.fastjson;

import java.lang.reflect.Type;

public class TypeReference<T>
{
  public static final Type LIST_STRING = new TypeReference.1().getType();
  private final Type type = ((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  
  public Type getType()
  {
    return this.type;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/TypeReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */