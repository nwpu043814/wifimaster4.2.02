package com.wifi.connect.model;

import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bluefay.b.h;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.a.a;
import com.wifi.connect.a.d;
import com.wifi.connect.a.e;
import com.wifi.connect.a.f;
import com.wifi.connect.a.g;

public class AccessPoint
  extends WkAccessPoint
  implements Comparable<AccessPoint>
{
  public int e;
  private final int f = -1;
  private boolean g;
  private int h = a.a;
  private String i = "";
  private WifiConfiguration j;
  private WifiInfo k;
  private NetworkInfo.State l;
  
  private AccessPoint() {}
  
  public AccessPoint(ScanResult paramScanResult)
  {
    this.a = paramScanResult.SSID;
    this.b = paramScanResult.BSSID;
    this.c = u.a(paramScanResult);
    boolean bool;
    if ((this.c != 3) && (paramScanResult.capabilities.contains("WPS")))
    {
      bool = true;
      this.g = bool;
      if (this.c == 2) {
        this.h = b(paramScanResult);
      }
      this.e = -1;
      if (paramScanResult.level != -1) {
        break label114;
      }
    }
    label114:
    for (this.d = Integer.MAX_VALUE;; this.d = paramScanResult.level)
    {
      return;
      bool = false;
      break;
    }
  }
  
  public AccessPoint(WifiConfiguration paramWifiConfiguration)
  {
    if (paramWifiConfiguration.SSID == null) {}
    for (String str = "";; str = u.a(paramWifiConfiguration.SSID))
    {
      this.a = str;
      this.b = paramWifiConfiguration.BSSID;
      this.c = u.a(paramWifiConfiguration);
      this.e = paramWifiConfiguration.networkId;
      this.d = Integer.MAX_VALUE;
      this.j = paramWifiConfiguration;
      return;
    }
  }
  
  public AccessPoint(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1, paramString2);
    this.c = paramInt;
    this.e = -1;
    this.d = Integer.MAX_VALUE;
  }
  
  private int a(AccessPoint paramAccessPoint)
  {
    int n = -1;
    int m = n;
    if (!h())
    {
      if (!i()) {
        break label22;
      }
      m = n;
    }
    for (;;)
    {
      return m;
      label22:
      if ((paramAccessPoint.h()) || (paramAccessPoint.i()))
      {
        m = 1;
      }
      else
      {
        boolean bool4 = e.b().b(this);
        boolean bool5 = e.b().b(paramAccessPoint);
        boolean bool9 = f.a().b(this);
        boolean bool7 = f.a().b(paramAccessPoint);
        boolean bool3 = a.a().b(this.a, this.c);
        boolean bool2 = a.a().b(paramAccessPoint.a, paramAccessPoint.c);
        boolean bool8 = d.a().a(this);
        boolean bool1 = d.a().a(paramAccessPoint);
        boolean bool6 = g.a().a(this);
        boolean bool10 = g.a().a(paramAccessPoint);
        if (bool6)
        {
          m = n;
          if (!bool10) {}
        }
        else if ((!bool6) && (bool10))
        {
          m = 1;
        }
        else if (bool3)
        {
          m = n;
          if (!bool2) {}
        }
        else if ((!bool3) && (bool2))
        {
          m = 1;
        }
        else
        {
          if (((bool4) && (bool5)) || ((bool9) && (bool7)))
          {
            if (this.c != 0)
            {
              m = n;
              if (paramAccessPoint.c == 0) {
                continue;
              }
            }
            if ((this.c == 0) && (paramAccessPoint.c != 0))
            {
              m = 1;
              continue;
            }
          }
          if (bool4)
          {
            m = n;
            if (!bool5) {}
          }
          else if ((!bool4) && (bool5))
          {
            m = 1;
          }
          else if (bool9)
          {
            m = n;
            if (!bool7) {}
          }
          else if ((!bool9) && (bool7))
          {
            m = 1;
          }
          else if (bool8)
          {
            m = n;
            if (!bool1) {}
          }
          else if ((!bool8) && (bool1))
          {
            m = 1;
          }
          else if (this.c == 0)
          {
            m = n;
            if (paramAccessPoint.c != 0) {}
          }
          else if ((this.c != 0) && (paramAccessPoint.c == 0))
          {
            m = 1;
          }
          else if (this.d != Integer.MAX_VALUE)
          {
            m = n;
            if (paramAccessPoint.d == Integer.MAX_VALUE) {}
          }
          else if ((this.d == Integer.MAX_VALUE) && (paramAccessPoint.d != Integer.MAX_VALUE))
          {
            m = 1;
          }
          else if (this.e != -1)
          {
            m = n;
            if (paramAccessPoint.e == -1) {}
          }
          else if ((this.e == -1) && (paramAccessPoint.e != -1))
          {
            m = 1;
          }
          else
          {
            n = WifiManager.compareSignalLevel(paramAccessPoint.d, this.d);
            m = n;
            if (n == 0) {
              m = this.a.compareToIgnoreCase(paramAccessPoint.a);
            }
          }
        }
      }
    }
  }
  
  private static int b(ScanResult paramScanResult)
  {
    boolean bool1 = paramScanResult.capabilities.contains("WPA-PSK");
    boolean bool2 = paramScanResult.capabilities.contains("WPA2-PSK");
    int m;
    if ((bool2) && (bool1)) {
      m = a.d;
    }
    for (;;)
    {
      return m;
      if (bool2)
      {
        m = a.c;
      }
      else if (bool1)
      {
        m = a.b;
      }
      else
      {
        h.b("Received abnormal flag string: " + paramScanResult.capabilities);
        m = a.a;
      }
    }
  }
  
  public final void a(NetworkInfo.State paramState)
  {
    this.l = paramState;
  }
  
  public final void a(WifiConfiguration paramWifiConfiguration)
  {
    this.j = paramWifiConfiguration;
  }
  
  public final void a(WifiInfo paramWifiInfo, NetworkInfo.State paramState)
  {
    if ((paramWifiInfo != null) && (this.e != -1) && (this.e == paramWifiInfo.getNetworkId()))
    {
      this.d = paramWifiInfo.getRssi();
      this.k = paramWifiInfo;
      this.l = paramState;
    }
    for (;;)
    {
      return;
      if (this.k != null)
      {
        this.k = null;
        this.l = null;
      }
    }
  }
  
  public final boolean a(ScanResult paramScanResult)
  {
    if ((this.a.equals(paramScanResult.SSID)) && (this.c == u.a(paramScanResult)))
    {
      this.b = paramScanResult.BSSID;
      if (WifiManager.compareSignalLevel(paramScanResult.level, this.d) > 0) {
        this.d = paramScanResult.level;
      }
      if (this.c == 2) {
        this.h = b(paramScanResult);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void b(WifiConfiguration paramWifiConfiguration)
  {
    this.j = paramWifiConfiguration;
    this.e = paramWifiConfiguration.networkId;
  }
  
  public final String d()
  {
    return this.i;
  }
  
  public final void d(String paramString)
  {
    this.i = paramString;
  }
  
  public final int e()
  {
    if (this.d == Integer.MAX_VALUE) {}
    for (int m = -1;; m = WifiManager.calculateSignalLevel(this.d, 4)) {
      return m;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof AccessPoint)) {}
    for (;;)
    {
      return bool;
      if (a((AccessPoint)paramObject) == 0) {
        bool = true;
      }
    }
  }
  
  public final WifiConfiguration f()
  {
    return this.j;
  }
  
  public final void g()
  {
    this.l = NetworkInfo.State.DISCONNECTED;
  }
  
  public final boolean h()
  {
    if (this.l == NetworkInfo.State.CONNECTED) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    int m = 0;
    if (this.k != null) {
      m = this.k.hashCode() * 13 + 0;
    }
    return m + this.d * 19 + this.e * 23 + this.a.hashCode() * 29;
  }
  
  public final boolean i()
  {
    if (this.l == NetworkInfo.State.CONNECTING) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean j()
  {
    if ((this.l == NetworkInfo.State.CONNECTED) || (this.l == NetworkInfo.State.CONNECTING)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final NetworkInfo.State k()
  {
    return this.l;
  }
  
  static enum a {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/AccessPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */