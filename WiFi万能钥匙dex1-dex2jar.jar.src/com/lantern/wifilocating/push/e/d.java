package com.lantern.wifilocating.push.e;

import android.content.Context;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.h.a;
import com.lantern.wifilocating.push.util.g;
import com.lantern.wifilocating.push.util.h;
import com.lantern.wifilocating.push.util.j;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class d
{
  private static d a;
  private Object b = null;
  private Object c = null;
  private Class<?> d;
  private Class<?> e;
  private b f;
  
  private d()
  {
    try
    {
      this.d = Class.forName("com.lantern.core.location.LocationCallBack");
      this.e = Class.forName("com.lantern.core.location.WkLocationManager");
      this.c = this.e.getMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { c.a() });
      ClassLoader localClassLoader = this.d.getClassLoader();
      Class localClass = this.d;
      a locala = new com/lantern/wifilocating/push/e/d$a;
      locala.<init>(this, (byte)0);
      this.b = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, locala);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        h.a(localThrowable);
      }
    }
  }
  
  public static final d a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        d locald = new com/lantern/wifilocating/push/e/d;
        locald.<init>();
        a = locald;
      }
      return a;
    }
    finally {}
  }
  
  private String a(Object paramObject)
  {
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramObject = String.valueOf(this.c.getClass().getDeclaredMethod("getLocationCode", new Class[] { paramObject.getClass() }).invoke(this.c, new Object[] { paramObject }));
        return (String)paramObject;
      }
      catch (Throwable paramObject)
      {
        h.a((Throwable)paramObject);
      }
      paramObject = "";
    }
  }
  
  private void b()
  {
    if (!j.c(c.a())) {}
    for (;;)
    {
      return;
      new e(this).start();
    }
  }
  
  public final void a(b paramb)
  {
    int i = 1;
    this.f = paramb;
    try
    {
      if (this.b != null)
      {
        this.e.getDeclaredMethod("startLocation", new Class[] { this.d }).invoke(this.c, new Object[] { this.b });
        if (i == 0) {
          b();
        }
        return;
      }
    }
    catch (Throwable paramb)
    {
      for (;;)
      {
        h.a(paramb);
        i = 0;
      }
    }
  }
  
  private final class a
    implements InvocationHandler
  {
    private a() {}
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (g.a().a("push-loc-sdk", true)) {}
      for (;;)
      {
        Object localObject2;
        try
        {
          paramObject = paramMethod.getName();
          paramMethod = paramMethod.getParameterTypes();
          if ((!((String)paramObject).equals("callback")) || (paramMethod.length != 1)) {
            break label264;
          }
          localObject1 = paramMethod[0].getDeclaredMethod("getLon", new Class[0]);
          localObject2 = paramMethod[0].getDeclaredMethod("getLat", new Class[0]);
          paramObject = paramMethod[0].getDeclaredMethod("getAddress", new Class[0]);
          paramMethod = paramMethod[0].getDeclaredMethod("getType", new Class[0]);
          localObject1 = String.valueOf(((Method)localObject1).invoke(paramArrayOfObject[0], new Object[0]));
          h.a(paramMethod);
        }
        catch (Throwable paramMethod)
        {
          try
          {
            localObject2 = String.valueOf(((Method)localObject2).invoke(paramArrayOfObject[0], new Object[0]));
          }
          catch (Throwable paramMethod)
          {
            for (;;)
            {
              paramObject = null;
              paramArrayOfObject = null;
            }
          }
          try
          {
            paramObject = String.valueOf(((Method)paramObject).invoke(paramArrayOfObject[0], new Object[0]));
          }
          catch (Throwable paramMethod)
          {
            paramObject = null;
            paramArrayOfObject = (Object[])localObject2;
            break label221;
          }
          try
          {
            paramMethod = d.a(d.this, paramMethod.invoke(paramArrayOfObject[0], new Object[0]));
            paramArrayOfObject = (Object[])localObject2;
            if ((localObject1 == null) || (paramArrayOfObject == null) || (paramMethod == null)) {
              break label230;
            }
            paramObject = new a(paramMethod, (String)localObject1, paramArrayOfObject, (String)paramObject);
            if (d.a(d.this) != null) {
              d.a(d.this).a((a)paramObject);
            }
            return null;
          }
          catch (Throwable paramMethod)
          {
            paramArrayOfObject = (Object[])localObject2;
            break label221;
          }
          paramMethod = paramMethod;
          paramObject = null;
          paramArrayOfObject = null;
          localObject1 = null;
        }
        label221:
        paramMethod = null;
        continue;
        label230:
        d.b(d.this);
        continue;
        label264:
        paramMethod = null;
        paramObject = null;
        paramArrayOfObject = null;
        Object localObject1 = null;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(a parama);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */