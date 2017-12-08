package com.wifi.connect.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.bluefay.d.b;
import com.lantern.core.c;
import com.lantern.core.config.SsrpConfig;
import com.lantern.core.config.d;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.a.g;
import com.wifi.connect.model.AccessPoint;
import com.wifi.connect.ui.an;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class aj
{
  private final int a = 101;
  private final int[] b = { 128002 };
  private b c = new ak(this, this.b);
  private WifiManager d;
  private ConnectivityManager e;
  private Context f;
  private com.bluefay.b.a g;
  private long h;
  
  public aj(Context paramContext, com.bluefay.b.a parama)
  {
    this.f = paramContext;
    this.d = ((WifiManager)paramContext.getSystemService("wifi"));
    this.e = ((ConnectivityManager)this.f.getSystemService("connectivity"));
    this.g = parama;
  }
  
  private static boolean a(AccessPoint paramAccessPoint)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 18)
    {
      bool1 = bool2;
      if (paramAccessPoint.d > -80)
      {
        bool1 = bool2;
        if (!g.a().a(paramAccessPoint))
        {
          bool1 = bool2;
          if (com.d.a.a.a(paramAccessPoint.a, paramAccessPoint.b))
          {
            com.lantern.analytics.a.e().onEvent("ssrp_show");
            h.a("ssrp show", new Object[0]);
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final void a()
  {
    this.h = 10000L;
    c.addListener(this.c);
    if (!this.c.hasMessages(101)) {
      this.c.sendEmptyMessage(101);
    }
  }
  
  public final void b()
  {
    this.c.removeMessages(101);
    c.removeListener(this.c);
  }
  
  public final void c()
  {
    this.c.removeMessages(101);
    this.c.sendEmptyMessage(101);
  }
  
  public final List<AccessPoint> d()
  {
    String str1;
    ArrayList localArrayList;
    an localan;
    Object localObject4;
    Object localObject6;
    Object localObject5;
    Object localObject2;
    try
    {
      str1 = URLDecoder.decode(" 客人-", "UTF-8");
      localArrayList = new ArrayList();
      localan = new an();
      localObject4 = NetworkInfo.State.UNKNOWN;
      localObject6 = this.d.getConfiguredNetworks();
      if (localObject6 != null)
      {
        localObject5 = this.d.getConnectionInfo();
        Object localObject1 = this.e.getNetworkInfo(1);
        h.a("WifiInfo:" + localObject5, new Object[0]);
        h.a("NetworkInfo:" + localObject1, new Object[0]);
        if (localObject1 != null)
        {
          localObject1 = ((NetworkInfo)localObject1).getState();
          localObject4 = ((List)localObject6).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject6 = new AccessPoint((WifiConfiguration)((Iterator)localObject4).next());
            ((AccessPoint)localObject6).a((WifiInfo)localObject5, (NetworkInfo.State)localObject1);
            if ((!((AccessPoint)localObject6).a.startsWith(str1)) || (((AccessPoint)localObject6).a.equals(u.c(this.f)))) {
              localArrayList.add(localObject6);
            }
            localan.a(((AccessPoint)localObject6).a, localObject6);
          }
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        h.a(localUnsupportedEncodingException);
        str1 = " 客人-";
        continue;
        localObject2 = null;
      }
      localObject4 = localObject2;
      localObject2 = localObject5;
    }
    for (;;)
    {
      localObject5 = null;
      try
      {
        localObject6 = this.d.getScanResults();
        localObject5 = localObject6;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int j;
          int i;
          Iterator localIterator;
          ScanResult localScanResult;
          AccessPoint localAccessPoint;
          h.a(localException2);
          continue;
          if (j == 0)
          {
            localAccessPoint = new AccessPoint(localScanResult);
            if ((localObject2 != null) && (((WifiInfo)localObject2).getSSID() != null))
            {
              String str2 = ((WifiInfo)localObject2).getSSID();
              localObject5 = str2;
              if (!TextUtils.isEmpty(str2))
              {
                j = str2.length();
                localObject5 = str2;
                if (j > 1)
                {
                  localObject5 = str2;
                  if (str2.charAt(0) == '"')
                  {
                    localObject5 = str2;
                    if (str2.charAt(j - 1) == '"') {
                      localObject5 = str2.substring(1, j - 1);
                    }
                  }
                }
              }
              if ((((String)localObject5).equals(localAccessPoint.a())) && (localan.a(localScanResult.SSID).size() == 0)) {
                localAccessPoint.a((NetworkInfo.State)localObject4);
              }
            }
            if (!localAccessPoint.a.startsWith(str1)) {
              localArrayList.add(localAccessPoint);
            }
            localan.a(localAccessPoint.a, localAccessPoint);
            if (a(localAccessPoint))
            {
              localObject5 = new AccessPoint(localScanResult);
              ((AccessPoint)localObject5).a = (str1 + localAccessPoint.a);
              ((AccessPoint)localObject5).c = 3;
              if (!((AccessPoint)localObject5).a.equals(u.c(this.f))) {
                localArrayList.add(localObject5);
              }
              g.a().a(((AccessPoint)localObject5).a, (WkAccessPoint)localObject5);
            }
          }
          i++;
          continue;
          if (j == 0)
          {
            localan.a();
            localArrayList.clear();
          }
          try
          {
            Collections.sort(localArrayList);
            return localArrayList;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              h.c("appsort wifiscanner sort " + localException1.getMessage());
            }
          }
        }
      }
      j = 0;
      i = 0;
      d.a(this.f).a(SsrpConfig.class);
      if (localObject5 != null)
      {
        localIterator = ((List)localObject5).iterator();
        do
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          localScanResult = (ScanResult)localIterator.next();
        } while ((localScanResult.SSID == null) || (localScanResult.SSID.length() == 0) || (localScanResult.capabilities.contains("[IBSS]")) || (localScanResult.SSID.equals("<unknown ssid>")));
        localObject5 = localScanResult.capabilities;
        localObject6 = localan.a(localScanResult.SSID).iterator();
        for (j = 0; ((Iterator)localObject6).hasNext(); j = 1)
        {
          localObject5 = (AccessPoint)((Iterator)localObject6).next();
          if (!((AccessPoint)localObject5).a(localScanResult)) {
            break label847;
          }
          if (a((AccessPoint)localObject5))
          {
            localAccessPoint = new AccessPoint(localScanResult);
            localAccessPoint.a = (str1 + ((AccessPoint)localObject5).a);
            localAccessPoint.c = 3;
            if (!localAccessPoint.a.equals(u.c(this.f))) {
              localArrayList.add(localAccessPoint);
            }
            g.a().a(localAccessPoint.a, localAccessPoint);
          }
        }
      }
      label847:
      Object localObject3 = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */