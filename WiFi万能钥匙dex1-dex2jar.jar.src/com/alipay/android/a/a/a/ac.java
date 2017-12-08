package com.alipay.android.a.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public final class ac
{
  private static Boolean a = null;
  
  public static final boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (a != null) {
      bool1 = a.booleanValue();
    }
    for (;;)
    {
      return bool1;
      try
      {
        if ((paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0).flags & 0x2) != 0) {}
        for (bool1 = true;; bool1 = false)
        {
          paramContext = Boolean.valueOf(bool1);
          a = paramContext;
          bool1 = paramContext.booleanValue();
          break;
        }
      }
      catch (Exception paramContext)
      {
        bool1 = bool2;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */