package com.wifi.connect.plugin.ssrp;

import com.bluefay.b.h;

final class a
  implements com.bluefay.b.a
{
  a(ConnectActivity paramConnectActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.a("retcode:%s retmsg:%s data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if ((paramInt == 1) && (ConnectActivity.a(this.a) != null))
    {
      h.a("ssrpConnectActivity SUCCESS retcode:%s retmsg:%s data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
      ConnectActivity.a(this.a).a();
    }
    if (this.a.c()) {}
    for (;;)
    {
      return;
      ConnectActivity.a(this.a, paramInt, paramString, paramObject);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */