package com.lantern.traffic.monitor.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.lantern.settings.R.string;
import java.util.HashMap;

final class d
  implements View.OnClickListener
{
  d(TrafficMonitorActivity.a parama, HashMap paramHashMap) {}
  
  public final void onClick(View paramView)
  {
    Intent localIntent;
    int i;
    if (TrafficMonitorActivity.a(TrafficMonitorActivity.a.a(this.b), this.a.get("appPackageName").toString()))
    {
      localIntent = new Intent();
      i = Build.VERSION.SDK_INT;
      if (i >= 9)
      {
        localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent.setData(Uri.fromParts("package", this.a.get("appPackageName").toString(), null));
        TrafficMonitorActivity.a.a(this.b).startActivity(localIntent);
        Toast.makeText(TrafficMonitorActivity.a.a(this.b), this.b.a.getString(R.string.traffic_choose_stop), 1).show();
      }
    }
    for (;;)
    {
      return;
      if (i == 8) {}
      for (paramView = "pkg";; paramView = "com.android.settings.ApplicationPkgName")
      {
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
        localIntent.putExtra(paramView, this.a.get("appPackageName").toString());
        break;
      }
      Toast.makeText(TrafficMonitorActivity.a.a(this.b), this.b.a.getString(R.string.traffic_app_unstall), 1).show();
      this.b.a.finish();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/monitor/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */