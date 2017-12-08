package com.lantern.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bluefay.a.c;
import com.bluefay.a.e;
import com.bluefay.b.h;
import java.util.Locale;

public final class k
  extends c
{
  public static String c()
  {
    String str = Locale.getDefault().getLanguage();
    if (TextUtils.isEmpty(str)) {
      str = "cn";
    }
    for (;;)
    {
      return str;
      if (str.equalsIgnoreCase("zh")) {
        str = "cn";
      } else {
        str = "en";
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      String str = o(paramContext).getNetworkOperator();
      paramContext = str;
      if (TextUtils.isEmpty(str)) {
        paramContext = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = "";
      }
    }
    return paramContext;
  }
  
  public static String g(Context paramContext)
  {
    try
    {
      String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        paramContext = "";
      }
    }
    return paramContext;
  }
  
  public static String h(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = o(paramContext).getCellLocation();
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
      }
      catch (Exception paramContext)
      {
        int i;
        paramContext = "";
        continue;
      }
      return paramContext;
      if ((paramContext instanceof GsmCellLocation))
      {
        i = ((GsmCellLocation)paramContext).getLac();
        paramContext = String.valueOf(i);
      }
      else
      {
        paramContext = "";
      }
    }
  }
  
  public static String i(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = o(paramContext).getCellLocation();
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
      }
      catch (Exception paramContext)
      {
        int i;
        paramContext = "";
        continue;
      }
      return paramContext;
      if ((paramContext instanceof GsmCellLocation))
      {
        i = ((GsmCellLocation)paramContext).getCid();
        paramContext = String.valueOf(i);
      }
      else
      {
        paramContext = "";
      }
    }
  }
  
  public static int j(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels;
  }
  
  public static int k(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(paramContext);
    return paramContext.widthPixels;
  }
  
  public static String l(Context paramContext)
  {
    Object localObject = f.d();
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    for (;;)
    {
      return (String)localObject;
      Bundle localBundle = e.d(paramContext);
      paramContext = (Context)localObject;
      if (localBundle != null) {
        paramContext = localBundle.get("OS_CHANNEL").toString();
      }
      if (paramContext != null)
      {
        localObject = paramContext;
        if (paramContext.length() != 0) {}
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public static String m(Context paramContext)
  {
    paramContext = e.d(paramContext);
    if (paramContext != null) {}
    for (paramContext = paramContext.getString("WK_APP_ID");; paramContext = null)
    {
      Context localContext;
      if (paramContext != null)
      {
        localContext = paramContext;
        if (paramContext.length() != 0) {}
      }
      else
      {
        localContext = null;
      }
      return localContext;
    }
  }
  
  public static String n(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null) {
      if (paramContext.getType() == 0) {
        paramContext = "g";
      }
    }
    for (;;)
    {
      return paramContext;
      if (paramContext.getType() == 1) {
        paramContext = "w";
      } else {
        paramContext = "";
      }
    }
  }
  
  private static TelephonyManager o(Context paramContext)
  {
    return (TelephonyManager)paramContext.getSystemService("phone");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */