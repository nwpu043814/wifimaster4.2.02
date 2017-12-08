package com.wifi.connect.plugin.magickey.a;

import android.os.Handler;
import android.os.Message;
import com.wifi.connect.plugin.a.a;
import com.wifi.connect.plugin.a.c;

final class ap
  extends Handler
{
  ap(am paramam) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001)
    {
      if (am.c(this.a) != am.d(this.a))
      {
        am.a(this.a, am.c(this.a));
        am.b(this.a, am.d(this.a));
      }
      if (am.e(this.a) < am.d(this.a))
      {
        if (am.f(this.a) != null) {
          am.f(this.a).c(am.g(this.a));
        }
        if (am.h(this.a) != null) {
          am.h(this.a).c(am.g(this.a));
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */