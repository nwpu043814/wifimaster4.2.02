package com.bluefay.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public final class b
{
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label19;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        label19:
        paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
        bool1 = true;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        bool1 = bool2;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */