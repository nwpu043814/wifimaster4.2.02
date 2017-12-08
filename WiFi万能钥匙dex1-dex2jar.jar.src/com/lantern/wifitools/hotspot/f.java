package com.lantern.wifitools.hotspot;

import com.bluefay.b.h;

final class f
  implements Runnable
{
  f(HotspotFragment paramHotspotFragment) {}
  
  public final void run()
  {
    int i = 0;
    for (;;)
    {
      if ((!HotspotFragment.n(this.a)) && (i < 10)) {
        try
        {
          Thread.sleep(1000L);
          i++;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            h.a(localInterruptedException);
          }
        }
      }
    }
    HotspotFragment.o(this.a).post(new g(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/hotspot/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */