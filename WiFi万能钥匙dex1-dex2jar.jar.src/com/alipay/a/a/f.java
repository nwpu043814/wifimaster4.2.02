package com.alipay.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f
{
  private static List a;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add(new l());
    a.add(new d());
    a.add(new c());
    a.add(new h());
    a.add(new b());
    a.add(new a());
    a.add(new g());
  }
  
  public static String a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return (String)paramObject;
      paramObject = b(paramObject);
      if (com.alipay.a.b.a.a(paramObject.getClass()))
      {
        paramObject = a.a.a.c.c(paramObject.toString());
      }
      else if (Collection.class.isAssignableFrom(paramObject.getClass()))
      {
        paramObject = new a.a.a.b((List)paramObject).toString();
      }
      else
      {
        if (!Map.class.isAssignableFrom(paramObject.getClass())) {
          break;
        }
        paramObject = new a.a.a.c((Map)paramObject).toString();
      }
    }
    throw new IllegalArgumentException("Unsupported Class : " + paramObject.getClass());
  }
  
  public static Object b(Object paramObject)
  {
    if (paramObject == null) {}
    Object localObject;
    for (paramObject = null;; paramObject = localObject)
    {
      return paramObject;
      Iterator localIterator = a.iterator();
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (j)localIterator.next();
        } while (!((j)localObject).a(paramObject.getClass()));
        localObject = ((j)localObject).a(paramObject);
      } while (localObject == null);
    }
    throw new IllegalArgumentException("Unsupported Class : " + paramObject.getClass());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */