package com.wifi.plugin.e;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.wifi.plugin.d.c;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static final Map<String, com.wifi.plugin.b.a> a = new ConcurrentHashMap();
  
  public static com.wifi.plugin.b.a a(String paramString)
  {
    com.wifi.plugin.b.a locala2 = (com.wifi.plugin.b.a)a.get(paramString);
    com.wifi.plugin.b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new com.wifi.plugin.b.a();
      locala1.c = paramString;
      a.put(paramString, locala1);
    }
    return locala1;
  }
  
  public static void a(com.wifi.plugin.b.a parama, Context paramContext)
  {
    Object localObject1 = parama.c;
    if (!new File((String)localObject1).exists()) {
      throw new com.wifi.plugin.d.b((String)localObject1);
    }
    com.wifi.plugin.b.c("Init a plugin on" + (String)localObject1);
    Object localObject2;
    if (!parama.a())
    {
      com.wifi.plugin.b.c("Plugin is not been init,init it now！");
      try
      {
        localObject1 = com.wifi.plugin.d.a(paramContext, parama.c);
        if (localObject1 == null)
        {
          new StringBuilder("Can't create Plugin from :").append(parama.c);
          throw new c();
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        throw new com.wifi.plugin.d.d(parama.c);
      }
      parama.f = ((PackageInfo)localObject1);
      parama.a = ((PackageInfo)localObject1).applicationInfo.className;
      try
      {
        localObject1 = (AssetManager)AssetManager.class.newInstance();
        com.wifi.plugin.f.a.a(localObject1).a("addAssetPath", new Object[] { parama.c });
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("Assets = ");
        com.wifi.plugin.b.c(localObject1);
        parama.d = ((AssetManager)localObject1);
        localObject2 = new android/content/res/Resources;
        ((Resources)localObject2).<init>((AssetManager)localObject1, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("Res = ");
        com.wifi.plugin.b.c(localObject2);
        parama.e = ((Resources)localObject2);
        localObject1 = parama.a;
        com.wifi.plugin.b.c("applicationName-------------" + (String)localObject1);
        if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
        {
          localObject2 = parama.g;
          if (localObject2 == null)
          {
            com.wifi.plugin.b.c("loader");
            throw new c();
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    for (;;)
    {
      try
      {
        Application localApplication = (Application)((ClassLoader)localObject2).loadClass(localException).newInstance();
        com.wifi.plugin.f.a.a(localApplication).a("attachBaseContext", new Object[] { paramContext.getApplicationContext() });
        parama.b = localApplication;
        localApplication.onCreate();
        com.wifi.plugin.b.c("init application end");
        return;
      }
      catch (InstantiationException parama)
      {
        com.wifi.plugin.b.c(parama.getMessage());
        continue;
      }
      catch (IllegalAccessException parama)
      {
        com.wifi.plugin.b.c(parama.getMessage());
        continue;
      }
      catch (ClassNotFoundException parama)
      {
        com.wifi.plugin.b.c(parama.getMessage());
        continue;
      }
      com.wifi.plugin.b.c("Plugin have been init.");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */