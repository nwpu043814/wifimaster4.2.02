package com.wifi.connect.d;

import android.net.wifi.WifiConfiguration;
import android.os.AsyncTask;
import com.bluefay.b.h;
import com.c.a.a.a.b.a.a.a.a;
import com.c.a.a.a.b.a.a.a.a.a;
import com.lantern.core.WkSecretKeyNative;
import com.lantern.core.e;
import com.lantern.core.g.u;
import com.lantern.core.o;
import com.wifi.connect.model.b;

public final class a
  extends AsyncTask<String, Integer, Integer>
{
  private int a;
  private com.bluefay.b.a b;
  private WifiConfiguration c;
  private b d;
  
  public a(WifiConfiguration paramWifiConfiguration, int paramInt, com.bluefay.b.a parama)
  {
    this.c = paramWifiConfiguration;
    this.a = paramInt;
    this.b = parama;
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (!com.lantern.core.c.getServer().a("00302006", paramBoolean1)) {
      return i;
    }
    com.bluefay.d.a.getAppContext();
    WifiConfiguration localWifiConfiguration = this.c;
    i = this.a;
    a.a.a locala = a.a.l();
    Object localObject;
    if (localWifiConfiguration.SSID != null)
    {
      localObject = u.a(localWifiConfiguration.SSID);
      label54:
      locala.a((String)localObject);
      if (localWifiConfiguration.BSSID == null) {
        break label291;
      }
      localObject = localWifiConfiguration.BSSID;
      label77:
      locala.b((String)localObject);
      j = u.a(localWifiConfiguration);
      locala.c(String.valueOf(j));
      localObject = "";
      if (j != 2) {
        break label298;
      }
      localObject = u.a(localWifiConfiguration.preSharedKey);
      label123:
      locala.d(WkSecretKeyNative.a((String)localObject));
      locala.e(String.valueOf(i));
      locala.f("false");
      localObject = ((a.a)locala.c()).b();
      com.lantern.core.c.getServer();
      localObject = o.a("00302006", (byte[])localObject);
      localObject = e.a(com.lantern.core.c.getServer().v(), (byte[])localObject);
      if ((localObject != null) && (localObject.length != 0)) {
        break label400;
      }
    }
    label291:
    label298:
    label319:
    label352:
    label389:
    label400:
    for (int j = 10;; j = 0)
    {
      h.a(com.bluefay.b.c.a((byte[])localObject), new Object[0]);
      do
      {
        do
        {
          do
          {
            try
            {
              com.lantern.core.c.getServer();
              localObject = o.b("00302006", (byte[])localObject);
              boolean bool = ((com.lantern.core.h.a)localObject).c();
              if (!bool) {
                break label319;
              }
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                h.a(localException);
                i = 30;
                continue;
                this.d = null;
                i = 30;
              }
            }
            if (i != 1) {
              break label389;
            }
            this.d = new b();
            this.d.a("0");
            this.d.a = this.a;
            break;
            localObject = "";
            break label54;
            localObject = "";
            break label77;
            if (j != 1) {
              break label123;
            }
            localObject = u.a(localWifiConfiguration.wepKeys[0]);
            break label123;
            i = j;
          } while (!paramBoolean1);
          i = j;
        } while (paramBoolean2);
        if (((com.lantern.core.h.a)localObject).d()) {
          break label352;
        }
        i = j;
      } while (!((com.lantern.core.h.a)localObject).e());
      com.lantern.core.c.getServer().b("00302006", ((com.lantern.core.h.a)localObject).b());
      i = a(true, true);
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */