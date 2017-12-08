package com.wifi.plugin.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;
import com.qihoo.util.StubApp1053578832;
import com.wifi.plugin.BLActivityProxy;
import com.wifi.plugin.b;
import com.wifi.plugin.b.a;
import com.wifi.plugin.b.c;
import java.util.concurrent.ConcurrentHashMap;

public class BLProxyService
  extends Service
{
  private c a;
  private ConcurrentHashMap<String, c> b = new ConcurrentHashMap();
  
  static
  {
    StubApp1053578832.interface11(98);
  }
  
  /* Error */
  private c a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 37	com/wifi/plugin/b/c
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 40	com/wifi/plugin/b/c:<init>	(Landroid/app/Service;Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: aload_2
    //   12: invokevirtual 43	com/wifi/plugin/b/c:a	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 46	com/wifi/plugin/b/c:a	()Lcom/wifi/plugin/b/a;
    //   19: invokevirtual 50	com/wifi/plugin/b/a:b	()V
    //   22: aload_1
    //   23: invokevirtual 46	com/wifi/plugin/b/c:a	()Lcom/wifi/plugin/b/a;
    //   26: invokevirtual 53	com/wifi/plugin/b/a:a	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 46	com/wifi/plugin/b/c:a	()Lcom/wifi/plugin/b/a;
    //   36: aload_0
    //   37: invokestatic 58	com/wifi/plugin/e/a:a	(Lcom/wifi/plugin/b/a;Landroid/content/Context;)V
    //   40: new 60	java/lang/StringBuilder
    //   43: astore_2
    //   44: aload_2
    //   45: ldc 62
    //   47: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_2
    //   51: aload_1
    //   52: invokevirtual 68	com/wifi/plugin/b/c:c	()Ljava/lang/String;
    //   55: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 79	com/wifi/plugin/b:c	(Ljava/lang/String;)V
    //   64: aload_1
    //   65: invokevirtual 46	com/wifi/plugin/b/c:a	()Lcom/wifi/plugin/b/a;
    //   68: getfield 83	com/wifi/plugin/b/a:g	Ldalvik/system/DexClassLoader;
    //   71: aload_1
    //   72: invokevirtual 68	com/wifi/plugin/b/c:c	()Ljava/lang/String;
    //   75: invokevirtual 89	dalvik/system/DexClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   78: invokevirtual 95	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   81: checkcast 4	android/app/Service
    //   84: astore_3
    //   85: aload_1
    //   86: aload_3
    //   87: invokevirtual 98	com/wifi/plugin/b/c:a	(Landroid/app/Service;)V
    //   90: aload_0
    //   91: invokestatic 103	com/wifi/plugin/f/a:a	(Ljava/lang/Object;)Lcom/wifi/plugin/f/a;
    //   94: astore_2
    //   95: aload_3
    //   96: invokestatic 103	com/wifi/plugin/f/a:a	(Ljava/lang/Object;)Lcom/wifi/plugin/f/a;
    //   99: ldc 105
    //   101: bipush 6
    //   103: anewarray 107	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_2
    //   113: ldc 109
    //   115: invokevirtual 112	com/wifi/plugin/f/a:b	(Ljava/lang/String;)Ljava/lang/Object;
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: aload_0
    //   122: invokevirtual 116	java/lang/Object:getClass	()Ljava/lang/Class;
    //   125: invokevirtual 119	java/lang/Class:getName	()Ljava/lang/String;
    //   128: aastore
    //   129: dup
    //   130: iconst_3
    //   131: aload_2
    //   132: ldc 121
    //   134: invokevirtual 112	com/wifi/plugin/f/a:b	(Ljava/lang/String;)Ljava/lang/Object;
    //   137: aastore
    //   138: dup
    //   139: iconst_4
    //   140: aload_0
    //   141: invokevirtual 125	com/wifi/plugin/service/BLProxyService:getApplication	()Landroid/app/Application;
    //   144: aastore
    //   145: dup
    //   146: iconst_5
    //   147: aload_2
    //   148: ldc 127
    //   150: invokevirtual 112	com/wifi/plugin/f/a:b	(Ljava/lang/String;)Ljava/lang/Object;
    //   153: aastore
    //   154: invokevirtual 130	com/wifi/plugin/f/a:a	(Ljava/lang/String;[Ljava/lang/Object;)Lcom/wifi/plugin/f/a;
    //   157: pop
    //   158: aload_1
    //   159: areturn
    //   160: astore_1
    //   161: aload_1
    //   162: invokestatic 133	com/wifi/plugin/b:a	(Ljava/lang/Exception;)V
    //   165: aconst_null
    //   166: astore_1
    //   167: goto -9 -> 158
    //   170: astore_1
    //   171: aload_1
    //   172: invokestatic 133	com/wifi/plugin/b:a	(Ljava/lang/Exception;)V
    //   175: aconst_null
    //   176: astore_1
    //   177: goto -19 -> 158
    //   180: astore_1
    //   181: aload_1
    //   182: invokestatic 133	com/wifi/plugin/b:a	(Ljava/lang/Exception;)V
    //   185: goto -10 -> 175
    //   188: astore_1
    //   189: aload_1
    //   190: invokestatic 133	com/wifi/plugin/b:a	(Ljava/lang/Exception;)V
    //   193: goto -18 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	BLProxyService
    //   0	196	1	paramString1	String
    //   0	196	2	paramString2	String
    //   84	12	3	localService	Service
    // Exception table:
    //   from	to	target	type
    //   32	40	160	java/lang/Exception
    //   40	158	170	java/lang/IllegalAccessException
    //   40	158	180	java/lang/ClassNotFoundException
    //   40	158	188	java/lang/InstantiationException
  }
  
  private void a()
  {
    Toast.makeText(getBaseContext(), "初始化插件服务失败", 3000).show();
  }
  
  public AssetManager getAssets()
  {
    AssetManager localAssetManager;
    if (this.a == null) {
      localAssetManager = super.getAssets();
    }
    for (;;)
    {
      return localAssetManager;
      if (this.a.a().d == null) {
        localAssetManager = super.getAssets();
      } else {
        localAssetManager = this.a.a().d;
      }
    }
  }
  
  public ClassLoader getClassLoader()
  {
    Object localObject;
    if (this.a == null) {
      localObject = super.getClassLoader();
    }
    for (;;)
    {
      return (ClassLoader)localObject;
      if (this.a.a().a()) {
        localObject = this.a.a().g;
      } else {
        localObject = super.getClassLoader();
      }
    }
  }
  
  public Resources getResources()
  {
    Resources localResources;
    if (this.a == null) {
      localResources = super.getResources();
    }
    for (;;)
    {
      return localResources;
      if (this.a.a().e == null) {
        localResources = super.getResources();
      } else {
        localResources = this.a.a().e;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    IBinder localIBinder = null;
    if (this.a == null) {}
    for (;;)
    {
      return localIBinder;
      Service localService = this.a.b();
      if (localService != null) {
        localIBinder = localService.onBind(paramIntent);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.a == null) {}
    for (;;)
    {
      return;
      Service localService = this.a.b();
      if (localService != null) {
        localService.onConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a == null) {}
    for (;;)
    {
      return;
      Service localService = this.a.b();
      if (localService != null) {
        localService.onDestroy();
      }
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.a == null) {}
    for (;;)
    {
      return;
      Service localService = this.a.b();
      if (localService != null) {
        localService.onLowMemory();
      }
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
    if (this.a == null) {}
    for (;;)
    {
      return;
      Service localService = this.a.b();
      if (localService != null) {
        localService.onRebind(paramIntent);
      }
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if (this.a == null) {}
    for (;;)
    {
      return;
      Service localService = this.a.b();
      if (localService != null) {
        localService.onStart(paramIntent, paramInt);
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    b.a("intent:%s, flags:%d, startId:%d", new Object[] { paramIntent, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null) {}
    for (;;)
    {
      return 2;
      String str1 = paramIntent.getStringExtra("plugin_dex_path");
      String str2 = paramIntent.getStringExtra("plugin_class_name");
      if ((str1 == null) || (str1.length() == 0))
      {
        a();
      }
      else if ((str2 == null) || (str2.length() == 0))
      {
        a();
      }
      else
      {
        Object localObject2 = (c)this.b.get(str1);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(str1, str2);
        }
        if (localObject1 == null)
        {
          a();
        }
        else
        {
          this.b.put(str1, localObject1);
          localObject2 = ((c)localObject1).b();
          if (localObject2 == null)
          {
            a();
          }
          else
          {
            this.a = ((c)localObject1);
            ((Service)localObject2).onStartCommand(paramIntent, paramInt1, paramInt2);
          }
        }
      }
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    if (this.a == null) {}
    for (;;)
    {
      return;
      Service localService = this.a.b();
      if (localService != null) {
        localService.onTaskRemoved(paramIntent);
      }
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if (this.a == null) {}
    for (;;)
    {
      return;
      Service localService = this.a.b();
      if (localService != null) {
        localService.onTrimMemory(paramInt);
      }
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    boolean bool;
    if (this.a == null) {
      bool = super.onUnbind(paramIntent);
    }
    for (;;)
    {
      return bool;
      Service localService = this.a.b();
      if (localService != null) {
        bool = localService.onUnbind(paramIntent);
      } else {
        bool = super.onUnbind(paramIntent);
      }
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    b.c("intent:" + paramIntent);
    if (this.a == null) {}
    for (;;)
    {
      return;
      String str = paramIntent.getComponent().getClassName();
      paramIntent.setClass(this, BLActivityProxy.class);
      Bundle localBundle = new Bundle();
      localBundle.putString("plugin_dex_path", this.a.a().c);
      localBundle.putString("plugin_class_name", str);
      paramIntent.putExtras(localBundle);
      super.startActivity(paramIntent);
    }
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    if (this.a == null) {}
    for (paramIntent = super.startService(paramIntent);; paramIntent = super.startService(paramIntent))
    {
      return paramIntent;
      paramIntent.setClass(this, BLProxyService.class);
      paramIntent.putExtra("plugin_dex_path", this.a.a().c);
      paramIntent.putExtra("plugin_class_name", paramIntent.getComponent().getClassName());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/service/BLProxyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */