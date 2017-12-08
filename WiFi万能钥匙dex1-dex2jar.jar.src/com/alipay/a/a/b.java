package com.alipay.a.a;

import com.alipay.a.b.a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public final class b
  implements i, j
{
  private static Collection a(Class paramClass, Type paramType)
  {
    if (paramClass == AbstractCollection.class) {
      paramClass = new ArrayList();
    }
    for (;;)
    {
      return paramClass;
      if (paramClass.isAssignableFrom(HashSet.class))
      {
        paramClass = new HashSet();
        continue;
      }
      if (paramClass.isAssignableFrom(LinkedHashSet.class))
      {
        paramClass = new LinkedHashSet();
        continue;
      }
      if (paramClass.isAssignableFrom(TreeSet.class))
      {
        paramClass = new TreeSet();
        continue;
      }
      if (paramClass.isAssignableFrom(ArrayList.class))
      {
        paramClass = new ArrayList();
        continue;
      }
      if (paramClass.isAssignableFrom(EnumSet.class))
      {
        if ((paramType instanceof ParameterizedType)) {}
        for (paramClass = ((ParameterizedType)paramType).getActualTypeArguments()[0];; paramClass = Object.class)
        {
          paramClass = EnumSet.noneOf((Class)paramClass);
          break;
        }
      }
      try
      {
        paramType = (Collection)paramClass.newInstance();
        paramClass = paramType;
      }
      catch (Exception paramType)
      {
        throw new IllegalArgumentException("create instane error, class " + paramClass.getName());
      }
    }
  }
  
  public final Object a(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    paramObject = ((Iterable)paramObject).iterator();
    while (((Iterator)paramObject).hasNext()) {
      localArrayList.add(f.b(((Iterator)paramObject).next()));
    }
    return localArrayList;
  }
  
  public final Object a(Object paramObject, Type paramType)
  {
    int i = 0;
    if (!paramObject.getClass().equals(a.a.a.b.class)) {
      paramObject = null;
    }
    for (;;)
    {
      return paramObject;
      Class localClass = a.a(paramType);
      a.a.a.b localb = (a.a.a.b)paramObject;
      paramObject = a(localClass, paramType);
      if ((paramType instanceof ParameterizedType))
      {
        paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
        while (i < localb.a())
        {
          ((Collection)paramObject).add(e.a(localb.a(i), paramType));
          i++;
        }
      }
      throw new IllegalArgumentException("Does not support the implement for generics.");
    }
  }
  
  public final boolean a(Class paramClass)
  {
    return Collection.class.isAssignableFrom(paramClass);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */