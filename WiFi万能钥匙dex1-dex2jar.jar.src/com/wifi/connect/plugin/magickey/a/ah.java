package com.wifi.connect.plugin.magickey.a;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bluefay.b.h;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.plugin.magickey.database.AutoConnectStore;
import com.wifi.connect.plugin.magickey.database.b;
import java.util.Iterator;
import java.util.List;

public final class ah
{
  private static ah a;
  private AutoConnectStore b;
  private b c;
  private Context d;
  
  private ah(Context paramContext)
  {
    this.d = paramContext;
    this.b = new AutoConnectStore(paramContext);
    this.c = new b();
  }
  
  public static ah a(Context paramContext)
  {
    if (a == null) {
      a = new ah(paramContext.getApplicationContext());
    }
    return a;
  }
  
  public final void a()
  {
    WifiManager localWifiManager = (WifiManager)this.d.getSystemService("wifi");
    Object localObject = localWifiManager.getConnectionInfo();
    if (localObject != null) {}
    for (int i = ((WifiInfo)localObject).getNetworkId();; i = -1)
    {
      localObject = this.b.a();
      if (localObject == null) {}
      for (;;)
      {
        return;
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = (WkAccessPoint)localIterator.next();
          WifiConfiguration localWifiConfiguration = u.b(this.d, (WkAccessPoint)localObject);
          if (localWifiConfiguration == null)
          {
            this.b.b((WkAccessPoint)localObject);
          }
          else if ((localWifiConfiguration.status != 0) && (localWifiConfiguration.networkId != i) && (localWifiConfiguration.networkId != -1))
          {
            h.a("delete :" + localObject);
            if (localWifiManager.removeNetwork(localWifiConfiguration.networkId))
            {
              localWifiManager.saveConfiguration();
              this.b.b((WkAccessPoint)localObject);
            }
          }
        }
      }
    }
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint)
  {
    this.b.a(paramWkAccessPoint);
    this.c.a(paramWkAccessPoint);
  }
  
  public final void b()
  {
    WifiManager localWifiManager = (WifiManager)this.d.getSystemService("wifi");
    Object localObject = localWifiManager.getConnectionInfo();
    if (localObject != null) {}
    for (int i = ((WifiInfo)localObject).getNetworkId();; i = -1)
    {
      Iterator localIterator = this.c.a().iterator();
      while (localIterator.hasNext())
      {
        WkAccessPoint localWkAccessPoint = (WkAccessPoint)localIterator.next();
        localObject = u.b(this.d, localWkAccessPoint);
        if (localObject == null)
        {
          this.c.b(localWkAccessPoint);
        }
        else if ((((WifiConfiguration)localObject).status != 0) && (((WifiConfiguration)localObject).networkId != i) && (((WifiConfiguration)localObject).networkId != -1))
        {
          h.a("delete :" + localWkAccessPoint);
          if (localWifiManager.removeNetwork(((WifiConfiguration)localObject).networkId))
          {
            localWifiManager.saveConfiguration();
            this.c.b(localWkAccessPoint);
          }
        }
      }
      return;
    }
  }
  
  public final void b(WkAccessPoint paramWkAccessPoint)
  {
    this.b.b(paramWkAccessPoint);
    this.c.b(paramWkAccessPoint);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */