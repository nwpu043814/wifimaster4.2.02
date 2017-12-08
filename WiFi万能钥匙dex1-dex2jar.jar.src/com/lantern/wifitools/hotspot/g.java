package com.lantern.wifitools.hotspot;

import com.lantern.wifitools.R.string;

final class g
  implements Runnable
{
  g(f paramf) {}
  
  public final void run()
  {
    if (HotspotFragment.n(this.a.a)) {
      HotspotFragment.i(this.a.a).a(HotspotFragment.i(this.a.a).c(), true);
    }
    for (;;)
    {
      return;
      HotspotFragment.a(this.a.a, R.string.connect_hotspot_fragment_mobile_info);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/hotspot/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */