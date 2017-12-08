package com.lantern.traffic.monitor.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.lantern.analytics.a;
import com.lantern.settings.R.string;
import java.util.HashMap;

final class e
  implements View.OnClickListener
{
  e(TrafficMonitorActivity.a parama, HashMap paramHashMap) {}
  
  public final void onClick(View paramView)
  {
    if (TrafficMonitorActivity.a(TrafficMonitorActivity.a.a(this.b), this.a.get("appPackageName").toString()))
    {
      paramView = new Intent("android.intent.action.DELETE", Uri.parse("package:" + this.a.get("appPackageName").toString()));
      this.b.a.startActivityForResult(paramView, 1001);
      TrafficMonitorActivity.b(this.b.a, this.a.get("appPackageName").toString());
      Toast.makeText(TrafficMonitorActivity.a.a(this.b), this.b.a.getString(R.string.traffic_choose_sure), 1).show();
      a.e().onEvent("m703_" + TrafficMonitorActivity.g(this.b.a));
    }
    for (;;)
    {
      return;
      Toast.makeText(TrafficMonitorActivity.a.a(this.b), this.b.a.getString(R.string.traffic_app_unstall), 1).show();
      this.b.a.finish();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/monitor/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */