package com.lantern.settings.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;

final class g
  implements View.OnClickListener
{
  g(DefaultSettingsFragment paramDefaultSettingsFragment) {}
  
  public final void onClick(View paramView)
  {
    a.e().onEvent("wfmshow2");
    Context localContext = DefaultSettingsFragment.a(this.a);
    PackageManager localPackageManager = localContext.getPackageManager();
    paramView = new ComponentName(localContext.getPackageName(), "com.lantern.settings.ui.DefaultSettings");
    localPackageManager.setComponentEnabledSetting(paramView, 1, 1);
    Intent localIntent = new Intent("android.settings.WIFI_SETTINGS");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localContext.startActivity(localIntent);
    localPackageManager.setComponentEnabledSetting(paramView, 0, 1);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */