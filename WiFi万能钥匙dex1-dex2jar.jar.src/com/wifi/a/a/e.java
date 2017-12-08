package com.wifi.a.a;

import com.bluefay.b.h;
import com.lantern.connect.R.string;

final class e
  implements com.bluefay.b.a
{
  e(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.b("EnableMobileNetwork retcode:%s,retmsg:%s,data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (paramInt == 1) {
      a.a(this.a, a.a(this.a).b(), "WifiMasterKey/maps", a.b(a.a(this.a)));
    }
    for (;;)
    {
      return;
      com.bluefay.a.e.a(R.string.mobile_connection_disabled);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */