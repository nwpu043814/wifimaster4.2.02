package com.alipay.a.a;

import a.a.a.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class k
  implements i
{
  public final Object a(Object paramObject, Type paramType)
  {
    int i = 0;
    if (!paramObject.getClass().equals(b.class)) {}
    HashSet localHashSet;
    for (paramObject = null;; paramObject = localHashSet)
    {
      return paramObject;
      b localb = (b)paramObject;
      localHashSet = new HashSet();
      if ((paramType instanceof ParameterizedType)) {
        paramObject = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      }
      while (i < localb.a())
      {
        localHashSet.add(e.a(localb.a(i), (Type)paramObject));
        i++;
        continue;
        paramObject = Object.class;
      }
    }
  }
  
  public final boolean a(Class paramClass)
  {
    return Set.class.isAssignableFrom(paramClass);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */