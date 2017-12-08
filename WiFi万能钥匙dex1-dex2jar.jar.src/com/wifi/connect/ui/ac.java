package com.wifi.connect.ui;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.g.u;
import com.wifi.connect.a.a;
import com.wifi.connect.model.AccessPointAlias;

final class ac
  implements Runnable
{
  ac(ab paramab, String paramString) {}
  
  public final void run()
  {
    AccessPointAlias localAccessPointAlias = null;
    int j = -1;
    Object localObject = ConnectFragment.e(this.b.a).getConnectionInfo();
    int i;
    if (localObject != null)
    {
      String str = u.a(((WifiInfo)localObject).getSSID());
      int k = ((WifiInfo)localObject).getNetworkId();
      i = j;
      localObject = str;
      if (k != -1)
      {
        WifiConfiguration localWifiConfiguration = u.a(ConnectFragment.ah(this.b.a), k);
        i = j;
        localObject = str;
        if (localWifiConfiguration != null)
        {
          i = u.a(localWifiConfiguration);
          localObject = str;
        }
      }
    }
    for (;;)
    {
      if (u.c((String)localObject))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localAccessPointAlias = a.a().a((String)localObject, i);
        }
        if ((localAccessPointAlias != null) && (!TextUtils.isEmpty(localAccessPointAlias.k))) {
          ConnectFragment.b(this.b.a, (String)localObject, i);
        }
      }
      for (;;)
      {
        return;
        if ((localAccessPointAlias != null) && (!TextUtils.isEmpty(localAccessPointAlias.g)))
        {
          ConnectFragment.j(this.b.a).a(localAccessPointAlias.g);
        }
        else
        {
          ConnectFragment.j(this.b.a).a(this.a);
          continue;
          h.c("current wifi is disconnected");
        }
      }
      localObject = null;
      i = j;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */