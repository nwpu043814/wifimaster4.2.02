package com.alipay.a.a;

import java.lang.reflect.Type;

public final class d
  implements i, j
{
  public final Object a(Object paramObject)
  {
    return ((Enum)paramObject).name();
  }
  
  public final Object a(Object paramObject, Type paramType)
  {
    return Enum.valueOf((Class)paramType, paramObject.toString());
  }
  
  public final boolean a(Class paramClass)
  {
    return Enum.class.isAssignableFrom(paramClass);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */