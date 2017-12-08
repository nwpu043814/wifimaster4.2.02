package com.lantern.wifitools.hotspot;

import android.os.Build.VERSION;
import com.lantern.wifitools.R.string;

final class i
  implements Runnable
{
  i(h paramh) {}
  
  public final void run()
  {
    if (HotspotFragment.n(this.a.a)) {
      HotspotFragment.i(this.a.a).a(HotspotFragment.i(this.a.a).c(), true);
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        HotspotFragment.a(this.a.a, R.string.connect_hotspot_fragment_mobile_info);
      } else {
        HotspotFragment.p(this.a.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/hotspot/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */