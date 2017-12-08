package com.lantern.wifitools.hotspot;

final class h
  implements Runnable
{
  h(HotspotFragment paramHotspotFragment) {}
  
  public final void run()
  {
    int i = 0;
    for (;;)
    {
      if ((!HotspotFragment.n(this.a)) && (i < 5)) {
        try
        {
          Thread.sleep(1000L);
          i++;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            com.bluefay.b.h.a(localInterruptedException);
          }
        }
      }
    }
    HotspotFragment.o(this.a).post(new i(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/hotspot/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */