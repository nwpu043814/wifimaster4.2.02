package com.wifi.connect.b;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.bluefay.b.h;
import com.lantern.core.t;
import com.wifi.connect.d.c;

final class o
  implements com.bluefay.b.a
{
  o(d paramd) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.b("DisconenctWifiNetwork retcode:%s,retmsg:%s,data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (paramInt == 1) {
      new com.wifi.connect.d.d(d.c(this.a), d.d(this.a)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (com.lantern.auth.utils.a.b(d.e(this.a))) {
          d.a(this.a, d.d(this.a));
        } else {
          d.b(this.a, d.d(this.a));
        }
      }
      else if (t.g(d.e(this.a))) {
        new c(d.f(this.a)).execute(new String[0]);
      } else {
        this.a.a(d.f(this.a));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */