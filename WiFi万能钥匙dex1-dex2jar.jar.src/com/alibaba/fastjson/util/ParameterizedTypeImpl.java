package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ParameterizedTypeImpl
  implements ParameterizedType
{
  private final Type[] actualTypeArguments;
  private final Type ownerType;
  private final Type rawType;
  
  public ParameterizedTypeImpl(Type[] paramArrayOfType, Type paramType1, Type paramType2)
  {
    this.actualTypeArguments = paramArrayOfType;
    this.ownerType = paramType1;
    this.rawType = paramType2;
  }
  
  public Type[] getActualTypeArguments()
  {
    return this.actualTypeArguments;
  }
  
  public Type getOwnerType()
  {
    return this.ownerType;
  }
  
  public Type getRawType()
  {
    return this.rawType;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/ParameterizedTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */