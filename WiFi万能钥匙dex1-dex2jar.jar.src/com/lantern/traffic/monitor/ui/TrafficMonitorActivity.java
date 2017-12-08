package com.lantern.traffic.monitor.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;
import com.qihoo.util.StubApp1053578832;
import java.util.ArrayList;
import java.util.HashMap;

public class TrafficMonitorActivity
  extends Activity
{
  private TextView a;
  private TextView b;
  private TextView c;
  private ListView d;
  private ArrayList<HashMap<String, Object>> e = new ArrayList();
  private PackageManager f;
  private Context g;
  private int h = 1;
  private com.lantern.traffic.monitor.b.a i;
  private String j = null;
  private Handler k = new c(this);
  
  static
  {
    StubApp1053578832.interface11(58);
  }
  
  private static boolean a(String paramString, Context paramContext)
  {
    boolean bool = false;
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 0);
      bool = true;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;) {}
    }
    return bool;
  }
  
  private Drawable b(String paramString)
  {
    try
    {
      paramString = this.f.getApplicationInfo(paramString, 0).loadIcon(this.f);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (!a(this.j, this))) {
      com.lantern.analytics.a.e().onEvent("m704_" + this.j);
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  private final class a
    extends BaseAdapter
  {
    private Context b;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public final int getCount()
    {
      return TrafficMonitorActivity.c(TrafficMonitorActivity.this).size();
    }
    
    public final Object getItem(int paramInt)
    {
      return TrafficMonitorActivity.c(TrafficMonitorActivity.this).get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      HashMap localHashMap = (HashMap)TrafficMonitorActivity.c(TrafficMonitorActivity.this).get(paramInt);
      if (paramView == null)
      {
        paramViewGroup = new TrafficMonitorActivity.b(TrafficMonitorActivity.this);
        paramView = LayoutInflater.from(this.b).inflate(R.layout.traffic_monitor_item, null);
        TrafficMonitorActivity.b.a(paramViewGroup, (TextView)paramView.findViewById(R.id.act_traffic_app_name_tv));
        TrafficMonitorActivity.b.b(paramViewGroup, (TextView)paramView.findViewById(R.id.act_traffic_info));
        TrafficMonitorActivity.b.a(paramViewGroup, (Button)paramView.findViewById(R.id.traffic_protect_btn));
        TrafficMonitorActivity.b.c(paramViewGroup, (TextView)paramView.findViewById(R.id.act_traffic_uninstall_tv));
        TrafficMonitorActivity.b.a(paramViewGroup, (ImageView)paramView.findViewById(R.id.act_traffic_app_ico_iv));
        TrafficMonitorActivity.b.a(paramViewGroup, (RelativeLayout)paramView.findViewById(R.id.act_traffic_bottom));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        TrafficMonitorActivity.b.a(paramViewGroup).getPaint().setFlags(8);
        TrafficMonitorActivity.b.b(paramViewGroup).setText(localHashMap.get("appName").toString());
        TrafficMonitorActivity.b.c(paramViewGroup).setText(TrafficMonitorActivity.this.getString(R.string.traffic_unusal_time) + TrafficMonitorActivity.a(localHashMap.get("startTime").toString()));
        TrafficMonitorActivity.b.d(paramViewGroup).setImageDrawable((Drawable)localHashMap.get("icon"));
        TrafficMonitorActivity.b.e(paramViewGroup).setOnClickListener(new d(this, localHashMap));
        TrafficMonitorActivity.b.f(paramViewGroup).setOnClickListener(new e(this, localHashMap));
        return paramView;
        paramViewGroup = (TrafficMonitorActivity.b)paramView.getTag();
      }
    }
  }
  
  public final class b
  {
    private TextView b;
    private TextView c;
    private TextView d;
    private Button e;
    private ImageView f;
    private RelativeLayout g;
    
    public b() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/monitor/ui/TrafficMonitorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */