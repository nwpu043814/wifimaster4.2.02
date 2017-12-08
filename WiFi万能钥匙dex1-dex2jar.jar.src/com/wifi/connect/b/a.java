package com.wifi.connect.b;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import com.bluefay.b.h;
import com.lantern.core.model.WkAccessPoint;

public final class a
{
  private Context a;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a(WkAccessPoint paramWkAccessPoint, WifiConfiguration paramWifiConfiguration, int paramInt, com.bluefay.b.a parama)
  {
    paramWifiConfiguration.BSSID = paramWkAccessPoint.b;
    new Handler().postDelayed(new b(this, paramWifiConfiguration, paramInt, parama), 500L);
  }
  
  public final void a(boolean paramBoolean, WkAccessPoint paramWkAccessPoint, WifiConfiguration paramWifiConfiguration, com.bluefay.b.a parama)
  {
    if (paramBoolean)
    {
      h.a("backup asyncBackupAp auto true", new Object[0]);
      a(paramWkAccessPoint, paramWifiConfiguration, 10, parama);
    }
    for (;;)
    {
      return;
      h.a("backup asyncBackupAp auto false", new Object[0]);
      a(paramWkAccessPoint, paramWifiConfiguration, 0, parama);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */