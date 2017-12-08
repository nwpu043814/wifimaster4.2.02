package com.lantern.webox.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bluefay.b.h;

public final class c
{
  public static boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isAvailable())) {
          continue;
        }
        bool = paramContext.isConnected();
        if (!bool) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramContext)
      {
        h.a(paramContext);
        boolean bool = false;
        continue;
      }
      return bool;
      bool = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */