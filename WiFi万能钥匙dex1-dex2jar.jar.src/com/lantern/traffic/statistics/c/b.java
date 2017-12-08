package com.lantern.traffic.statistics.c;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

final class b
  implements Runnable
{
  b(a parama) {}
  
  public final void run()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)com.lantern.core.c.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
      new c(this).start();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/statistics/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */