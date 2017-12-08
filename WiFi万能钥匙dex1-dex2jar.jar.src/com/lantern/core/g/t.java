package com.lantern.core.g;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.bluefay.b.h;
import com.bluefay.d.b;
import java.lang.reflect.Method;

final class t
  implements Runnable
{
  t(r paramr, long paramLong) {}
  
  public final void run()
  {
    Object localObject = u.b(r.m(this.b));
    if (r.n(this.b)) {}
    for (;;)
    {
      return;
      boolean bool;
      label87:
      int i;
      label284:
      int j;
      label286:
      int k;
      if ((localObject != null) && (((WifiConfiguration)localObject).networkId != -1))
      {
        if (u.a((WifiConfiguration)localObject) == 0)
        {
          bool = r.e(this.b).disableNetwork(((WifiConfiguration)localObject).networkId);
          h.b("disableNetwork open ap:%s res:%s", new Object[] { ((WifiConfiguration)localObject).SSID, Boolean.valueOf(bool) });
          r.e(this.b).saveConfiguration();
        }
      }
      else
      {
        localObject = r.f(this.b);
        h.a("config.networkId:" + ((WifiConfiguration)localObject).networkId, new Object[0]);
        h.a("config.ssid:" + ((WifiConfiguration)localObject).SSID, new Object[0]);
        h.a("config.bssid:" + ((WifiConfiguration)localObject).BSSID, new Object[0]);
        h.a("config.preSharedKey:" + ((WifiConfiguration)localObject).preSharedKey, new Object[0]);
        h.a("config.sec:" + u.a((WifiConfiguration)localObject), new Object[0]);
        if (r.f(this.b).networkId == -1) {
          break label653;
        }
        if (!r.o(this.b)) {
          break label639;
        }
        i = r.e(this.b).updateNetwork(r.f(this.b));
        j = 1;
        h.a("networkId:" + i, new Object[0]);
        k = i;
        if (i == -1) {
          if (Build.VERSION.SDK_INT >= 23)
          {
            k = i;
            if (j != 0) {}
          }
          else
          {
            r.p(this.b);
            if ((j != 0) && (u.a(r.m(this.b), u.a(r.f(this.b).SSID)) == null))
            {
              h.a("need update, but configuration is gone!", new Object[0]);
              r.f(this.b).networkId = -1;
            }
            if (r.f(this.b).networkId == -1) {
              break label690;
            }
            if (!r.o(this.b)) {
              break label676;
            }
            i = r.e(this.b).updateNetwork(r.f(this.b));
            label429:
            h.a("after toggle networkId:" + i, new Object[0]);
            k = i;
          }
        }
        if (r.n(this.b)) {
          continue;
        }
        if (k == -1) {
          break label767;
        }
        r.f(this.b).networkId = k;
        if (Build.VERSION.SDK_INT < 21) {
          break label739;
        }
        localObject = r.q(this.b);
        if (localObject == null) {
          break label711;
        }
        bool = r.a(this.b, (Method)localObject, k);
        r.e(this.b).saveConfiguration();
      }
      for (;;)
      {
        h.a("enableNetwork res:" + bool, new Object[0]);
        if ((!bool) || (!bool)) {
          break label767;
        }
        r.a(this.b, this.a);
        r.a(this.b, u.a(r.f(this.b).SSID));
        break;
        bool = r.e(this.b).disableNetwork(((WifiConfiguration)localObject).networkId);
        h.b("disableNetwork sec ap:%s res:%s", new Object[] { ((WifiConfiguration)localObject).SSID, Boolean.valueOf(bool) });
        break label87;
        label639:
        i = r.f(this.b).networkId;
        break label284;
        label653:
        i = r.e(this.b).addNetwork(r.f(this.b));
        j = 0;
        break label286;
        label676:
        i = r.f(this.b).networkId;
        break label429;
        label690:
        i = r.e(this.b).addNetwork(r.f(this.b));
        break label429;
        label711:
        bool = r.e(this.b).enableNetwork(k, true);
        r.e(this.b).saveConfiguration();
        continue;
        label739:
        bool = r.e(this.b).enableNetwork(k, true);
        r.e(this.b).saveConfiguration();
      }
      label767:
      r.r(this.b).sendEmptyMessage(102);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */