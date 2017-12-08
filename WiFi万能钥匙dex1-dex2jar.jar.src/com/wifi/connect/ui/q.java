package com.wifi.connect.ui;

import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.connect.R.string;

final class q
  implements com.bluefay.b.a
{
  q(ConnectFragment paramConnectFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.a("retcode:%s retmsg:%s data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (paramInt == 1) {
      e.a(R.string.tips_disconnected_success);
    }
    for (;;)
    {
      if (paramInt == 1)
      {
        ConnectFragment.d(this.a).a(true);
        ConnectFragment.ad(this.a);
      }
      return;
      if (paramInt == 0) {
        e.a(R.string.tips_disconnected_failed);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */