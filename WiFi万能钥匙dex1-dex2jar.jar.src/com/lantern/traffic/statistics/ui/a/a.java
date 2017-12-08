package com.lantern.traffic.statistics.ui.a;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantern.base.ui.b;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.traffic.statistics.b.c;
import java.text.NumberFormat;

public final class a
  extends b<c>
{
  private a a;
  private PackageManager b;
  private long c;
  private NumberFormat d;
  
  public a(Activity paramActivity)
  {
    super(paramActivity);
    this.b = paramActivity.getPackageManager();
    this.c = 0L;
    this.d = NumberFormat.getPercentInstance();
    this.d.setMinimumFractionDigits(0);
  }
  
  public final void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      this.a = new a((byte)0);
      paramView = a().inflate(R.layout.traffic_item_statistics, null);
      a.a(this.a, (ImageView)paramView.findViewById(R.id.appLogo));
      a.a(this.a, (TextView)paramView.findViewById(R.id.appName));
      a.b(this.a, (TextView)paramView.findViewById(R.id.trafficCount));
      a.c(this.a, (TextView)paramView.findViewById(R.id.trafficPercent));
      paramView.setTag(this.a);
    }
    for (;;)
    {
      c localc = (c)getItem(paramInt);
      try
      {
        paramViewGroup = this.b.getApplicationInfo(localc.b(), 0);
        if (paramViewGroup == null)
        {
          a.a(this.a).setText(localc.b());
          l = localc.d() + localc.e();
          if ((float)l <= 1.07374182E9F) {
            break label313;
          }
          a.c(this.a).setText(String.format("%.2fG", new Object[] { Float.valueOf((float)l / 1.07374182E9F) }));
          if (this.c != 0L) {
            break label347;
          }
          a.d(this.a).setText("0%");
          if (paramInt >= 3) {
            break label377;
          }
          a.d(this.a).setTextColor(-15498513);
          return paramView;
          this.a = ((a)paramView.getTag());
        }
      }
      catch (PackageManager.NameNotFoundException paramViewGroup)
      {
        for (;;)
        {
          long l;
          paramViewGroup.printStackTrace();
          paramViewGroup = null;
          continue;
          a.b(this.a).setImageDrawable(paramViewGroup.loadIcon(this.b));
          a.a(this.a).setText(paramViewGroup.loadLabel(this.b).toString());
          continue;
          label313:
          a.c(this.a).setText(String.format("%.2fM", new Object[] { Float.valueOf((float)l / 1048576.0F) }));
          continue;
          label347:
          a.d(this.a).setText(this.d.format((float)l / (float)this.c));
          continue;
          label377:
          a.d(this.a).setTextColor(-6513508);
        }
      }
    }
  }
  
  private final class a
  {
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;
    
    private a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/statistics/ui/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */