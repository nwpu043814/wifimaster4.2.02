package com.wifipay.common.eventbus;

import com.wifipay.common.eventbus.a.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class o
{
  final List a = new ArrayList();
  final Map b = new HashMap();
  final Map c = new HashMap();
  final StringBuilder d = new StringBuilder(128);
  Class e;
  Class f;
  boolean g;
  a h;
  
  private boolean b(Method paramMethod, Class paramClass)
  {
    this.d.setLength(0);
    this.d.append(paramMethod.getName());
    this.d.append('>').append(paramClass.getName());
    paramClass = this.d.toString();
    Class localClass = paramMethod.getDeclaringClass();
    paramMethod = (Class)this.c.put(paramClass, localClass);
    if ((paramMethod == null) || (paramMethod.isAssignableFrom(localClass))) {}
    for (boolean bool = true;; bool = false)
    {
      return bool;
      this.c.put(paramClass, paramMethod);
    }
  }
  
  void a()
  {
    this.a.clear();
    this.b.clear();
    this.c.clear();
    this.d.setLength(0);
    this.e = null;
    this.f = null;
    this.g = false;
    this.h = null;
  }
  
  void a(Class paramClass)
  {
    this.f = paramClass;
    this.e = paramClass;
    this.g = false;
    this.h = null;
  }
  
  boolean a(Method paramMethod, Class paramClass)
  {
    Object localObject = this.b.put(paramClass, paramMethod);
    if (localObject == null) {}
    for (boolean bool = true;; bool = b(paramMethod, paramClass))
    {
      return bool;
      if ((localObject instanceof Method))
      {
        if (!b((Method)localObject, paramClass)) {
          throw new IllegalStateException();
        }
        this.b.put(paramClass, this);
      }
    }
  }
  
  void b()
  {
    if (!this.g)
    {
      this.f = this.f.getSuperclass();
      String str = this.f.getName();
      if ((!str.startsWith("java.")) && (!str.startsWith("javax.")) && (!str.startsWith("android."))) {}
    }
    else
    {
      this.f = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/eventbus/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */