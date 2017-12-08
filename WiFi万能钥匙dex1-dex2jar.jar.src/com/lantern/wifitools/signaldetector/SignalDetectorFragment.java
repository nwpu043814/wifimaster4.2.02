package com.lantern.wifitools.signaldetector;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bluefay.app.Fragment;
import com.bluefay.b.h;
import com.lantern.wifitools.R.drawable;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;
import com.lantern.wifitools.R.raw;
import com.lantern.wifitools.R.string;
import com.lantern.wifitools.a.g;
import com.lantern.wifitools.speedtest.SpeedTestPoint;

public class SignalDetectorFragment
  extends Fragment
{
  private WifiManager g;
  private MediaPlayer h;
  private TextView i;
  private TextView j;
  private TextView k;
  private SpeedTestPoint l;
  private SignalProgressBar m;
  private String n;
  private int o;
  private g p;
  private final IntentFilter q = new IntentFilter();
  private final BroadcastReceiver r;
  private WifiInfo s;
  private int t = Integer.MAX_VALUE;
  private final int u = -100;
  private final int v = -55;
  private final int w = 85;
  private View x;
  private Handler y = new b(this);
  
  public SignalDetectorFragment()
  {
    this.q.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    this.q.addAction("android.net.wifi.SCAN_RESULTS");
    this.q.addAction("android.net.wifi.RSSI_CHANGED");
    this.r = new a(this);
  }
  
  private void d(int paramInt)
  {
    int i1 = 0;
    if (paramInt == Integer.MAX_VALUE) {
      return;
    }
    h.a("updateSignal curRssi:" + paramInt, new Object[0]);
    if (this.t != Integer.MAX_VALUE)
    {
      if (paramInt <= this.t) {
        break label111;
      }
      if (this.h != null)
      {
        this.y.removeMessages(1);
        this.y.sendEmptyMessage(2);
      }
      label73:
      if (paramInt > -100) {
        break label138;
      }
      label79:
      this.m.b(i1);
      if (i1 < 85) {
        break label167;
      }
      this.k.setText(R.string.act_signal_detector_strong);
    }
    for (;;)
    {
      this.t = paramInt;
      break;
      label111:
      if (this.h == null) {
        break label73;
      }
      this.y.removeMessages(2);
      this.y.sendEmptyMessage(1);
      break label73;
      label138:
      if (paramInt >= -55)
      {
        i1 = 100;
        break label79;
      }
      i1 = (int)((paramInt + 100) * 100.0F / 45.0F);
      break label79;
      label167:
      this.k.setText(R.string.act_signal_detector_move_position_prompt);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a(R.string.act_signal_detector_title);
    this.i = ((TextView)this.x.findViewById(R.id.tv_ap_name));
    this.j = ((TextView)this.x.findViewById(R.id.tv_signal_value));
    this.k = ((TextView)this.x.findViewById(R.id.tv_move_position_prompt));
    this.l = ((SpeedTestPoint)this.x.findViewById(R.id.signalPoint));
    this.l.b(R.drawable.signal_check_pointer);
    this.m = ((SignalProgressBar)this.x.findViewById(R.id.signalprogressbar));
    this.m.a(this.l);
    this.m.a(this.j);
    this.m.b(-1);
    paramBundle = getActivity().getIntent().getExtras();
    if (paramBundle != null)
    {
      this.n = paramBundle.getString("ssid");
      this.o = paramBundle.getInt("networkId");
      int i1 = paramBundle.getInt("security");
      this.i.setText(this.n);
      if ((i1 == 3) && (this.n.startsWith(" 客人-"))) {
        this.n = this.n.substring(this.n.indexOf("-") + 1, this.n.length());
      }
    }
    this.p = g.a(getActivity().getApplication().getApplicationContext());
    this.g = ((WifiManager)getActivity().getSystemService("wifi"));
    com.lantern.analytics.a.e().onEvent("sgncli");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.x == null) {
      this.x = paramLayoutInflater.inflate(R.layout.wifitools_signal_detector, paramViewGroup, false);
    }
    return this.x;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.m != null) {
      this.m.a();
    }
    if (this.h != null) {
      this.h.release();
    }
    com.lantern.analytics.a.e().onEvent("sgnout");
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
  
  public void onPause()
  {
    super.onPause();
    getActivity().unregisterReceiver(this.r);
    if (this.h != null)
    {
      this.h.release();
      this.y.removeCallbacksAndMessages(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.h = MediaPlayer.create(getActivity(), R.raw.wifitools_pollux);
    if (this.h != null)
    {
      this.h.setAudioStreamType(3);
      this.h.setLooping(true);
    }
    getActivity().registerReceiver(this.r, this.q);
    try
    {
      g localg = this.p;
      localg.removeMessages(0);
      localg.sendEmptyMessage(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/signaldetector/SignalDetectorFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */