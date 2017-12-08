package com.wifi.connect.plugin.magickey.d;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.g.j;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;

public final class b
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private int b;
  
  public b(com.bluefay.b.a parama)
  {
    this.a = parama;
  }
  
  private Integer a()
  {
    Object localObject2 = j.a(c.getAppContext());
    if (localObject2 != null)
    {
      localObject1 = (WifiManager)c.getAppContext().getSystemService("wifi");
      localObject2 = u.b(c.getAppContext(), (WkAccessPoint)localObject2);
      if ((localObject2 != null) && (((WifiConfiguration)localObject2).networkId != -1)) {
        ((WifiManager)localObject1).disableNetwork(((WifiConfiguration)localObject2).networkId);
      }
      ((WifiManager)localObject1).disconnect();
    }
    com.bluefay.a.a.a(c.getAppContext(), true);
    for (int i = 0; (!com.bluefay.a.a.b(c.getAppContext())) && (i < 5); i++) {
      SystemClock.sleep(1000L);
    }
    boolean bool = com.bluefay.a.a.b(c.getAppContext());
    h.a("enable mobile:" + bool);
    if (!bool) {
      if (com.lantern.auth.utils.a.b(c.getAppContext())) {
        this.b = 10101;
      }
    }
    for (Object localObject1 = Integer.valueOf(0);; localObject1 = Integer.valueOf(1))
    {
      return (Integer)localObject1;
      this.b = 10105;
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */