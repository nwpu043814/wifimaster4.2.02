package com.wifi.connect.d;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.bluefay.b.h;
import com.lantern.core.g.j;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;

public final class c
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private String b;
  
  public c(com.bluefay.b.a parama)
  {
    this.a = parama;
  }
  
  private Integer a()
  {
    Object localObject2 = j.a(com.lantern.core.c.getAppContext());
    if (localObject2 != null)
    {
      localObject1 = (WifiManager)com.lantern.core.c.getAppContext().getSystemService("wifi");
      localObject2 = u.b(com.lantern.core.c.getAppContext(), (WkAccessPoint)localObject2);
      if ((localObject2 != null) && (((WifiConfiguration)localObject2).networkId != -1)) {
        ((WifiManager)localObject1).disableNetwork(((WifiConfiguration)localObject2).networkId);
      }
      ((WifiManager)localObject1).disconnect();
    }
    com.bluefay.a.a.a(com.lantern.core.c.getAppContext(), true);
    for (int i = 0; (!com.bluefay.a.a.b(com.lantern.core.c.getAppContext())) && (i < 5); i++) {
      SystemClock.sleep(1000L);
    }
    boolean bool = com.bluefay.a.a.b(com.lantern.core.c.getAppContext());
    h.a("enable mobile:" + bool);
    if (!bool) {
      if (com.lantern.auth.utils.a.b(com.lantern.core.c.getAppContext())) {
        this.b = "10003";
      }
    }
    for (Object localObject1 = Integer.valueOf(0);; localObject1 = Integer.valueOf(1))
    {
      return (Integer)localObject1;
      this.b = "10012";
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */