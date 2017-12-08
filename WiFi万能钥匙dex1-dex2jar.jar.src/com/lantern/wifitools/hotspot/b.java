package com.lantern.wifitools.hotspot;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.wifitools.R.id;

final class b
  implements View.OnClickListener
{
  b(HotspotFragment paramHotspotFragment) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == R.id.on_off_bar) {
      HotspotFragment.b(this.a);
    }
    if (paramView.getId() == R.id.setting_bar) {
      HotspotFragment.c(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/hotspot/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */