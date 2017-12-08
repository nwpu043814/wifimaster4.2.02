package com.lantern.wifitools.hotspot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.Fragment;
import bluefay.app.k.a;
import bluefay.app.u;
import com.bluefay.material.f;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;
import com.lantern.wifitools.R.string;

public class HotspotFragment
  extends Fragment
{
  private static boolean s;
  private static boolean t;
  public View.OnClickListener g = new b(this);
  private TextView h;
  private TextView i;
  private ImageView j;
  private CheckBox k;
  private WifiManager l;
  private k m;
  private f n;
  private WifiConfiguration o;
  private RelativeLayout p;
  private RelativeLayout q;
  private a r = new a();
  private BroadcastReceiver u = new a(this);
  
  private void c()
  {
    if (this.n != null)
    {
      this.n.hide();
      this.n.dismiss();
      this.n = null;
    }
  }
  
  private void d(int paramInt)
  {
    if (((bluefay.app.b)this.e).c()) {
      com.bluefay.b.h.c("Activity is not running");
    }
    for (;;)
    {
      return;
      c();
      k.a locala = new k.a(this.e);
      locala.a(R.string.hotspot_prompt_1);
      View localView = LayoutInflater.from(this.e).inflate(R.layout.wifitools_hotspot_fragment_dialog_mobile, null);
      ((TextView)localView.findViewById(R.id.wifihotspot_dialog_msg)).setText(paramInt);
      locala.a(localView);
      locala.a(R.string.wifitools_hotspot_openap_result, new e(this));
      locala.d();
      try
      {
        if (t) {
          this.l.setWifiEnabled(true);
        }
        if ((com.lantern.wifitools.a.h.b(this.e)) && (s))
        {
          com.lantern.wifitools.a.h.a(this.e, false);
          s = false;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(R.string.hotspot_activity_title);
    b().d(1);
    paramBundle = new u(this.e);
    a(a, paramBundle);
    if (!k.a())
    {
      Toast.makeText(this.e, R.string.hotspot_activity_not_support_prompt, 1).show();
      a();
    }
    for (;;)
    {
      paramBundle = new IntentFilter(k.f);
      paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.e.registerReceiver(this.u, paramBundle);
      return;
      this.l = ((WifiManager)this.e.getSystemService("wifi"));
      this.m = new k(this.l);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.wifitools_hotspot, null);
    this.k = ((CheckBox)paramLayoutInflater.findViewById(R.id.act_hotspot_ap_enable_checkbox));
    this.k.setChecked(this.m.d());
    this.h = ((TextView)paramLayoutInflater.findViewById(R.id.connect_hotspot_wifi_name));
    this.i = ((TextView)paramLayoutInflater.findViewById(R.id.connect_hotspot_wifi_pswd));
    this.j = ((ImageView)paramLayoutInflater.findViewById(R.id.connect_hotspot_wifi_status));
    this.p = ((RelativeLayout)paramLayoutInflater.findViewById(R.id.on_off_bar));
    this.q = ((RelativeLayout)paramLayoutInflater.findViewById(R.id.setting_bar));
    this.p.setOnClickListener(this.g);
    this.q.setOnClickListener(this.g);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.lantern.analytics.a locala = com.lantern.analytics.a.e();
    if (this.k.isChecked()) {}
    for (String str = "ph1";; str = "ph0")
    {
      locala.onEvent(str);
      this.e.unregisterReceiver(this.u);
      return;
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      a();
    }
  }
  
  public void onResume()
  {
    com.bluefay.b.h.a("----------------setHotspot--------------", new Object[0]);
    WifiConfiguration localWifiConfiguration = this.m.c();
    if (localWifiConfiguration != null)
    {
      this.h.setText(localWifiConfiguration.SSID);
      if ((localWifiConfiguration.preSharedKey != null) && (localWifiConfiguration.preSharedKey.length() != 0)) {
        this.i.setText(localWifiConfiguration.preSharedKey);
      }
    }
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  final class a
    extends Handler
  {
    a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/hotspot/HotspotFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */