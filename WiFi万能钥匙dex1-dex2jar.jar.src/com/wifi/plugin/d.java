package com.wifi.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class d
{
  public static PackageInfo a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().getPackageArchiveInfo(paramString, 5);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */