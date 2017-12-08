package com.lantern.wifitools.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;

public final class h
{
  public static int a = -1;
  private static int b = 3000;
  private static int c = 3000;
  
  public static String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = paramString;
    }
    for (;;)
    {
      return str;
      int i = paramString.length();
      str = paramString;
      if (i > 1)
      {
        str = paramString;
        if (paramString.charAt(0) == '"')
        {
          str = paramString;
          if (paramString.charAt(i - 1) == '"') {
            str = paramString.substring(1, i - 1);
          }
        }
      }
    }
  }
  
  public static final void a(Context paramContext, boolean paramBoolean)
  {
    c.a(c.a(ConnectivityManager.class, "setMobileDataEnabled", new Class[] { Boolean.TYPE }), c(paramContext), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      NetworkInfo.State localState = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(0).getState();
      if (localState != NetworkInfo.State.CONNECTED)
      {
        paramContext = NetworkInfo.State.CONNECTING;
        if (localState != paramContext) {
          break label43;
        }
      }
      bool = true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        label43:
        bool = false;
      }
    }
    return bool;
  }
  
  public static final boolean b(Context paramContext)
  {
    paramContext = c(paramContext).getNetworkInfo(0);
    if (paramContext != null)
    {
      paramContext = paramContext.getState();
      if ((NetworkInfo.State.CONNECTING != paramContext) && (NetworkInfo.State.CONNECTED != paramContext)) {
        break label41;
      }
    }
    label41:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      paramContext = null;
      break;
    }
  }
  
  private static ConnectivityManager c(Context paramContext)
  {
    return (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */