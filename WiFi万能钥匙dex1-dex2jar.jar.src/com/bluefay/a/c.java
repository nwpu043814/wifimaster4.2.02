package com.bluefay.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.bluefay.b.h;

public class c
{
  public static String a(Context paramContext)
  {
    String str = "0.0";
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        h.c("No app version found");
        paramContext = str;
      }
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static int b(Context paramContext)
  {
    int j = 0;
    try
    {
      i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        h.c("No app version found");
        int i = j;
      }
    }
  }
  
  public static boolean b()
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label41;
      }
      paramContext = paramContext.getDeviceId();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        paramContext = null;
        continue;
        paramContext = "";
        continue;
        label41:
        paramContext = null;
      }
    }
    if (paramContext != null) {
      return paramContext;
    }
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label41;
      }
      paramContext = paramContext.getSimSerialNumber();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        paramContext = null;
        continue;
        paramContext = "";
        continue;
        label41:
        paramContext = null;
      }
    }
    if (paramContext != null) {
      return paramContext;
    }
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext == null) {
        break label25;
      }
      paramContext = paramContext.getMacAddress();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        label25:
        paramContext = "";
      }
    }
    return paramContext;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */