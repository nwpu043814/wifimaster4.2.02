package com.wifi.connect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.core.model.WkAccessPoint;

final class ao
  implements View.OnClickListener
{
  ao(TopViewNearbyApActivity paramTopViewNearbyApActivity, WkAccessPoint paramWkAccessPoint) {}
  
  public final void onClick(View paramView)
  {
    TopViewNearbyApActivity.a(this.b, this.a);
    this.b.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */