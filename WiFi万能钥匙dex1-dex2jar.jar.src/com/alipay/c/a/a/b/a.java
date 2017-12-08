package com.alipay.c.a.a.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class a
{
  private static a a = new a();
  
  public static a a()
  {
    return a;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = "0.0.0";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */