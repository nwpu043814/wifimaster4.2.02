package com.wifipay.common.eventbus;

import com.wifipay.common.eventbus.a.a;
import com.wifipay.common.eventbus.a.b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class n
{
  private static final Map a = new ConcurrentHashMap();
  private static final o[] e = new o[4];
  private List b;
  private final boolean c;
  private final boolean d;
  
  n(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramList;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  private List a(o paramo)
  {
    ArrayList localArrayList = new ArrayList(paramo.a);
    paramo.a();
    o[] arrayOfo = e;
    int i = 0;
    for (;;)
    {
      if (i < 4) {}
      try
      {
        if (e[i] == null)
        {
          e[i] = paramo;
          return localArrayList;
        }
        i++;
      }
      finally {}
    }
  }
  
  static void a()
  {
    a.clear();
  }
  
  private a b(o paramo)
  {
    a locala;
    if ((paramo.h != null) && (paramo.h.c() != null))
    {
      locala = paramo.h.c();
      if (paramo.f == locala.a()) {
        paramo = locala;
      }
    }
    for (;;)
    {
      return paramo;
      if (this.b != null)
      {
        Iterator localIterator = this.b.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            locala = ((b)localIterator.next()).a(paramo.f);
            if (locala != null)
            {
              paramo = locala;
              break;
            }
          }
        }
      }
      paramo = null;
    }
  }
  
  private o b()
  {
    arrayOfo = e;
    int i = 0;
    if (i < 4) {}
    for (;;)
    {
      try
      {
        localo = e[i];
        if (localo != null)
        {
          e[i] = null;
          return localo;
        }
        i++;
        break;
      }
      finally {}
      o localo = new o();
    }
  }
  
  private List b(Class paramClass)
  {
    o localo = b();
    localo.a(paramClass);
    while (localo.f != null)
    {
      localo.h = b(localo);
      if (localo.h != null) {
        for (Object localObject : localo.h.b()) {
          if (localo.a(((m)localObject).a, ((m)localObject).c)) {
            localo.a.add(localObject);
          }
        }
      }
      c(localo);
      localo.b();
    }
    return a(localo);
  }
  
  private List c(Class paramClass)
  {
    o localo = b();
    localo.a(paramClass);
    while (localo.f != null)
    {
      c(localo);
      localo.b();
    }
    return a(localo);
  }
  
  private void c(o paramo)
  {
    Method localMethod;
    label255:
    do
    {
      try
      {
        Method[] arrayOfMethod1 = paramo.f.getDeclaredMethods();
        int j = arrayOfMethod1.length;
        for (int i = 0;; i++)
        {
          if (i >= j) {
            return;
          }
          localMethod = arrayOfMethod1[i];
          int k = localMethod.getModifiers();
          if (((k & 0x1) == 0) || ((k & 0x1448) != 0)) {
            break label255;
          }
          localObject = localMethod.getParameterTypes();
          if (localObject.length != 1) {
            break;
          }
          Subscribe localSubscribe = (Subscribe)localMethod.getAnnotation(Subscribe.class);
          if (localSubscribe != null)
          {
            localObject = localObject[0];
            if (paramo.a(localMethod, (Class)localObject))
            {
              ThreadMode localThreadMode = localSubscribe.threadMode();
              paramo.a.add(new m(localMethod, (Class)localObject, localThreadMode, localSubscribe.priority(), localSubscribe.sticky()));
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        do
        {
          for (;;)
          {
            Method[] arrayOfMethod2 = paramo.f.getMethods();
            paramo.g = true;
          }
        } while ((!this.c) || (!localMethod.isAnnotationPresent(Subscribe.class)));
        paramo = localMethod.getDeclaringClass().getName() + "." + localMethod.getName();
        throw new g("@Subscribe method " + paramo + "must have exactly 1 parameter but has " + localObject.length);
      }
    } while ((!this.c) || (!localMethod.isAnnotationPresent(Subscribe.class)));
    paramo = localMethod.getDeclaringClass().getName() + "." + localMethod.getName();
    throw new g(paramo + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
  }
  
  List a(Class paramClass)
  {
    List localList = (List)a.get(paramClass);
    if (localList != null) {}
    for (;;)
    {
      return localList;
      if (this.d) {}
      for (localList = c(paramClass); localList.isEmpty(); localList = b(paramClass)) {
        throw new g("Subscriber " + paramClass + " and its super classes have no public methods with the @Subscribe annotation");
      }
      a.put(paramClass, localList);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/eventbus/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */