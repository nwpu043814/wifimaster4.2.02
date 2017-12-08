package com.wifi.connect.plugin;

import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.connect.R.string;

final class b
  implements com.bluefay.b.a
{
  b(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.b("EnableMobileNetwork retcode:%s,retmsg:%s,data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (paramInt == 1) {
      a.a(this.a);
    }
    for (;;)
    {
      return;
      e.a(R.string.mobile_connection_disabled);
      a.a(this.a, 0, "enable mobile failed", null);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */