package com.wifi.connect.b;

import android.os.AsyncTask;
import com.bluefay.b.a;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.d.i;

final class y
  implements Runnable
{
  y(v paramv, WkAccessPoint paramWkAccessPoint, String paramString, int paramInt1, int paramInt2, a parama) {}
  
  public final void run()
  {
    new i(this.a, this.b, this.c, this.d, u.a(v.a(this.f), this.a), this.e).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */