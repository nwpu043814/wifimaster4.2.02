package com.wifi.connect.plugin.magickey;

import com.bluefay.b.h;
import com.wifi.connect.plugin.magickey.a.al;

final class a
  implements com.bluefay.b.a
{
  a(ConnectActivity paramConnectActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.a("retcode:%s retmsg:%s data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    ConnectActivity.a(this.a).a(paramInt, paramString, paramObject);
    ConnectActivity.a(this.a, paramInt, paramString, paramObject);
    if (this.a.c()) {}
    for (;;)
    {
      return;
      ConnectActivity.b(this.a, paramInt, paramString, paramObject);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */