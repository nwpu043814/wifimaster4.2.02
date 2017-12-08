package com.lantern.wifitools.apgrade.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
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
import com.bluefay.a.e;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.core.p;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;
import com.lantern.wifitools.R.string;
import com.lantern.wifitools.apgrade.widget.ApGradeEditText;
import com.lantern.wifitools.apgrade.widget.ApGradeStarBigViewGroup;
import com.lantern.wifitools.apgrade.widget.ApGradeStarSmallViewGroup;
import org.json.JSONObject;

public class ApGradeFragmentNew
  extends Fragment
{
  private View g;
  private com.bluefay.material.f h;
  private String i;
  private ApGradeStarBigViewGroup j;
  private ApGradeStarSmallViewGroup k;
  private ApGradeEditText l;
  private ScrollView m;
  private TextView n;
  private TextView o;
  private boolean p = false;
  private LinearLayout q;
  private TextView r;
  private TextView s;
  private RelativeLayout t;
  private RelativeLayout u;
  private String v;
  private String w;
  private com.lantern.wifitools.apgrade.b.a x;
  private String y;
  
  private void a(com.lantern.wifitools.apgrade.b.a parama)
  {
    this.j.a(false);
    int i1 = a;
    u localu = new u(this.e);
    localu.add(10000, 1, 0, R.string.apgrade_submit);
    a(i1, localu);
    this.l.setVisibility(0);
    this.q.setVisibility(8);
    this.s.setVisibility(8);
    this.l.a(parama.d());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.bluefay.b.h.a("onCreate", new Object[0]);
    paramBundle = getActivity().getIntent();
    if (paramBundle != null)
    {
      this.y = paramBundle.getStringExtra("callback");
      paramBundle = paramBundle.getStringExtra("ext");
    }
    try
    {
      Object localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(paramBundle);
      paramBundle = ((JSONObject)localObject).optString("comment");
      this.i = ((JSONObject)localObject).optString("address");
      String str1 = ((JSONObject)localObject).optString("score");
      this.v = ((JSONObject)localObject).optString("ssid");
      this.w = ((JSONObject)localObject).optString("bssid");
      String str2 = ((JSONObject)localObject).optString("star");
      localObject = new com/lantern/wifitools/apgrade/b/a;
      ((com.lantern.wifitools.apgrade.b.a)localObject).<init>();
      this.x = ((com.lantern.wifitools.apgrade.b.a)localObject);
      this.x.d(paramBundle);
      this.x.a(str1);
      this.x.a(Integer.parseInt(str2));
      if (TextUtils.isEmpty(this.i)) {
        this.i = getResources().getString(R.string.apgrade_tip_no_address);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        com.bluefay.b.h.c(paramBundle.getMessage());
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    com.bluefay.b.h.a("onCreateView", new Object[0]);
    a(R.string.apgrade_title);
    b().d(1);
    this.g = paramLayoutInflater.inflate(R.layout.wifitools_apgrade, paramViewGroup, false);
    return this.g;
  }
  
  public void onDetach()
  {
    this.p = true;
    super.onDetach();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    String str1;
    String str4;
    String str3;
    String str2;
    boolean bool;
    if (paramMenuItem.getItemId() == 1)
    {
      str1 = this.l.a().replace("\n", "").trim();
      str4 = this.j.a();
      str3 = p.d(this.e);
      str2 = p.e(this.e);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str4)))
      {
        e.a(R.string.apgrade_tip_no_do);
        bool = false;
      }
    }
    for (;;)
    {
      return bool;
      if (str4.equals("0"))
      {
        e.a(R.string.apgrade_tip_no_do);
        bool = false;
      }
      else
      {
        com.lantern.analytics.a.e().onEvent("apmark2");
        new com.lantern.wifitools.apgrade.c.a(this.v, this.w, str1, str4, str3, str2, new g(this, str1, str4)).execute(new String[0]);
        this.h = new com.bluefay.material.f(getActivity());
        this.h.setCanceledOnTouchOutside(false);
        this.h.setOnCancelListener(new h(this));
        this.h.show();
        bool = super.onOptionsItemSelected(paramMenuItem);
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    com.bluefay.b.h.a("onViewCreated", new Object[0]);
    this.j = ((ApGradeStarBigViewGroup)this.g.findViewById(R.id.apgrade_layout3));
    this.k = ((ApGradeStarSmallViewGroup)this.g.findViewById(R.id.small_stars));
    this.l = ((ApGradeEditText)this.g.findViewById(R.id.edit_layout));
    this.m = ((ScrollView)this.g.findViewById(R.id.scroll_layout));
    this.n = ((TextView)this.g.findViewById(R.id.ap_ssid));
    this.o = ((TextView)this.g.findViewById(R.id.ap_address));
    this.r = ((TextView)this.g.findViewById(R.id.apgrade_text));
    this.q = ((LinearLayout)this.g.findViewById(R.id.text_layout));
    this.s = ((TextView)this.g.findViewById(R.id.apgrade_again_text));
    this.t = ((RelativeLayout)this.g.findViewById(R.id.no_net_layout));
    this.u = ((RelativeLayout)this.g.findViewById(R.id.ap_layout));
    this.m.setVisibility(8);
    if (this.x != null)
    {
      paramView = this.x;
      this.m.setVisibility(0);
      if ((paramView != null) && (!TextUtils.isEmpty(paramView.a()))) {
        this.k.a(paramView.a());
      }
      this.n.setText(this.v);
      if (!TextUtils.isEmpty(this.i))
      {
        this.o.setVisibility(0);
        this.o.setText(this.i);
        if (paramView.c() != 0) {
          break label340;
        }
        this.j.a(5);
        label312:
        if (!TextUtils.isEmpty(paramView.d())) {
          break label354;
        }
        a(paramView);
      }
    }
    for (;;)
    {
      return;
      this.o.setVisibility(8);
      break;
      label340:
      this.j.a(paramView.c());
      break label312;
      label354:
      this.j.a(true);
      this.l.setVisibility(8);
      this.q.setVisibility(0);
      this.s.setVisibility(0);
      this.r.setText(paramView.d());
      this.s.setText(Html.fromHtml("<u>" + getString(R.string.apgrade_again) + "<u>"));
      this.s.setOnClickListener(new f(this, paramView));
      continue;
      if ((this.x != null) && (!TextUtils.isEmpty(this.x.b()))) {
        e.a(this.x.b());
      }
      this.m.setVisibility(0);
      this.u.setVisibility(8);
      this.t.setVisibility(0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/ui/ApGradeFragmentNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */