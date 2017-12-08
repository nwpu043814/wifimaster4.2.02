package ct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import java.util.Collections;
import java.util.List;

public final class dh
{
  public static boolean a = false;
  
  public static boolean a(WifiManager paramWifiManager)
  {
    if (paramWifiManager != null) {}
    for (;;)
    {
      try
      {
        bool = paramWifiManager.startScan();
        return bool;
      }
      catch (Exception paramWifiManager)
      {
        a = true;
      }
      boolean bool = false;
    }
  }
  
  public static boolean a(bi parambi)
  {
    parambi = parambi.b();
    if ((parambi != null) && (parambi.isWifiEnabled())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static List<ScanResult> b(WifiManager paramWifiManager)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramWifiManager != null) {}
    try
    {
      localObject1 = paramWifiManager.getScanResults();
      paramWifiManager = (WifiManager)localObject1;
      if (localObject1 == null) {
        paramWifiManager = Collections.emptyList();
      }
      return paramWifiManager;
    }
    catch (Exception paramWifiManager)
    {
      for (;;)
      {
        a = true;
        localObject1 = localObject2;
      }
    }
  }
  
  public static boolean b(bi parambi)
  {
    parambi = parambi.b();
    boolean bool1 = false;
    boolean bool2;
    if (parambi != null)
    {
      bool2 = parambi.isWifiEnabled();
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18) {
        bool1 = parambi.isScanAlwaysAvailable();
      }
      return bool1;
    }
    catch (Error parambi)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    catch (Exception parambi)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
  }
  
  public static String c(bi parambi)
  {
    parambi = parambi.b();
    if (parambi != null)
    {
      parambi = parambi.getConnectionInfo();
      if (parambi != null)
      {
        parambi = parambi.getMacAddress();
        if (parambi == null) {
          break label35;
        }
      }
    }
    for (;;)
    {
      return parambi;
      parambi = "";
      break;
      label35:
      parambi = "";
      continue;
      parambi = "";
    }
  }
  
  public static String d(bi parambi)
  {
    parambi = parambi.a;
    if (parambi == null) {
      parambi = "{}";
    }
    for (;;)
    {
      return parambi;
      try
      {
        Object localObject = (WifiManager)parambi.getSystemService("wifi");
        parambi = (ConnectivityManager)parambi.getSystemService("connectivity");
        if ((localObject == null) || (parambi == null))
        {
          parambi = "{}";
        }
        else
        {
          localObject = ((WifiManager)localObject).getConnectionInfo();
          parambi = parambi.getNetworkInfo(1);
          if ((localObject != null) && (parambi != null) && (parambi.isConnected()))
          {
            parambi = ((WifiInfo)localObject).getBSSID();
            if ((parambi == null) || (parambi.equals("000000000000")) || (parambi.equals("00-00-00-00-00-00")) || (parambi.equals("00:00:00:00:00:00")))
            {
              parambi = "{}";
            }
            else
            {
              int i = ((WifiInfo)localObject).getRssi();
              if ((i < -100) || (i > -20))
              {
                parambi = "{}";
              }
              else
              {
                localObject = ((WifiInfo)localObject).getSSID().replace("\"", "").replace("|", "");
                StringBuilder localStringBuilder = new java/lang/StringBuilder;
                localStringBuilder.<init>();
                localStringBuilder.append("{");
                localStringBuilder.append("\"mac\":\"");
                localStringBuilder.append(parambi);
                localStringBuilder.append("\",\"rssi\":");
                localStringBuilder.append(i);
                localStringBuilder.append(",\"ssid\":\"");
                localStringBuilder.append((String)localObject);
                localStringBuilder.append("\"}");
                parambi = localStringBuilder.toString();
              }
            }
          }
          else
          {
            parambi = "{}";
          }
        }
      }
      catch (Exception parambi)
      {
        parambi = "{}";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */