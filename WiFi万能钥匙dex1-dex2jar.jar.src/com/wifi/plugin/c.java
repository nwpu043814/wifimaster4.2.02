package com.wifi.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.wifi.plugin.service.BLProxyService;

public final class c
{
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      paramString1 = new Intent();
      paramString1.setClassName(paramContext, paramString2);
      paramString1.putExtras(paramBundle);
      paramContext.startActivity(paramString1);
    }
    for (;;)
    {
      return;
      Intent localIntent = new Intent(paramContext, BLActivityProxy.class);
      paramBundle.putString("plugin_dex_path", paramString1);
      paramBundle.putString("plugin_class_name", paramString2);
      localIntent.putExtras(paramBundle);
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    b.d(paramString);
    if (paramBoolean) {
      b.a(1);
    }
    for (;;)
    {
      return;
      b.a(2);
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      paramString1 = new Intent();
      paramString1.setClassName(paramContext, paramString2);
      paramString1.putExtras(paramBundle);
      paramContext.startService(paramString1);
    }
    for (;;)
    {
      return;
      Intent localIntent = new Intent(paramContext, BLProxyService.class);
      paramBundle.putString("plugin_dex_path", paramString1);
      paramBundle.putString("plugin_class_name", paramString2);
      localIntent.putExtras(paramBundle);
      paramContext.startService(localIntent);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */