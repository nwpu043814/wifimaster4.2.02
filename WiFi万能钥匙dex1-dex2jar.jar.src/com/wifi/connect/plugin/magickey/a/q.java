package com.wifi.connect.plugin.magickey.a;

import android.os.Handler;
import android.os.Message;

final class q
  extends Handler
{
  q(p paramp) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      p.a(this.a, p.a(this.a), true, paramMessage.arg1, paramMessage.arg2);
    }
    for (;;)
    {
      return;
      if (paramMessage.what == 2) {
        p.a(this.a, p.a(this.a), false, paramMessage.arg1, paramMessage.arg2);
      } else if (paramMessage.what == 3) {
        com.lantern.analytics.a.e().a("005015", p.b(this.a).a());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */