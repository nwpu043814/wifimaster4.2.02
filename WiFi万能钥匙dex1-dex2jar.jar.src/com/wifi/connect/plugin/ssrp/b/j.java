package com.wifi.connect.plugin.ssrp.b;

import android.os.Handler;
import android.os.Message;
import com.wifi.connect.plugin.ssrp.f.a;

final class j
  extends Handler
{
  j(h paramh) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001)
    {
      if (h.c(this.a) != h.d(this.a))
      {
        h.a(this.a, h.c(this.a));
        h.b(this.a, h.d(this.a));
      }
      if ((h.e(this.a) < h.d(this.a)) && (h.f(this.a) != null)) {
        h.f(this.a).c(h.g(this.a));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */