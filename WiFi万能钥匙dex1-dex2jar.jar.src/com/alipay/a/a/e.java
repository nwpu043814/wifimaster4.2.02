package com.alipay.a.a;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  static List a;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add(new l());
    a.add(new d());
    a.add(new c());
    a.add(new h());
    a.add(new k());
    a.add(new b());
    a.add(new a());
    a.add(new g());
  }
  
  public static final Object a(Object paramObject, Type paramType)
  {
    Iterator localIterator = a.iterator();
    Object localObject;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (i)localIterator.next();
      } while (!((i)localObject).a(com.alipay.a.b.a.a(paramType)));
      localObject = ((i)localObject).a(paramObject, paramType);
    } while (localObject == null);
    for (paramObject = localObject;; paramObject = null) {
      return paramObject;
    }
  }
  
  public static final Object a(String paramString, Type paramType)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      paramString = paramString.trim();
      if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {
        paramString = a(new a.a.a.b(paramString), paramType);
      } else if ((paramString.startsWith("{")) && (paramString.endsWith("}"))) {
        paramString = a(new a.a.a.c(paramString), paramType);
      } else {
        paramString = a(paramString, paramType);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */