package ct;

import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.util.List;

public final class df
{
  private static df a = null;
  
  public static int a(Context paramContext)
  {
    if (paramContext == null)
    {
      i = -1;
      return i;
    }
    boolean bool3 = b(paramContext);
    for (;;)
    {
      try
      {
        localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (localWifiManager != null)
        {
          bool1 = localWifiManager.isWifiEnabled();
          if (!bool1) {
            continue;
          }
          i = 1;
        }
      }
      catch (Exception localException1)
      {
        WifiManager localWifiManager;
        i = 0;
        k = 0;
        j = i;
        i = k;
        continue;
      }
      catch (Error localError1)
      {
        int m;
        i = 0;
        int k = 0;
        int j = i;
        i = k;
        continue;
        boolean bool1 = paramContext.contains("gps");
        continue;
        boolean bool2 = false;
        bool1 = false;
        continue;
        i = 0;
        continue;
      }
      try
      {
        if (Build.VERSION.SDK_INT <= 17) {
          continue;
        }
        bool1 = localWifiManager.isScanAlwaysAvailable();
        if (!bool1) {
          continue;
        }
        i = 1;
        j = 1;
      }
      catch (Error localError2)
      {
        continue;
      }
      catch (Exception localException2)
      {
        continue;
        m = 0;
        continue;
        j = 1;
        continue;
      }
      try
      {
        paramContext = (LocationManager)paramContext.getSystemService("location");
        if (paramContext == null) {
          continue;
        }
        bool2 = paramContext.isProviderEnabled("gps");
        paramContext = paramContext.getAllProviders();
        if (paramContext != null) {
          continue;
        }
        bool1 = false;
      }
      catch (Exception paramContext)
      {
        bool2 = false;
        bool1 = false;
        continue;
      }
      if (bool3) {
        continue;
      }
      m = 1;
      k = m;
      if (j == 0) {
        k = m | 0x2;
      }
      j = k;
      if (!bool2) {
        j = k | 0x4;
      }
      k = j;
      if (i == 0) {
        k = j | 0x8;
      }
      i = k;
      if (bool1) {
        break;
      }
      i = k | 0x10;
      break;
      j = 0;
      i = 0;
      k = j;
      j = i;
      i = k;
    }
  }
  
  public static df a()
  {
    if (a == null) {
      a = new df();
    }
    return a;
  }
  
  private static boolean b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null) {
          continue;
        }
        bool = false;
      }
      catch (Exception paramContext)
      {
        int i;
        boolean bool = false;
        continue;
      }
      return bool;
      i = paramContext.getSimState();
      if (i == 5) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */