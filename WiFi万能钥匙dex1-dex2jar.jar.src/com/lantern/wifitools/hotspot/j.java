package com.lantern.wifitools.hotspot;

import android.widget.RelativeLayout;
import com.lantern.wifitools.R.string;

final class j
  implements Runnable
{
  j(HotspotFragment.a parama) {}
  
  public final void run()
  {
    if (HotspotFragment.l(this.a.a) != null)
    {
      HotspotFragment.m(this.a.a).setEnabled(true);
      HotspotFragment.i(this.a.a).a(null, false);
      HotspotFragment.a(this.a.a, R.string.wifitools_hotspot_openap_failed);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/hotspot/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */