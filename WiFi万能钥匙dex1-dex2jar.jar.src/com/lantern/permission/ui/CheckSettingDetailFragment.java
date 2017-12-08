package com.lantern.permission.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import bluefay.app.Fragment;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;

public class CheckSettingDetailFragment
  extends Fragment
{
  private View g = null;
  private boolean h;
  private WebView i;
  private CheckSettingJsObject j;
  private int k;
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a(R.string.btn_back);
    this.i = ((WebView)this.g.findViewById(R.id.settings_permission_checking_webview_html));
    paramBundle = getActivity().getIntent().getBundleExtra("values");
    if (paramBundle != null)
    {
      String str = paramBundle.getString("html");
      int m = paramBundle.getInt("appName");
      if (TextUtils.isEmpty(str)) {
        a();
      }
      if (m == R.string.setting_xiaomi)
      {
        this.k = 1;
        this.j = new CheckSettingJsObject(getActivity());
        this.j.setSystemThpe(this.k);
        this.i.getSettings().setJavaScriptEnabled(true);
        this.i.addJavascriptInterface(this.j, "permission");
        this.i.loadUrl("file:///android_asset/html/" + str);
      }
    }
    for (;;)
    {
      return;
      this.k = -1;
      break;
      a();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.g == null) {
      this.g = paramLayoutInflater.inflate(R.layout.settings_permission_check_setting_detail, paramViewGroup, false);
    }
    return this.g;
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
    super.onResume();
    if ((!this.h) && (this.k == 1) && (a.a().f()) && (!CheckSettingChangedActivity.e))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(getActivity(), CheckSettingChangedActivity.class);
      startActivity(localIntent);
      a.a().g();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.h = false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/permission/ui/CheckSettingDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */