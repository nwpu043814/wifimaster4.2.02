package com.lantern.webox.c;

import com.b.a.ab;
import com.b.a.ac;
import com.b.a.af;
import com.b.a.ag;
import com.b.a.n;
import com.b.a.o;
import com.b.a.s;
import com.b.a.z;
import com.bluefay.b.h;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private static n a = new o().a();
  private static af b = new af();
  
  private static Object a(z paramz)
  {
    if ((paramz instanceof ag))
    {
      paramz = paramz.q();
      if (paramz.a()) {
        paramz = Boolean.valueOf(paramz.m());
      }
    }
    for (;;)
    {
      return paramz;
      if (paramz.r())
      {
        paramz = paramz.b();
      }
      else if (paramz.s())
      {
        paramz = paramz.c();
      }
      else
      {
        paramz = paramz.toString();
        continue;
        if ((paramz instanceof ab))
        {
          paramz = null;
        }
        else
        {
          Object localObject;
          if ((paramz instanceof s))
          {
            localObject = new LinkedList();
            paramz = paramz.p();
            for (int i = 0; i < paramz.a(); i++) {
              ((List)localObject).add(a(paramz.a(i)));
            }
            paramz = (z)localObject;
          }
          else if ((paramz instanceof ac))
          {
            localObject = paramz.o();
            paramz = new HashMap();
            localObject = ((ac)localObject).a().iterator();
            while (((Iterator)localObject).hasNext())
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
              paramz.put(localEntry.getKey(), a((z)localEntry.getValue()));
            }
          }
          else
          {
            paramz = paramz.toString();
          }
        }
      }
    }
  }
  
  public static <T> T a(String paramString, Type paramType)
  {
    return (T)a.a(paramString, paramType);
  }
  
  public static String a(Object paramObject)
  {
    return a.a(paramObject);
  }
  
  public static Map<String, Object> a(String paramString)
  {
    try
    {
      paramString = (Map)a(af.a(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
        paramString = null;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */