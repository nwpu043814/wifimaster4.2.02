package com.lantern.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import bluefay.preference.Preference;
import bluefay.preference.PreferenceScreen;
import com.bluefay.a.c;
import com.bluefay.preference.PSPreferenceFragment;
import com.lantern.settings.R.string;
import com.lantern.settings.R.xml;
import com.lantern.settings.widget.ProtocalPreference;

public class AboutFragment
  extends PSPreferenceFragment
{
  private final String j = "setting_pref_appinfo";
  private final String k = "setting_pref_ptotocal";
  private final String l = "V ";
  private ProtocalPreference m;
  private Preference n;
  private Preference o;
  
  public final boolean a(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    if (this.o == paramPreference)
    {
      com.lantern.analytics.a.e().onEvent("instruction");
      Object localObject = getResources().getString(R.string.settings_web_product_introduct_file_name);
      localObject = new Intent("wifi.intent.action.BROWSER", Uri.parse("file:///android_asset/html/" + (String)localObject));
      ((Intent)localObject).setPackage(this.e.getPackageName());
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("showoptionmenu", false);
      ((Intent)localObject).putExtras(localBundle);
      this.e.startActivity((Intent)localObject);
    }
    for (;;)
    {
      return super.a(paramPreferenceScreen, paramPreference);
      if (this.n == paramPreference) {
        com.lantern.analytics.a.e().onEvent("faq");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d(R.xml.settings_about);
    this.n = b("settings_pref_fqa");
    this.o = b("settings_pref_product_introduct");
    this.m = ((ProtocalPreference)b("setting_pref_ptotocal"));
    if (this.m != null) {
      this.m.a(new a(this));
    }
    paramBundle = c.a(this.e);
    AppInfoPreference localAppInfoPreference = (AppInfoPreference)b("setting_pref_appinfo");
    if ((localAppInfoPreference != null) && (paramBundle != null)) {
      localAppInfoPreference.a("V " + paramBundle);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/AboutFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */