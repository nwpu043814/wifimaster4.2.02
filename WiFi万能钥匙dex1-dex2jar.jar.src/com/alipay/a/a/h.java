package com.alipay.a.a;

import a.a.a.c;
import com.alipay.a.b.a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class h
  implements i, j
{
  private static Map a(Type paramType)
  {
    if (paramType == Properties.class) {
      paramType = new Properties();
    }
    for (;;)
    {
      return paramType;
      if (paramType == Hashtable.class)
      {
        paramType = new Hashtable();
        continue;
      }
      if (paramType == IdentityHashMap.class)
      {
        paramType = new IdentityHashMap();
        continue;
      }
      if ((paramType == SortedMap.class) || (paramType == TreeMap.class))
      {
        paramType = new TreeMap();
        continue;
      }
      if ((paramType == ConcurrentMap.class) || (paramType == ConcurrentHashMap.class))
      {
        paramType = new ConcurrentHashMap();
        continue;
      }
      if ((paramType == Map.class) || (paramType == HashMap.class))
      {
        paramType = new HashMap();
        continue;
      }
      if (paramType == LinkedHashMap.class)
      {
        paramType = new LinkedHashMap();
        continue;
      }
      if ((paramType instanceof ParameterizedType))
      {
        paramType = ((ParameterizedType)paramType).getRawType();
        break;
      }
      Object localObject = (Class)paramType;
      if (((Class)localObject).isInterface()) {
        throw new IllegalArgumentException("unsupport type " + paramType);
      }
      try
      {
        localObject = (Map)((Class)localObject).newInstance();
        paramType = (Type)localObject;
      }
      catch (Exception localException)
      {
        throw new IllegalArgumentException("unsupport type " + paramType, localException);
      }
    }
  }
  
  public final Object a(Object paramObject)
  {
    TreeMap localTreeMap = new TreeMap();
    paramObject = ((Map)paramObject).entrySet().iterator();
    while (((Iterator)paramObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
      if (!(localEntry.getKey() instanceof String)) {
        throw new IllegalArgumentException("Map key must be String!");
      }
      localTreeMap.put((String)localEntry.getKey(), f.b(localEntry.getValue()));
    }
    return localTreeMap;
  }
  
  public final Object a(Object paramObject, Type paramType)
  {
    if (!paramObject.getClass().equals(c.class)) {
      paramObject = null;
    }
    for (;;)
    {
      return paramObject;
      c localc = (c)paramObject;
      paramObject = a(paramType);
      if ((paramType instanceof ParameterizedType))
      {
        paramType = (ParameterizedType)paramType;
        Object localObject = paramType.getActualTypeArguments()[0];
        paramType = paramType.getActualTypeArguments()[1];
        if (String.class == localObject)
        {
          Iterator localIterator = localc.a();
          while (localIterator.hasNext())
          {
            localObject = (String)localIterator.next();
            if (a.a((Class)paramType)) {
              ((Map)paramObject).put(localObject, localc.a((String)localObject));
            } else {
              ((Map)paramObject).put(localObject, e.a(localc.a((String)localObject), paramType));
            }
          }
        }
        throw new IllegalArgumentException("Deserialize Map Key must be String.class");
      }
      throw new IllegalArgumentException("Deserialize Map must be Generics!");
    }
  }
  
  public final boolean a(Class paramClass)
  {
    return Map.class.isAssignableFrom(paramClass);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */