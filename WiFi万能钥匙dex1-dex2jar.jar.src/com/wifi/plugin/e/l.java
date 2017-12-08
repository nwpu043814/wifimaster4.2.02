package com.wifi.plugin.e;

import android.content.Context;
import com.wifi.plugin.f;
import com.wifi.plugin.f.a;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends DexClassLoader
{
  public static String a = "";
  private static final Map<String, l> b = new ConcurrentHashMap();
  
  private l(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    a = paramString1;
    f.a(paramString1, paramString3);
  }
  
  public static l a(String paramString, Context paramContext, ClassLoader paramClassLoader)
  {
    l locall2 = (l)b.get(paramString);
    l locall1 = locall2;
    if (locall2 == null)
    {
      locall1 = new l(paramString, paramContext.getDir("plugin", 0).getAbsolutePath(), paramContext.getDir("plugin_lib", 0).getAbsolutePath(), paramClassLoader);
      b.put(paramString, locall1);
    }
    return locall1;
  }
  
  public static ClassLoader a()
  {
    Object localObject = (Context)a.a("android.app.ActivityThread").c("currentActivityThread").c("getSystemContext").a();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Context)localObject).getClassLoader()) {
      return (ClassLoader)localObject;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/e/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */