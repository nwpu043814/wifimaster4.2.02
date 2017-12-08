package com.lantern.browser.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import bluefay.app.u;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.analytics.a;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.string;
import com.lantern.browser.at;
import com.lantern.browser.g;
import com.lantern.browser.m;

public class WkBrowserAppStoreFragment
  extends WkBrowserFragment
{
  private g h;
  
  public final boolean b(String paramString)
  {
    if (this.h != null) {
      this.h.a(this, paramString);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected final Menu c()
  {
    Object localObject = b();
    if (localObject != null) {
      ((ActionTopBarView)localObject).d(2);
    }
    localObject = new u(this.e);
    ((Menu)localObject).add(1002, 10002, 0, R.string.browser_btn_refresh).setIcon(R.drawable.browser_menu_refresh_white);
    ((Menu)localObject).add(1003, 10007, 0, R.string.browser_btn_download).setIcon(R.drawable.browser_menu_download_white);
    return (Menu)localObject;
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
    this.g = ((at)super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
    paramLayoutInflater = "pst=" + System.currentTimeMillis();
    m.a().a("http://static.wkanx.com/bbx/v1/index.html", paramLayoutInflater);
    return this.g;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean)
    {
      a(this.g.m());
      b().c(8);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    a.e().onEvent("bepcli");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      bool = false;
      for (;;)
      {
        return bool;
        a.e().onEvent("brfcli");
        paramMenuItem = "pst=" + System.currentTimeMillis();
        m.a().a(this.g.l(), paramMenuItem);
        if (!e.c(this.e)) {
          e.a(R.string.browser_network_error);
        }
        this.g.f();
        continue;
        this.g.e();
        continue;
        this.g.g();
      }
      a.e().onEvent("bdlmgcli");
      paramMenuItem = new Intent("wifi.intent.action.DOWNLOADS_MAIN");
      paramMenuItem.setPackage(this.e.getPackageName());
      paramMenuItem.addFlags(268435456);
      this.e.startActivity(paramMenuItem);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/WkBrowserAppStoreFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */