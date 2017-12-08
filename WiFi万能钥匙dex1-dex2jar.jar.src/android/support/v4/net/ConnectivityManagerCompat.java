package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;

public class ConnectivityManagerCompat
{
  private static final ConnectivityManagerCompatImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new JellyBeanConnectivityManagerCompatImpl();
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 13) {
        IMPL = new HoneycombMR2ConnectivityManagerCompatImpl();
      } else if (Build.VERSION.SDK_INT >= 8) {
        IMPL = new GingerbreadConnectivityManagerCompatImpl();
      } else {
        IMPL = new BaseConnectivityManagerCompatImpl();
      }
    }
  }
  
  public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager paramConnectivityManager, Intent paramIntent)
  {
    return paramConnectivityManager.getNetworkInfo(((NetworkInfo)paramIntent.getParcelableExtra("networkInfo")).getType());
  }
  
  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    return IMPL.isActiveNetworkMetered(paramConnectivityManager);
  }
  
  static class BaseConnectivityManagerCompatImpl
    implements ConnectivityManagerCompat.ConnectivityManagerCompatImpl
  {
    public boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
    {
      boolean bool2 = true;
      paramConnectivityManager = paramConnectivityManager.getActiveNetworkInfo();
      boolean bool1;
      if (paramConnectivityManager == null) {
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        switch (paramConnectivityManager.getType())
        {
        case 0: 
        default: 
          bool1 = bool2;
          break;
        case 1: 
          bool1 = false;
        }
      }
    }
  }
  
  static abstract interface ConnectivityManagerCompatImpl
  {
    public abstract boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager);
  }
  
  static class GingerbreadConnectivityManagerCompatImpl
    implements ConnectivityManagerCompat.ConnectivityManagerCompatImpl
  {
    public boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
    {
      return ConnectivityManagerCompatGingerbread.isActiveNetworkMetered(paramConnectivityManager);
    }
  }
  
  static class HoneycombMR2ConnectivityManagerCompatImpl
    implements ConnectivityManagerCompat.ConnectivityManagerCompatImpl
  {
    public boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
    {
      return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(paramConnectivityManager);
    }
  }
  
  static class JellyBeanConnectivityManagerCompatImpl
    implements ConnectivityManagerCompat.ConnectivityManagerCompatImpl
  {
    public boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
    {
      return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(paramConnectivityManager);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/net/ConnectivityManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */