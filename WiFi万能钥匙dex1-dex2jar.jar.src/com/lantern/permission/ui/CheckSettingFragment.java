package com.lantern.permission.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import bluefay.app.Fragment;
import com.lantern.settings.R.array;
import com.lantern.settings.R.drawable;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckSettingFragment
  extends Fragment
  implements View.OnClickListener
{
  private static boolean A;
  private CheckSettingJsObject B;
  private int[][] C;
  private String[] D;
  private String[] E;
  private String F;
  private Context g;
  private TextView h;
  private TextView i;
  private TextView j;
  private ListView k;
  private List<Map> l = new ArrayList();
  private String m;
  private String n;
  private int o;
  private Map<String, Object> p;
  private View q;
  private LinearLayout r;
  private LinearLayout s;
  private LinearLayout t;
  private LinearLayout u;
  private LinearLayout v;
  private ScrollView w;
  private WebView x;
  private ImageView y;
  private ImageView z;
  
  public CheckSettingFragment()
  {
    int i5 = R.drawable.settings_permission_setting_mimi_ico;
    int i8 = R.string.setting_xiaomi;
    int[] arrayOfInt = { R.drawable.settings_permission_setting_huawei_ico, R.string.setting_huawei };
    int i2 = R.drawable.settings_permission_setting_samsung_ico;
    int i1 = R.string.setting_samsung;
    int i7 = R.drawable.settings_permission_setting_360_ico;
    int i6 = R.string.setting_360;
    int i3 = R.drawable.settings_permission_setting_baidu_ico;
    int i4 = R.string.setting_baidu;
    this.C = new int[][] { { i5, i8 }, arrayOfInt, { i2, i1 }, { i7, i6 }, { i3, i4 } };
    this.D = new String[] { "Xiaomi", "HUAWEI", "samsung" };
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.g = getActivity();
    a(R.string.frg_wifilist_btn_checksetting_wifi);
    this.h = ((TextView)this.q.findViewById(R.id.check_setting_dec_tv));
    this.i = ((TextView)this.q.findViewById(R.id.check_setting_all_tv));
    this.k = ((ListView)this.q.findViewById(R.id.check_setting_lv));
    this.r = ((LinearLayout)this.q.findViewById(R.id.settings_permission_checking_linerarlayout));
    this.s = ((LinearLayout)this.q.findViewById(R.id.settings_permission_checking_no_list_layout));
    this.t = ((LinearLayout)this.q.findViewById(R.id.settings_permisson_no_limit_lay));
    this.u = ((LinearLayout)this.q.findViewById(R.id.settings_permisson_is_has_systerm_layout));
    this.v = ((LinearLayout)this.q.findViewById(R.id.setting_permission_sys_app_layout));
    this.w = ((ScrollView)this.q.findViewById(R.id.settings_permission_checking_scrollview));
    this.x = ((WebView)this.q.findViewById(R.id.settings_permission_checking_webview_html));
    this.y = ((ImageView)this.q.findViewById(R.id.settings_permission_checking_ico));
    this.z = ((ImageView)this.q.findViewById(R.id.setting_permission_check_app_ico));
    this.j = ((TextView)this.q.findViewById(R.id.setting_permission__app_name));
    this.i.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.E = getResources().getStringArray(R.array.settings_permission_check_html);
    this.l.clear();
    int i1;
    if (a.a().b())
    {
      this.F = a.a().e();
      if (!TextUtils.isEmpty(this.F))
      {
        this.p = new HashMap();
        this.p.put("ico", Integer.valueOf(this.C[0][0]));
        this.p.put("name", Integer.valueOf(this.C[0][1]));
        this.p.put("html", this.E[0]);
        this.l.add(this.p);
        if ((!this.F.equals("V5")) && (!this.F.equals("V6")) && (!this.F.equals("V7"))) {
          break label1108;
        }
        this.B = new CheckSettingJsObject(getActivity());
        this.B.setSystemThpe(1);
        this.x.getSettings().setJavaScriptEnabled(true);
        this.x.addJavascriptInterface(this.B, "permission");
        i1 = 1;
      }
    }
    for (;;)
    {
      if (this.l.size() == 1)
      {
        a(R.string.btn_back);
        this.w.setVisibility(0);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.x.loadUrl("file:///android_asset/html/" + ((Map)this.l.get(0)).get("html"));
      }
      if (i1 == 0)
      {
        this.m = Build.MANUFACTURER;
        i1 = 0;
        label593:
        if (i1 >= this.D.length) {
          break label1197;
        }
        if ((TextUtils.isEmpty(this.m)) || (!this.m.equals(this.D[i1]))) {
          break label1113;
        }
        this.o = this.C[i1][1];
        this.n = this.E[i1];
        this.z.setBackgroundResource(this.C[i1][0]);
        this.j.setText(this.C[i1][1]);
      }
      label729:
      label1108:
      label1113:
      label1169:
      label1197:
      for (i1 = 1;; i1 = 0)
      {
        this.l.clear();
        if (i1 != 0)
        {
          this.h.setVisibility(8);
          this.y.setVisibility(8);
          this.u.setVisibility(0);
          this.t.setVisibility(0);
          a.a();
          if (a.d())
          {
            this.p = new HashMap();
            this.p.put("ico", Integer.valueOf(this.C[3][0]));
            this.p.put("name", Integer.valueOf(this.C[3][1]));
            this.p.put("html", this.E[3]);
            this.l.add(this.p);
          }
          a.a();
          if (a.c())
          {
            this.p = new HashMap();
            this.p.put("ico", Integer.valueOf(this.C[4][0]));
            this.p.put("name", Integer.valueOf(this.C[4][1]));
            this.p.put("html", this.E[4]);
            this.l.add(this.p);
          }
          if ((this.l.size() != 0) || (i1 != 0)) {
            break label1169;
          }
          this.w.setVisibility(8);
          this.r.setVisibility(8);
          this.s.setVisibility(0);
          this.t.setVisibility(8);
        }
        for (;;)
        {
          this.k.setAdapter(new a((byte)0));
          this.k.setOnItemClickListener(new e(this));
          return;
          this.p = new HashMap();
          this.p.put("ico", Integer.valueOf(this.C[2][0]));
          this.p.put("name", Integer.valueOf(this.C[2][1]));
          this.p.put("html", this.E[2]);
          this.l.add(this.p);
          i1 = 1;
          break;
          i1++;
          break label593;
          this.h.setText(getString(R.string.setting_check_bottom));
          this.h.setVisibility(0);
          this.y.setVisibility(0);
          this.t.setVisibility(0);
          this.u.setVisibility(8);
          break label729;
          if ((this.l.size() == 0) && (i1 != 0)) {
            this.t.setVisibility(8);
          }
        }
      }
      i1 = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.check_setting_all_tv) {
      CheckSettingAllActivity.a(getActivity());
    }
    for (;;)
    {
      return;
      if (paramView.getId() == R.id.setting_permission_sys_app_layout)
      {
        paramView = new Bundle();
        paramView.putString("html", this.n);
        paramView.putInt("appName", this.o);
        CheckSettingDetailActivity.a(this.g, paramView);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.q == null) {
      this.q = paramLayoutInflater.inflate(R.layout.settings_permission_check_setting, paramViewGroup, false);
    }
    return this.q;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
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
    if ((!A) && (!TextUtils.isEmpty(this.F)) && (a.a().f()) && (!CheckSettingChangedActivity.e))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(getActivity(), CheckSettingChangedActivity.class);
      startActivity(localIntent);
      a.a().g();
      A = true;
    }
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    A = false;
  }
  
  private final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return CheckSettingFragment.a(CheckSettingFragment.this).size();
    }
    
    public final Object getItem(int paramInt)
    {
      return CheckSettingFragment.a(CheckSettingFragment.this).get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Map localMap = (Map)CheckSettingFragment.a(CheckSettingFragment.this).get(paramInt);
      if (paramView == null)
      {
        paramView = LayoutInflater.from(CheckSettingFragment.b(CheckSettingFragment.this)).inflate(R.layout.settings_permission_check_setting_item, null);
        paramViewGroup = new a((byte)0);
        a.a(paramViewGroup, (TextView)paramView.findViewById(R.id.act_check_app_name));
        a.a(paramViewGroup, (ImageView)paramView.findViewById(R.id.act_check_app_ico));
        a.b(paramViewGroup, (ImageView)paramView.findViewById(R.id.setting_permission_list_hint));
        paramView.setTag(paramViewGroup);
        a.a(paramViewGroup).setText(Integer.parseInt(localMap.get("name").toString()));
        a.b(paramViewGroup).setBackgroundResource(Integer.parseInt(localMap.get("ico").toString()));
        if (paramInt + 1 != getCount()) {
          break label176;
        }
        a.c(paramViewGroup).setVisibility(8);
      }
      for (;;)
      {
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label176:
        a.c(paramViewGroup).setVisibility(0);
      }
    }
    
    private final class a
    {
      private TextView b;
      private ImageView c;
      private ImageView d;
      
      private a() {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/permission/ui/CheckSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */