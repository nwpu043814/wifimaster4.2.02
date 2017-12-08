package com.wifipay.common.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class d
{
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      paramContext = paramContext.getAllNetworkInfo();
      bool1 = bool2;
      if (paramContext == null) {}
    }
    for (int i = 0;; i++)
    {
      bool1 = bool2;
      if (i < paramContext.length)
      {
        if (paramContext[i].getState() == NetworkInfo.State.CONNECTED) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */