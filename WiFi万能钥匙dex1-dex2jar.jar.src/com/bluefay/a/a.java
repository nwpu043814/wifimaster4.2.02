package com.bluefay.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bluefay.b.h;
import java.lang.reflect.Method;

public final class a
{
  public static void a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      paramContext.getClass().getMethod("setMobileDataEnabled", new Class[] { Boolean.TYPE }).invoke(paramContext, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.getType() == 1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.getType() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnectedOrConnecting())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */