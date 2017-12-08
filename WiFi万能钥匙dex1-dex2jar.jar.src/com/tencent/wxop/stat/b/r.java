package com.tencent.wxop.stat.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r
{
  private static String a = "";
  
  private static WifiInfo T(Context paramContext)
  {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext == null) {}
    }
    for (paramContext = paramContext.getConnectionInfo();; paramContext = null) {
      return paramContext;
    }
  }
  
  public static String U(Context paramContext)
  {
    try
    {
      paramContext = T(paramContext);
      if (paramContext == null) {
        break label26;
      }
      paramContext = paramContext.getBSSID();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Log.e("MtaSDK", "encode error", paramContext);
        label26:
        paramContext = null;
      }
    }
    return paramContext;
  }
  
  public static String V(Context paramContext)
  {
    try
    {
      paramContext = T(paramContext);
      if (paramContext == null) {
        break label26;
      }
      paramContext = paramContext.getSSID();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Log.e("MtaSDK", "encode error", paramContext);
        label26:
        paramContext = null;
      }
    }
    return paramContext;
  }
  
  public static boolean W(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if ((a(paramContext, "android.permission.INTERNET")) && (a(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
        {
          paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
          if (paramContext != null)
          {
            paramContext = paramContext.getActiveNetworkInfo();
            if ((paramContext != null) && (paramContext.isAvailable()))
            {
              bool = true;
              return bool;
            }
            Log.w("MtaSDK", "Network error");
            bool = false;
            continue;
          }
        }
        else
        {
          Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
        }
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        Log.e("MtaSDK", "isNetworkAvailable error", paramContext);
        continue;
      }
      bool = false;
    }
  }
  
  public static JSONArray X(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if ((a(paramContext, "android.permission.INTERNET")) && (a(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
        {
          paramContext = (WifiManager)paramContext.getSystemService("wifi");
          if (paramContext != null)
          {
            List localList = paramContext.getScanResults();
            if ((localList != null) && (localList.size() > 0))
            {
              paramContext = new com/tencent/wxop/stat/b/s;
              paramContext.<init>();
              Collections.sort(localList, paramContext);
              paramContext = new org/json/JSONArray;
              paramContext.<init>();
              int i = 0;
              if ((i < localList.size()) && (i < 10))
              {
                ScanResult localScanResult = (ScanResult)localList.get(i);
                JSONObject localJSONObject = new org/json/JSONObject;
                localJSONObject.<init>();
                localJSONObject.put("bs", localScanResult.BSSID);
                localJSONObject.put("ss", localScanResult.SSID);
                paramContext.put(localJSONObject);
                i++;
                continue;
              }
              return paramContext;
            }
          }
        }
        else
        {
          Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
        }
      }
      catch (Throwable paramContext)
      {
        Log.e("MtaSDK", "isWifiNet error", paramContext);
        continue;
      }
      paramContext = null;
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramString2 != null) {}
    try
    {
      if (paramString2.length() > 0) {
        paramJSONObject.put(paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      for (;;)
      {
        Log.e("MtaSDK", "jsonPut error", paramJSONObject);
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
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
        Log.e("MtaSDK", "checkPermission error", paramContext);
      }
    }
    return bool;
  }
  
  public static String b(Context paramContext)
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
          Log.e("MtaSDK", "Could not get permission of android.permission.READ_PHONE_STATE");
        }
      }
      catch (Throwable paramContext)
      {
        Log.e("MtaSDK", "get device id error", paramContext);
        continue;
      }
      paramContext = null;
    }
  }
  
  public static String c(Context paramContext)
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
        Log.e("MtaSDK", "get wifi address error", paramContext);
        paramContext = "";
        continue;
      }
      return paramContext;
      paramContext = paramContext.getConnectionInfo().getMacAddress();
      continue;
      Log.e("MtaSDK", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
      paramContext = "";
    }
  }
  
  public static String q(String paramString)
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
          byte[] arrayOfByte = h.e(g.b(paramString.getBytes("UTF-8")));
          str1 = new java/lang/String;
          str1.<init>(arrayOfByte, "UTF-8");
        }
        catch (Throwable localThrowable)
        {
          Log.e("MtaSDK", "encode error", localThrowable);
          String str2 = paramString;
        }
      }
    }
  }
  
  public static String t(String paramString)
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
          byte[] arrayOfByte = g.c(h.d(paramString.getBytes("UTF-8")));
          str1 = new java/lang/String;
          str1.<init>(arrayOfByte, "UTF-8");
        }
        catch (Throwable localThrowable)
        {
          Log.e("MtaSDK", "decode error", localThrowable);
          String str2 = paramString;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */