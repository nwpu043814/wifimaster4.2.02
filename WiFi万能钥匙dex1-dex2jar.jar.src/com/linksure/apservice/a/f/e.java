package com.linksure.apservice.a.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class e
{
  public static String a(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      paramContext = String.valueOf(i);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "unknown";
      }
    }
    return paramContext;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */