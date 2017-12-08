package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class ConnectivityManagerCompatHoneycombMR2
{
  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
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
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 8: 
      default: 
        bool1 = bool2;
        break;
      case 1: 
      case 7: 
      case 9: 
        bool1 = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/net/ConnectivityManagerCompatHoneycombMR2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */