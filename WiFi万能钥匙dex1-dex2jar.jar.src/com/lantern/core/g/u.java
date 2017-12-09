package com.lantern.core.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.config.Nbaps_Conf;
import com.lantern.core.config.d;
import com.lantern.core.model.WkAccessPoint;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
//核心连接类
public final class u
{
  public static int a(ScanResult paramScanResult)
  {
    int i;
    if (paramScanResult.capabilities.contains("WEP")) {
      i = 1;
    }
    for (;;)
    {
      return i;
      if (paramScanResult.capabilities.contains("PSK")) {
        i = 2;
      } else if (paramScanResult.capabilities.contains("EAP")) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public static int a(WifiConfiguration paramWifiConfiguration)
  {
    int i = 2;
    if (paramWifiConfiguration.allowedKeyManagement.get(1)) {}
    for (;;)
    {
      return i;
      if ((paramWifiConfiguration.allowedKeyManagement.get(2)) || (paramWifiConfiguration.allowedKeyManagement.get(3))) {
        i = 3;
      } else if (paramWifiConfiguration.wepKeys[0] != null) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }

  //根据id获取网络配置。
  public static WifiConfiguration a(Context paramContext, int paramInt)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConfiguredNetworks();
    if (paramContext != null)
    {
      Iterator localIterator = paramContext.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramContext = (WifiConfiguration)localIterator.next();
      } while (paramInt != paramContext.networkId);
    }
    for (;;)
    {
      return paramContext;
      paramContext = null;
    }
  }

  //根据ap bssid ssid pwd组装wificonfig.call from ApBackupRestoreFragment line71
  public static WifiConfiguration a(Context paramContext, WkAccessPoint paramWkAccessPoint, String paramString)
  {
    Object localObject = paramWkAccessPoint.a;
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConfiguredNetworks();
    int j;
    int i;
    if (paramContext != null)
    {
      Iterator localIterator = paramContext.iterator();
      j = 0;
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramContext = (WifiConfiguration)localIterator.next();
          i = j;
          if (paramContext.priority > j) {
            i = paramContext.priority;
          }
          j = i;
        } while (!((String)localObject).equals(a(paramContext.SSID)));
        j = i;
      } while (paramWkAccessPoint.c != a(paramContext));
    }
    for (;;)
    {
      localObject = paramContext;
      if (paramContext == null)
      {
        paramContext = new WifiConfiguration();
        paramContext.SSID = b(paramWkAccessPoint.a);
        paramContext.priority = (i + 1);
        localObject = paramContext;
        if (paramWkAccessPoint.a != null)
        {
          localObject = paramContext;
          if (paramWkAccessPoint.a.length() != paramWkAccessPoint.a.getBytes().length)
          {
            h.a("contains chinese ssid:" + paramWkAccessPoint.a);
            paramContext.BSSID = paramWkAccessPoint.b;
            localObject = paramContext;
          }
        }
      }
      switch (paramWkAccessPoint.c)
      {
      }
      for (;;)
      {
        return (WifiConfiguration)localObject;
        ((WifiConfiguration)localObject).allowedKeyManagement.set(0);
        continue;
        ((WifiConfiguration)localObject).allowedKeyManagement.set(0);
        ((WifiConfiguration)localObject).allowedAuthAlgorithms.set(0);
        ((WifiConfiguration)localObject).allowedAuthAlgorithms.set(1);
        if (paramString.length() != 0)
        {
          i = paramString.length();
          if (((i == 10) || (i == 26) || (i == 58)) && (paramString.matches("[0-9A-Fa-f]*")))
          {
            ((WifiConfiguration)localObject).wepKeys[0] = paramString;
          }
          else
          {
            ((WifiConfiguration)localObject).wepKeys[0] = ("\"" + paramString + '"');
            continue;
            ((WifiConfiguration)localObject).allowedKeyManagement.set(1);
            if (paramString.length() != 0) {
              if (paramString.matches("[0-9A-Fa-f]{64}"))
              {
                //configure network WPA
                ((WifiConfiguration)localObject).preSharedKey = paramString;
              }
              else
              {
                //configure network WPA
                ((WifiConfiguration)localObject).preSharedKey = ("\"" + paramString + '"');
                continue;
                ((WifiConfiguration)localObject).allowedKeyManagement.set(2);
                ((WifiConfiguration)localObject).allowedKeyManagement.set(3);
              }
            }
          }
        }
      }
      paramContext = null;
      i = j;
      continue;
      i = 0;
      paramContext = null;
    }
  }

  //根据ssid获取网络配置。
  public static WifiConfiguration a(Context paramContext, String paramString)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConfiguredNetworks();
    if (paramContext != null)
    {
      Iterator localIterator = paramContext.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramContext = (WifiConfiguration)localIterator.next();
      } while (!paramString.equals(a(paramContext.SSID)));
    }
    for (;;)
    {
      return paramContext;
      paramContext = null;
    }
  }


  //根据ssid和网络id获取网络配置。
  public static WifiConfiguration a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConfiguredNetworks();
    if (paramContext != null)
    {
      Iterator localIterator = paramContext.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramContext = (WifiConfiguration)localIterator.next();
      } while ((!paramString.equals(a(paramContext.SSID))) || (paramInt != a(paramContext)));
    }
    for (;;)
    {
      return paramContext;
      paramContext = null;
    }
  }
  
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

  //获取wifiscanlist.
  public static ArrayList<WkAccessPoint> a(Context paramContext)
  {
    Object localObject = a((WifiManager)paramContext.getSystemService("wifi"));
    paramContext = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ScanResult localScanResult = (ScanResult)((Iterator)localObject).next();
        if (c(localScanResult.SSID))
        {
          WkAccessPoint localWkAccessPoint = new WkAccessPoint();
          localWkAccessPoint.a(localScanResult.SSID);
          localWkAccessPoint.b(localScanResult.BSSID);
          localWkAccessPoint.d = localScanResult.level;
          localWkAccessPoint.c(localScanResult.capabilities);
          paramContext.add(localWkAccessPoint);
        }
      }
    }
    return paramContext;
  }

  //获取ssid相同bssid不同的网络配置
  public static ArrayList<WkAccessPoint> a(Context paramContext, WkAccessPoint paramWkAccessPoint)
  {
    Object localObject = b((WifiManager)paramContext.getSystemService("wifi"));
    ArrayList localArrayList = new ArrayList();
    paramContext = (Nbaps_Conf)d.a(paramContext).a(Nbaps_Conf.class);
    if ((paramContext != null) && (paramContext.d() >= 0)) {}
    for (int i = paramContext.d();; i = 5)
    {
      h.a("Nbaps_Conf num = " + i, new Object[0]);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramContext = (ScanResult)((Iterator)localObject).next();
          if (c(paramContext.SSID))
          {
            WkAccessPoint localWkAccessPoint;
            if ((paramContext.SSID.equals(paramWkAccessPoint.a)) && (!paramContext.BSSID.equals(paramWkAccessPoint.b)))
            {
              localWkAccessPoint = new WkAccessPoint();
              localWkAccessPoint.a(paramContext.SSID);
              localWkAccessPoint.b(paramContext.BSSID);
              localWkAccessPoint.d = paramContext.level;
              localWkAccessPoint.c(paramContext.capabilities);
              localArrayList.add(localWkAccessPoint);
            }
            else
            {
              if ((i <= 0) || (paramContext.SSID.equals(paramWkAccessPoint.a))) {
                break label280;
              }
              localWkAccessPoint = new WkAccessPoint();
              localWkAccessPoint.a(paramContext.SSID);
              localWkAccessPoint.b(paramContext.BSSID);
              localWkAccessPoint.d = paramContext.level;
              localWkAccessPoint.c(paramContext.capabilities);
              localArrayList.add(localWkAccessPoint);
              i--;
            }
          }
        }
      }
      label280:
      for (;;)
      {
        break;
        return localArrayList;
      }
    }
  }
  
  public static List<ScanResult> a(WifiManager paramWifiManager)
  {
    Object localObject = null;
    if (paramWifiManager == null) {
      paramWifiManager = (WifiManager)localObject;
    }
    for (;;)
    {
      return paramWifiManager;
      try
      {
        paramWifiManager = paramWifiManager.getScanResults();
      }
      catch (Exception paramWifiManager)
      {
        paramWifiManager = (WifiManager)localObject;
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt < -82) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }

  //更新现有网络连接的密码
  public static final boolean a(WifiConfiguration paramWifiConfiguration, String paramString)
  {
    boolean bool = true;
    switch (a(paramWifiConfiguration))
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      paramWifiConfiguration.allowedKeyManagement.set(0);
      continue;
      paramWifiConfiguration.allowedKeyManagement.set(0);
      paramWifiConfiguration.allowedAuthAlgorithms.set(0);
      paramWifiConfiguration.allowedAuthAlgorithms.set(1);
      if (paramString.length() != 0)
      {
        int i = paramString.length();
        if (((i == 10) || (i == 26) || (i == 58)) && (paramString.matches("[0-9A-Fa-f]*"))) {
          paramWifiConfiguration.wepKeys[0] = paramString;
        } else {
          paramWifiConfiguration.wepKeys[0] = ("\"" + paramString + '"');
        }
      }
      else
      {
        bool = false;
        continue;
        //configure network WPA
        paramWifiConfiguration.allowedKeyManagement.set(1);
        if (paramString.length() != 0)
        {
          if (paramString.matches("[0-9A-Fa-f]{64}")) {
            paramWifiConfiguration.preSharedKey = paramString;
          } else {
            paramWifiConfiguration.preSharedKey = ("\"" + paramString + '"');
          }
        }
        else
        {
          bool = false;
          continue;
          paramWifiConfiguration.allowedKeyManagement.set(2);
          paramWifiConfiguration.allowedKeyManagement.set(3);
          bool = false;
        }
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!c(paramString1)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (c(paramString2)) {
        if (paramString1.equals(paramString2))
        {
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (a(paramString1).equals(a(paramString2))) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static WifiConfiguration b(Context paramContext)
  {
    Object localObject = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if ((localObject != null) && (((WifiInfo)localObject).getSSID() != null)) {
      if ((localObject == null) || (((WifiInfo)localObject).getSSID() == null)) {
        paramContext = null;
      }
    }
    for (;;)
    {
      return paramContext;
      localObject = a(((WifiInfo)localObject).getSSID());
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConfiguredNetworks();
      if (paramContext != null)
      {
        Iterator localIterator = paramContext.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            paramContext = (WifiConfiguration)localIterator.next();
            if (((String)localObject).equals(a(paramContext.SSID))) {
              break;
            }
          }
        }
      }
      paramContext = null;
      continue;
      paramContext = null;
    }
  }
  
  public static WifiConfiguration b(Context paramContext, WkAccessPoint paramWkAccessPoint)
  {
    return a(paramContext, paramWkAccessPoint.a);
  }
  
  public static String b(String paramString)
  {
    return "\"" + paramString + "\"";
  }
  
  private static List<ScanResult> b(WifiManager paramWifiManager)
  {
    Object localObject = null;
    if (paramWifiManager == null) {
      paramWifiManager = (WifiManager)localObject;
    }
    for (;;)
    {
      return paramWifiManager;
      try
      {
        paramWifiManager = paramWifiManager.getScanResults();
        a locala = new com/lantern/core/g/a;
        locala.<init>();
        Collections.sort(paramWifiManager, locala);
      }
      catch (Exception paramWifiManager)
      {
        paramWifiManager = (WifiManager)localObject;
      }
    }
  }
  
  public static WkAccessPoint c(Context paramContext, WkAccessPoint paramWkAccessPoint)
  {
    Object localObject = a((WifiManager)paramContext.getSystemService("wifi"));
    paramContext = new ArrayList();
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (ScanResult)localIterator.next();
          if ((c(((ScanResult)localObject).SSID)) && (((ScanResult)localObject).SSID.equals(paramWkAccessPoint.a))) {
            if (((ScanResult)localObject).BSSID.equals(paramWkAccessPoint.b))
            {
              paramContext = new WkAccessPoint();
              paramContext.a(((ScanResult)localObject).SSID);
              paramContext.b(((ScanResult)localObject).BSSID);
              paramContext.d = ((ScanResult)localObject).level;
              paramContext.c(((ScanResult)localObject).capabilities);
            }
          }
        }
      }
    }
    for (;;)
    {
      return paramContext;
      WkAccessPoint localWkAccessPoint = new WkAccessPoint();
      localWkAccessPoint.a(((ScanResult)localObject).SSID);
      localWkAccessPoint.b(((ScanResult)localObject).BSSID);
      localWkAccessPoint.d = ((ScanResult)localObject).level;
      localWkAccessPoint.c(((ScanResult)localObject).capabilities);
      paramContext.add(localWkAccessPoint);
      break;
      paramContext = null;
    }
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(1);
    if ((localObject != null) && (((NetworkInfo)localObject).isConnectedOrConnecting()))
    {
      localObject = a(((NetworkInfo)localObject).getExtraInfo());
      if (!c((String)localObject))
      {
        paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
        if (paramContext != null) {
          paramContext = paramContext.getSSID();
        }
      }
    }
    for (;;)
    {
      if (c(paramContext)) {}
      for (;;)
      {
        return paramContext;
        paramContext = null;
      }
      paramContext = (Context)localObject;
      continue;
      paramContext = null;
    }
  }
  
  public static boolean c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramString.equals("<unknown ssid>")) || (paramString.equals("0x"))) {
      h.c("ssid exception:" + paramString);
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static int d(Context paramContext, WkAccessPoint paramWkAccessPoint)
  {
    paramContext = c(paramContext, paramWkAccessPoint);
    if (paramContext == null) {}
    for (int i = 0;; i = paramContext.d) {
      return i;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */