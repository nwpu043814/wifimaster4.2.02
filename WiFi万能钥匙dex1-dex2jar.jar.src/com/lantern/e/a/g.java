package com.lantern.e.a;

import android.net.VpnService;
import android.os.Handler;
import com.lantern.wifiseccheck.LogUtils;

final class g
  implements Runnable
{
  g(b paramb) {}
  
  public final void run()
  {
    b.a(this.a, VpnService.prepare(this.a));
    if (b.c(this.a) != null)
    {
      LogUtils.i("HomeSdkAct", "-----prepareStartService--intent != null ");
      b.a(this.a).sendEmptyMessage(10);
    }
    for (;;)
    {
      return;
      LogUtils.i("HomeSdkAct", "-----prepareStartService--intent == null ");
      this.a.onActivityResult(1, -1, null);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/e/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */