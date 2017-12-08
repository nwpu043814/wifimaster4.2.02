package com.wifipay.wallet.home.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.framework.widget.WPImageView;
import com.wifipay.framework.widget.WPRelativeLayout;
import com.wifipay.framework.widget.WPTextView;
import com.wifipay.wallet.SecondLogin;
import com.wifipay.wallet.WalletApi;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.home.adapter.HomeGridAdapter;
import com.wifipay.wallet.home.adapter.HomeGridAdapter.onItemClickListener;
import com.wifipay.wallet.home.bean.Banner;
import com.wifipay.wallet.home.bean.SubApp;
import com.wifipay.wallet.home.net.dto.HomeInfoResp;
import com.wifipay.wallet.home.net.dto.HomeInfoResp.ResultObject;
import com.wifipay.wallet.home.setting.SettingActivity;
import com.wifipay.wallet.home.widget.BannerViewPager;
import com.wifipay.wallet.home.widget.ScrollGridView;
import com.wifipay.wallet.prod.core.model.WalletCard;
import com.wifipay.wallet.prod.security.query.WalletBalanceResp;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HomeActivity
  extends SuperActivity
  implements View.OnClickListener
{
  public ScrollGridView h;
  public HomeInfoResp i = null;
  public File j;
  public o k;
  public m l;
  private final int m = 1;
  private HomeGridAdapter n;
  private HomeGridAdapter o;
  private ScrollGridView p;
  private WPTextView q;
  private TextView r;
  private List<Banner> s = new ArrayList();
  private List<SubApp> t = new ArrayList();
  private List<SubApp> u = new ArrayList();
  private com.wifipay.wallet.home.a.a v;
  private int w;
  private RelativeLayout x;
  
  static
  {
    StubApp1053578832.interface11(124);
  }
  
  private void a(SubApp paramSubApp)
  {
    if ((com.wifipay.common.a.g.a(paramSubApp.type, "NATIVE_VIEW")) && (com.wifipay.wallet.common.utils.f.a(paramSubApp.link))) {
      paramSubApp = new Intent(paramSubApp.link);
    }
    try
    {
      startActivityForResult(paramSubApp, 1);
      return;
    }
    catch (Exception paramSubApp)
    {
      for (;;)
      {
        paramSubApp.printStackTrace();
      }
    }
  }
  
  private void a(HomeInfoResp.ResultObject paramResultObject)
  {
    if (com.wifipay.wallet.common.utils.f.a(paramResultObject.appName)) {
      this.r.setText(paramResultObject.appName);
    }
  }
  
  private void a(ArrayList<SubApp> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (com.wifipay.common.a.g.a(((SubApp)paramArrayList.next()).status, "2")) {
        paramArrayList.remove();
      }
    }
  }
  
  private void b(SubApp paramSubApp)
  {
    if ((com.wifipay.common.a.g.a(paramSubApp.type, "WEB")) && (!com.wifipay.common.a.g.a(paramSubApp.link))) {
      if (!com.wifipay.common.a.g.a(paramSubApp.h5Type))
      {
        if (com.wifipay.common.a.g.a(paramSubApp.h5Type, "WIFI_WEB")) {
          d(paramSubApp.link);
        }
        if (!com.wifipay.common.a.g.a(paramSubApp.h5Type, "LOCAL_WEB")) {}
      }
      else
      {
        HomeWebActivity.a(this, paramSubApp.link);
      }
    }
  }
  
  private void b(HomeInfoResp.ResultObject paramResultObject)
  {
    int i3 = 0;
    if ((com.wifipay.wallet.common.utils.f.a(paramResultObject.banners)) && (paramResultObject.banners.size() > 0))
    {
      this.s.clear();
      this.s.addAll(paramResultObject.banners);
      this.l.a();
      this.x.setVisibility(0);
    }
    while ((com.wifipay.wallet.common.utils.f.a(paramResultObject.subapps)) && (paramResultObject.subapps.size() > 0))
    {
      this.t.clear();
      this.u.clear();
      a(paramResultObject.subapps);
      if (paramResultObject.subapps.size() <= 6) {
        break label246;
      }
      this.h.setVisibility(0);
      this.p.setVisibility(0);
      int i1;
      for (int i2 = 0;; i2++)
      {
        i1 = i3;
        if (i2 >= 6) {
          break;
        }
        this.t.add(i2, paramResultObject.subapps.get(i2));
      }
      this.x.setVisibility(8);
      continue;
      while (i1 < paramResultObject.subapps.size() - 6)
      {
        this.u.add(i1, paramResultObject.subapps.get(i1 + 6));
        i1++;
      }
      this.n.a(this.t);
      this.o.a(this.u);
    }
    for (;;)
    {
      return;
      label246:
      this.p.setVisibility(8);
      this.t.addAll(paramResultObject.subapps);
      this.n.a(this.t);
    }
  }
  
  private void b(HomeInfoResp paramHomeInfoResp)
  {
    paramHomeInfoResp = paramHomeInfoResp.resultObject.subapps.iterator();
    while (paramHomeInfoResp.hasNext()) {
      if (com.wifipay.common.a.g.a(((SubApp)paramHomeInfoResp.next()).status, "3")) {
        paramHomeInfoResp.remove();
      }
    }
  }
  
  private void b(ArrayList<SubApp> paramArrayList)
  {
    label113:
    label219:
    for (this.w = 0;; this.w += 1)
    {
      String str1;
      String str2;
      if (this.w < paramArrayList.size())
      {
        if ((!com.wifipay.common.a.g.a(((SubApp)paramArrayList.get(this.w)).type, "LOCAL_FILE")) || (!com.wifipay.wallet.common.utils.f.a(((SubApp)paramArrayList.get(this.w)).downloadUrl))) {
          continue;
        }
        str1 = ((SubApp)paramArrayList.get(this.w)).id;
        str2 = ((SubApp)paramArrayList.get(this.w)).version;
        if (d((SubApp)paramArrayList.get(this.w))) {
          break label113;
        }
        c(paramArrayList);
      }
      for (;;)
      {
        return;
        if (!com.wifipay.wallet.common.utils.f.b(this.i)) {
          break;
        }
        c(paramArrayList);
      }
      for (int i1 = 0;; i1++)
      {
        if (i1 >= this.i.resultObject.subapps.size()) {
          break label219;
        }
        if ((com.wifipay.common.a.g.a(((SubApp)this.i.resultObject.subapps.get(i1)).id, str1)) && (!com.wifipay.common.a.g.a(((SubApp)this.i.resultObject.subapps.get(i1)).version, str2)))
        {
          c(paramArrayList);
          break;
        }
      }
    }
  }
  
  private void c(SubApp paramSubApp)
  {
    if (com.wifipay.common.a.g.a(paramSubApp.type, "LOCAL_FILE"))
    {
      if (!d(paramSubApp)) {
        break label29;
      }
      HomeWebActivity.b(this, paramSubApp.id);
    }
    for (;;)
    {
      return;
      label29:
      a(com.wifipay.common.a.f.a(R.string.wifipay_home_app_loading));
    }
  }
  
  private void c(HomeInfoResp.ResultObject paramResultObject)
  {
    if ((com.wifipay.wallet.common.utils.f.b(paramResultObject.banners)) || (com.wifipay.wallet.common.utils.f.b(paramResultObject.subapps))) {}
    for (;;)
    {
      return;
      Collections.sort(paramResultObject.subapps, new i(this));
      Collections.sort(paramResultObject.banners, new j(this));
    }
  }
  
  private void c(ArrayList<SubApp> paramArrayList)
  {
    BackgroundExecutor.a(new k(this, paramArrayList));
  }
  
  private boolean d(SubApp paramSubApp)
  {
    this.j = e(paramSubApp.id);
    return this.j.exists();
  }
  
  private String f(String paramString)
  {
    return "¥ " + paramString;
  }
  
  private void k()
  {
    WalletApi.init(this);
    a(8);
    setContentView(R.layout.wifipay_activity_home_main);
    this.k = new o(this);
    this.k.a();
    this.l = new m(this, this.s);
    this.h = ((ScrollGridView)findViewById(R.id.wifipay_home_gridview_above));
    this.p = ((ScrollGridView)findViewById(R.id.wifipay_home_gridview_below));
    this.n = new HomeGridAdapter(this, null);
    this.o = new HomeGridAdapter(this, null);
    this.h.setAdapter(this.n);
    this.n.a(new a(this.t));
    this.o.a(new a(this.u));
    this.p.setAdapter(this.o);
    this.q = ((WPTextView)findViewById(R.id.wifipay_home_title_back_text));
    WPRelativeLayout localWPRelativeLayout = (WPRelativeLayout)findViewById(R.id.wifipay_home_title_back);
    WPImageView localWPImageView = (WPImageView)findViewById(R.id.wifipay_home_title_setting);
    this.r = ((TextView)findViewById(R.id.wifipay_home_title_name));
    this.x = ((RelativeLayout)findViewById(R.id.wifipay_home_banner));
    localWPRelativeLayout.setOnClickListener(this);
    localWPImageView.setOnClickListener(this);
    if (com.wifipay.wallet.common.utils.f.b(this.v)) {
      this.v = new com.wifipay.wallet.home.a.a();
    }
    l();
    i();
  }
  
  private void l()
  {
    m();
    BackgroundExecutor.a(new e(this));
  }
  
  private void m()
  {
    String str2;
    if (com.wifipay.wallet.common.info.b.a().n())
    {
      str2 = com.wifipay.wallet.common.info.b.a().f();
      if (!com.wifipay.common.a.g.a(str2)) {
        break label24;
      }
    }
    for (;;)
    {
      return;
      label24:
      String str1 = str2;
      if (str2.contains("@")) {
        str1 = str2.substring(0, str2.indexOf("@"));
      }
      this.q.setText(str1.replace(str1.substring(3, 7), "****"));
    }
  }
  
  protected void a(Intent paramIntent)
  {
    new SecondLogin(this, paramIntent).a(null);
  }
  
  public void a(HomeInfoResp paramHomeInfoResp)
  {
    if (com.wifipay.wallet.common.utils.f.a(paramHomeInfoResp))
    {
      b(paramHomeInfoResp.resultObject);
      a(paramHomeInfoResp.resultObject);
    }
  }
  
  public File e(String paramString)
  {
    return new File(com.wifipay.wallet.home.a.b.a() + File.separator + paramString + File.separator + "desc", paramString + ".html");
  }
  
  protected void h()
  {
    com.wifipay.wallet.wifilogin.a.a.a();
    com.wifipay.wallet.common.a.b = false;
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleHomeInfo(HomeInfoResp paramHomeInfoResp)
  {
    if ((com.wifipay.wallet.common.utils.f.a(paramHomeInfoResp)) && (com.wifipay.common.a.g.a(ResponseCode.SUCCESS.getCode(), paramHomeInfoResp.resultCode)))
    {
      b(paramHomeInfoResp);
      c(paramHomeInfoResp.resultObject);
      BackgroundExecutor.a(new g(this, paramHomeInfoResp));
    }
    for (;;)
    {
      return;
      a(paramHomeInfoResp.resultMessage);
    }
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleWalletBalance(WalletBalanceResp paramWalletBalanceResp)
  {
    if ((ResponseCode.SUCCESS.getCode().equals(paramWalletBalanceResp.resultCode)) && (com.wifipay.wallet.common.utils.f.a(paramWalletBalanceResp.resultObject.availableBalance)) && (com.wifipay.wallet.common.utils.f.a(this.k)))
    {
      com.wifipay.wallet.common.info.b.a().a(paramWalletBalanceResp.resultObject.availableBalance);
      this.k.a.setText(f(paramWalletBalanceResp.resultObject.availableBalance));
    }
  }
  
  public void i()
  {
    if (!com.wifipay.wallet.common.info.b.a().n())
    {
      String str2 = com.wifipay.wallet.common.info.b.a().l();
      String str1 = com.wifipay.wallet.common.info.b.a().m();
      if ((!com.wifipay.wallet.common.utils.f.a(str2)) || (!com.wifipay.wallet.common.utils.f.a(str1))) {
        break label55;
      }
    }
    for (;;)
    {
      try
      {
        com.wifipay.wallet.openapi.a.a(this, 1, 1, "null");
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      label55:
      HashMap localHashMap = new HashMap();
      localHashMap.put("noLoginUser", "noLoginUser");
      com.wifipay.wallet.common.utils.a.a(this, "noLoginUserCount", localHashMap);
    }
  }
  
  public void j()
  {
    if (!com.wifipay.wallet.common.info.b.a().n()) {}
    for (;;)
    {
      return;
      String str = com.wifipay.wallet.common.info.b.a().o();
      if ((com.wifipay.wallet.common.utils.f.a(str)) && (com.wifipay.wallet.common.utils.f.a(this.k))) {
        this.k.a.setText(f(str));
      }
      BackgroundExecutor.a(new l(this));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      com.wifipay.wallet.common.a.b = true;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_home_title_back) {
      onBackPressed();
    }
    if (paramView.getId() == R.id.wifipay_home_title_setting)
    {
      if (com.wifipay.wallet.common.info.b.a().n()) {
        break label43;
      }
      com.wifipay.wallet.openapi.a.a(this, 1, 1, "设置");
    }
    for (;;)
    {
      return;
      label43:
      com.wifipay.wallet.common.utils.a.a(this, "设置");
      startActivityForResult(new Intent(this, SettingActivity.class), 1);
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 1) {
      if ((paramArrayOfInt[0] == 0) && (paramArrayOfInt[1] == 0) && (paramArrayOfInt[2] == 0)) {
        k();
      }
    }
    for (;;)
    {
      return;
      b(com.wifipay.common.a.f.a(R.string.wifipay_home_permission_error));
      continue;
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (com.wifipay.wallet.common.utils.f.a(this.l.c)) {
      this.l.c.b();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    m();
    j();
  }
  
  protected void onStop()
  {
    super.onStop();
    if (com.wifipay.wallet.common.utils.f.a(this.l.c)) {
      this.l.c.a();
    }
  }
  
  protected class a
    implements HomeGridAdapter.onItemClickListener
  {
    private List<SubApp> b;
    
    public a()
    {
      List localList;
      if (localList == null) {}
      for (this.b = new ArrayList();; this.b = localList)
      {
        return;
        if (com.wifipay.wallet.common.utils.f.a(this.b)) {
          this.b.clear();
        }
      }
    }
    
    public void onItemClick(View paramView, int paramInt)
    {
      if ((com.wifipay.wallet.common.utils.f.a(this.b)) && (this.b.size() > 0))
      {
        paramView = (SubApp)this.b.get(paramInt);
        if ((!com.wifipay.common.a.g.a("Y", paramView.isNeedLogin)) || (com.wifipay.wallet.common.info.b.a().n())) {
          break label71;
        }
        com.wifipay.wallet.openapi.a.a(HomeActivity.this, 1, 1, paramView.name);
      }
      for (;;)
      {
        return;
        label71:
        com.wifipay.wallet.common.utils.a.a(HomeActivity.this, paramView.name);
        HomeActivity.a(HomeActivity.this, paramView);
        HomeActivity.b(HomeActivity.this, paramView);
        HomeActivity.c(HomeActivity.this, paramView);
      }
    }
    
    public void onItemLongClick() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/HomeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */