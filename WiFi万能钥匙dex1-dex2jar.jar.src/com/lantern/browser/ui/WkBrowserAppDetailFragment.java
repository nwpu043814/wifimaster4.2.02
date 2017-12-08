package com.lantern.browser.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import bluefay.app.u;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.string;
import com.lantern.browser.at;
import com.lantern.browser.g;
import com.lantern.browser.m;

public class WkBrowserAppDetailFragment
  extends WkBrowserFragment
{
  private g h;
  private String i;
  
  public final void a(String paramString)
  {
    if (this.g != null)
    {
      String str = "pst=" + System.currentTimeMillis();
      m.a().a(paramString, str);
      this.g.c(paramString);
    }
    this.i = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(true);
  }
  
  protected final Menu c()
  {
    u localu = new u(this.e);
    localu.add(1001, 10001, 0, "").setIcon(R.drawable.common_icon_title_more);
    localu.add(1001, 10002, 0, R.string.browser_btn_refresh).setIcon(R.drawable.browser_menu_refresh);
    localu.add(1001, 10007, 0, R.string.browser_btn_download).setIcon(R.drawable.browser_menu_download);
    return localu;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.h = ((g)getActivity());
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        h.a(paramActivity);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Intent localIntent = getActivity().getIntent();
    if (!TextUtils.isEmpty(this.i)) {}
    try
    {
      localIntent.setData(Uri.parse(this.i));
      this.g = ((at)super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
      paramLayoutInflater = "pst=" + System.currentTimeMillis();
      m.a().a("http://static.wkanx.com/bbx/v1/detail.html", paramLayoutInflater);
      return this.g;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localIntent.setData(Uri.parse("http://static.wkanx.com/bbx/v1/detail.html"));
      }
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean) {
      this.g.k();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = true;
    a.e().onEvent("bepcli");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      boolean bool1 = false;
      for (;;)
      {
        return bool1;
        a.e().onEvent("brfcli");
        paramMenuItem = "pst=" + System.currentTimeMillis();
        m.a().a(this.g.l(), paramMenuItem);
        this.g.f();
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (this.h != null)
        {
          this.h.a(this);
          bool1 = bool2;
        }
      }
      a.e().onEvent("bdlmgcli");
      paramMenuItem = new Intent("wifi.intent.action.DOWNLOADS_MAIN");
      paramMenuItem.setPackage(this.e.getPackageName());
      paramMenuItem.addFlags(268435456);
      this.e.startActivity(paramMenuItem);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/WkBrowserAppDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */