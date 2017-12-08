package com.lantern.launcher;

import android.content.Context;
import bluefay.app.l;
import com.bluefay.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static final HashMap<String, Class<?>> b = new HashMap();
  private List<l> a = new ArrayList();
  
  public a(Context paramContext)
  {
    l locall = a(paramContext, "com.wifi.connect.ConnectApp");
    if (locall != null) {
      this.a.add(locall);
    }
    locall = a(paramContext, "com.lantern.browser.BrowserApp");
    if (locall != null) {
      this.a.add(locall);
    }
    locall = a(paramContext, "com.lantern.settings.SettingsApp");
    if (locall != null) {
      this.a.add(locall);
    }
    locall = a(paramContext, "com.lantern.feed.FeedApp");
    if (locall != null) {
      this.a.add(locall);
    }
    paramContext = a(paramContext, "com.lantern.dynamictab.DynamicTabApp");
    if (paramContext != null) {
      this.a.add(paramContext);
    }
  }
  
  private static l a(Context paramContext, String paramString)
  {
    try
    {
      Class localClass = (Class)b.get(paramString);
      Object localObject = localClass;
      if (localClass == null)
      {
        localObject = paramContext.getClassLoader().loadClass(paramString);
        b.put(paramString, localObject);
      }
      localObject = (l)((Class)localObject).newInstance();
      ((l)localObject).a = paramContext;
      paramContext = (Context)localObject;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        h.a("Unable to instantiate app " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
        paramContext = null;
      }
    }
    catch (InstantiationException paramContext)
    {
      for (;;)
      {
        h.a("Unable to instantiate app " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        h.a("Unable to instantiate app " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
      }
    }
    return paramContext;
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).a();
    }
  }
  
  public final void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
  
  public final void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
  
  public final void d()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).b();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */