package com.wifi.connect.plugin.magickey.a;

import android.os.Handler;
import android.os.Message;

final class b
  extends Handler
{
  b(a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      a.a(this.a, a.a(this.a), true);
    }
    for (;;)
    {
      return;
      if (paramMessage.what == 2) {
        a.a(this.a, a.a(this.a), false);
      } else if (paramMessage.what == 3) {
        com.lantern.analytics.a.e().a("005015", a.b(this.a).a());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */