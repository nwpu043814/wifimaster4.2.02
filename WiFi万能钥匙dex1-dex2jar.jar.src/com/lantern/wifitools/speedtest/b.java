package com.lantern.wifitools.speedtest;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.lantern.wifitools.R.color;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.string;
import com.lantern.wifitools.view.AnimTextView;
import com.lantern.wifitools.view.LoadingView;
import java.lang.ref.WeakReference;

public final class b
{
  private static boolean r;
  private Context a;
  private SpeedProgressBar b;
  private TextView c;
  private TextView d;
  private SpeedTestPoint e;
  private a f;
  private TextView g;
  private TextView h;
  private TextView i;
  private LoadingView j;
  private LoadingView k;
  private LoadingView l;
  private TextView m;
  private AnimTextView n;
  private int o;
  private int p;
  private boolean q;
  
  public b(Context paramContext, SpeedProgressBar paramSpeedProgressBar, SpeedTestPoint paramSpeedTestPoint, View paramView)
  {
    this.a = paramContext;
    this.b = paramSpeedProgressBar;
    this.c = ((TextView)paramView.findViewById(R.id.tv_network_speed));
    this.d = ((TextView)paramView.findViewById(R.id.unit));
    this.e = paramSpeedTestPoint;
    this.g = ((TextView)paramView.findViewById(R.id.delay_text));
    this.h = ((TextView)paramView.findViewById(R.id.max_text));
    this.i = ((TextView)paramView.findViewById(R.id.min_text));
    this.j = ((LoadingView)paramView.findViewById(R.id.delay_loading));
    this.k = ((LoadingView)paramView.findViewById(R.id.max_loading));
    this.l = ((LoadingView)paramView.findViewById(R.id.min_loading));
    this.m = ((TextView)paramView.findViewById(R.id.tv_network_test_btn));
    this.n = ((AnimTextView)paramView.findViewById(R.id.ping));
  }
  
  public static void a()
  {
    r = true;
  }
  
  public final void a(a parama)
  {
    this.f = parama;
  }
  
  public final void b()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      Toast.makeText(this.a, R.string.speed_test_nowifi, 0).show();
    }
    for (;;)
    {
      return;
      if (localNetworkInfo.getType() == 0)
      {
        Toast.makeText(this.a, this.a.getString(R.string.speed_mobile_warning), 0).show();
      }
      else
      {
        r = false;
        this.p = 0;
        this.o = 0;
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        this.g.setVisibility(8);
        this.q = true;
        this.j.a();
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.e.setVisibility(8);
        this.m.setText(this.a.getString(R.string.speed_test_delay));
        this.m.setTextColor(this.a.getResources().getColor(R.color.exam_gray));
        this.m.setBackgroundResource(17170445);
        this.m.setOnClickListener(null);
        this.n.a();
        this.b.a(this.c, this.d);
        new d(new b(this)).a();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  private static final class b
    extends Handler
  {
    WeakReference<b> a;
    
    public b(b paramb)
    {
      this.a = new WeakReference(paramb);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if ((this.a.get() != null) && (!b.c())) {
        b.a((b)this.a.get(), paramMessage);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/speedtest/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */