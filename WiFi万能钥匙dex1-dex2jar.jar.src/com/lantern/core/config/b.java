package com.lantern.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class b
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("config_extra_data", 0).getString(paramString1, paramString2);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext.getSharedPreferences("config_extra_data", 0).edit().putString(paramString1, paramString2).commit();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */