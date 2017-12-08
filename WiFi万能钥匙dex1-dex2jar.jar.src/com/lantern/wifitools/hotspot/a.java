package com.lantern.wifitools.hotspot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class a
  extends BroadcastReceiver
{
  a(HotspotFragment paramHotspotFragment) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals(k.f)) {
      HotspotFragment.a(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/hotspot/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */