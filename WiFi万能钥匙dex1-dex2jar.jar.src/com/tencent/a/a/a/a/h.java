package com.tencent.a.a.a.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import com.tencent.wxop.stat.b.g;
import org.json.JSONObject;

public final class h
{
  private static void a(String paramString, Throwable paramThrowable)
  {
    Log.e("MID", paramString, paramThrowable);
  }
  
  static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (d(paramString2)) {
      paramJSONObject.put(paramString1, paramString2);
    }
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0) {
        bool = true;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        a("checkPermission error", paramContext);
      }
    }
    return bool;
  }
  
  static String b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (a(paramContext, "android.permission.READ_PHONE_STATE"))
        {
          paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
          if (paramContext != null) {
            return paramContext;
          }
        }
        else
        {
          Log.i("MID", "Could not get permission of android.permission.READ_PHONE_STATE");
        }
      }
      catch (Throwable paramContext)
      {
        Log.w("MID", paramContext);
        continue;
      }
      paramContext = "";
    }
  }
  
  static String c(Context paramContext)
  {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {}
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
      }
      catch (Exception paramContext)
      {
        Log.i("MID", "get wifi address error" + paramContext);
        paramContext = "";
        continue;
      }
      return paramContext;
      paramContext = paramContext.getConnectionInfo().getMacAddress();
      continue;
      Log.i("MID", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
      paramContext = "";
    }
  }
  
  static boolean d(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static boolean e(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() >= 40)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static String f(String paramString)
  {
    String str1;
    if (paramString == null) {
      str1 = null;
    }
    for (;;)
    {
      return str1;
      str1 = paramString;
      if (Build.VERSION.SDK_INT >= 8) {
        try
        {
          byte[] arrayOfByte = g.c(Base64.decode(paramString.getBytes("UTF-8"), 0));
          str1 = new java/lang/String;
          str1.<init>(arrayOfByte, "UTF-8");
          str1 = str1.trim().replace("\t", "").replace("\n", "").replace("\r", "");
        }
        catch (Throwable localThrowable)
        {
          a("decode error", localThrowable);
          String str2 = paramString;
        }
      }
    }
  }
  
  static String g(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    for (;;)
    {
      return (String)localObject;
      localObject = paramString;
      if (Build.VERSION.SDK_INT >= 8) {
        try
        {
          localObject = Base64.encode(g.b(paramString.getBytes("UTF-8")), 0);
          String str2 = new java/lang/String;
          str2.<init>((byte[])localObject, "UTF-8");
          localObject = str2.trim().replace("\t", "").replace("\n", "").replace("\r", "");
        }
        catch (Throwable localThrowable)
        {
          a("decode error", localThrowable);
          String str1 = paramString;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/a/a/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */