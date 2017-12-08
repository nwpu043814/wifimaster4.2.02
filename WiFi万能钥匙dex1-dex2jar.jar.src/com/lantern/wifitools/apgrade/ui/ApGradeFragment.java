package com.lantern.wifitools.apgrade.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import bluefay.app.Fragment;
import bluefay.app.u;
import com.bluefay.b.h;
import com.bluefay.material.f;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.core.p;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;
import com.lantern.wifitools.R.string;
import com.lantern.wifitools.apgrade.widget.ApGradeEditText;
import com.lantern.wifitools.apgrade.widget.ApGradeStarBigViewGroup;
import com.lantern.wifitools.apgrade.widget.ApGradeStarSmallViewGroup;

public class ApGradeFragment
  extends Fragment
{
  private View g;
  private f h;
  private String i;
  private String j;
  private String k;
  private ApGradeStarBigViewGroup l;
  private ApGradeStarSmallViewGroup m;
  private ApGradeEditText n;
  private ScrollView o;
  private TextView p;
  private TextView q;
  private boolean r = false;
  private LinearLayout s;
  private TextView t;
  private TextView u;
  private RelativeLayout v;
  private RelativeLayout w;
  
  private void a(com.lantern.wifitools.apgrade.b.a parama)
  {
    this.l.a(false);
    int i1 = a;
    u localu = new u(this.e);
    localu.add(10000, 1, 0, R.string.apgrade_submit);
    a(i1, localu);
    this.n.setVisibility(0);
    this.s.setVisibility(8);
    this.u.setVisibility(8);
    this.n.a(parama.d());
    this.o.postDelayed(new b(this), 100L);
  }
  
  private void a(boolean paramBoolean)
  {
    this.h = new f(getActivity());
    this.h.setCanceledOnTouchOutside(false);
    this.h.setOnCancelListener(new e(this, paramBoolean));
    this.h.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.a("onCreate", new Object[0]);
    paramBundle = getActivity().getIntent();
    if (paramBundle != null)
    {
      this.i = paramBundle.getStringExtra("ssid");
      this.j = paramBundle.getStringExtra("bssid");
      this.k = paramBundle.getStringExtra("address");
      if (TextUtils.isEmpty(this.k)) {
        this.k = getResources().getString(R.string.apgrade_tip_no_address);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    h.a("onCreateView", new Object[0]);
    a(R.string.apgrade_title);
    b().d(1);
    this.g = paramLayoutInflater.inflate(R.layout.wifitools_apgrade, paramViewGroup, false);
    return this.g;
  }
  
  public void onDetach()
  {
    this.r = true;
    super.onDetach();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    String str1;
    String str2;
    String str3;
    String str4;
    boolean bool;
    if (paramMenuItem.getItemId() == 1)
    {
      str1 = this.n.a().replace("\n", "").trim();
      str2 = this.l.a();
      str3 = p.d(this.e);
      str4 = p.e(this.e);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        com.bluefay.a.e.a(R.string.apgrade_tip_no_do);
        bool = false;
      }
    }
    for (;;)
    {
      return bool;
      if (str2.equals("0"))
      {
        com.bluefay.a.e.a(R.string.apgrade_tip_no_do);
        bool = false;
      }
      else
      {
        com.lantern.analytics.a.e().onEvent("aprate1");
        new com.lantern.wifitools.apgrade.c.a(this.i, this.j, str1, str2, str3, str4, new d(this, str1, str2)).execute(new String[0]);
        a(false);
        bool = super.onOptionsItemSelected(paramMenuItem);
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    h.a("onViewCreated", new Object[0]);
    this.l = ((ApGradeStarBigViewGroup)this.g.findViewById(R.id.apgrade_layout3));
    this.m = ((ApGradeStarSmallViewGroup)this.g.findViewById(R.id.small_stars));
    this.n = ((ApGradeEditText)this.g.findViewById(R.id.edit_layout));
    this.o = ((ScrollView)this.g.findViewById(R.id.scroll_layout));
    this.p = ((TextView)this.g.findViewById(R.id.ap_ssid));
    this.q = ((TextView)this.g.findViewById(R.id.ap_address));
    this.t = ((TextView)this.g.findViewById(R.id.apgrade_text));
    this.s = ((LinearLayout)this.g.findViewById(R.id.text_layout));
    this.u = ((TextView)this.g.findViewById(R.id.apgrade_again_text));
    this.v = ((RelativeLayout)this.g.findViewById(R.id.no_net_layout));
    this.w = ((RelativeLayout)this.g.findViewById(R.id.ap_layout));
    this.o.setVisibility(8);
    paramView = new com.lantern.wifitools.apgrade.c.b(this.i, this.j, new a(this));
    a(true);
    paramView.execute(new String[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/ui/ApGradeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */