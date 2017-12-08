package com.lantern.traffic.statistics.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.lantern.settings.R.id;

final class a
  implements View.OnClickListener
{
  a(TrafficStatisticsFragment paramTrafficStatisticsFragment) {}
  
  public final void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.getTrafficByDay)
    {
      TrafficStatisticsFragment.a(this.a, 1);
      TrafficStatisticsFragment.a(this.a).setTextColor(-16611856);
      TrafficStatisticsFragment.b(this.a).setTextColor(-3487030);
    }
    for (;;)
    {
      return;
      if (i == R.id.getTrafficByMonth)
      {
        TrafficStatisticsFragment.a(this.a, 2);
        TrafficStatisticsFragment.b(this.a).setTextColor(-16611856);
        TrafficStatisticsFragment.a(this.a).setTextColor(-3487030);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/statistics/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */