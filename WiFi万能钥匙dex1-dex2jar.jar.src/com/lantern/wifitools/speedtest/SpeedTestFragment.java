package com.lantern.wifitools.speedtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.Fragment;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;
import com.lantern.wifitools.R.string;

public class SpeedTestFragment
  extends Fragment
{
  private TextView g;
  private SpeedTestPoint h;
  private SpeedProgressBar i;
  private b j;
  private boolean k = false;
  private View l;
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    int m;
    if (Build.VERSION.SDK_INT >= 8)
    {
      m = 1;
      if (m != 0) {
        break label47;
      }
      Toast.makeText(getActivity(), getString(R.string.act_lower_sdkversion), 1).show();
      a();
    }
    for (;;)
    {
      return;
      m = 0;
      break;
      label47:
      a(R.string.speed_test);
      this.g = ((TextView)this.l.findViewById(R.id.tv_network_ssid));
      this.i = ((SpeedProgressBar)this.l.findViewById(R.id.speedProgressBar));
      this.i.a(getArguments());
      this.h = ((SpeedTestPoint)this.l.findViewById(R.id.speedPoint));
      this.h.a((int)(getResources().getDisplayMetrics().density * 23.0F));
      paramBundle = getActivity().getIntent().getExtras();
      this.g.setText(paramBundle.getString("ssid"));
      this.j = new b(getActivity(), this.i, this.h, this.l);
      this.j.a(new a(this));
      paramBundle = ((ConnectivityManager)this.e.getSystemService("connectivity")).getNetworkInfo(1);
      if ((paramBundle != null) && (paramBundle.isConnected()))
      {
        if (!this.k)
        {
          this.k = true;
          this.j.b();
          com.lantern.analytics.a.e().onEvent("spdcli");
        }
      }
      else {
        Toast.makeText(this.e, R.string.speed_test_nowifi, 0).show();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.l == null) {
      this.l = paramLayoutInflater.inflate(R.layout.wifitools_speed_test, paramViewGroup, false);
    }
    return this.l;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b.a();
    this.i.a();
    com.lantern.analytics.a.e().onEvent("spdout");
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
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/speedtest/SpeedTestFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */