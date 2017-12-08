package com.alipay.a.a;

import a.a.a.b;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements i, j
{
  public final Object a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    ArrayList localArrayList = new ArrayList();
    int j = paramObject.length;
    for (int i = 0; i < j; i++) {
      localArrayList.add(f.b(paramObject[i]));
    }
    return localArrayList;
  }
  
  public final Object a(Object paramObject, Type paramType)
  {
    if (!paramObject.getClass().equals(b.class))
    {
      paramObject = null;
      return paramObject;
    }
    b localb = (b)paramObject;
    if ((paramType instanceof GenericArrayType)) {
      throw new IllegalArgumentException("Does not support generic array!");
    }
    Class localClass = ((Class)paramType).getComponentType();
    int j = localb.a();
    paramType = Array.newInstance(localClass, j);
    for (int i = 0;; i++)
    {
      paramObject = paramType;
      if (i >= j) {
        break;
      }
      Array.set(paramType, i, e.a(localb.a(i), localClass));
    }
  }
  
  public final boolean a(Class paramClass)
  {
    return paramClass.isArray();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */