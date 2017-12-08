package com.lantern.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import bluefay.preference.Preference;
import bluefay.preference.PreferenceScreen;
import com.bluefay.a.e;
import com.bluefay.preference.PSPreferenceFragment;
import com.lantern.analytics.a;
import com.lantern.settings.R.xml;

public class PluginFragment
  extends PSPreferenceFragment
{
  private Preference j;
  private Preference k;
  private Preference l;
  
  public final boolean a(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    boolean bool = true;
    if (paramPreference == this.j)
    {
      paramPreferenceScreen = new Intent("wifi.intent.action.HOTSPOT_MAIN");
      paramPreferenceScreen.setPackage(this.e.getPackageName());
      e.a(getActivity(), paramPreferenceScreen);
    }
    for (;;)
    {
      return bool;
      if (paramPreference == this.k)
      {
        paramPreferenceScreen = new Intent("wifi.intent.action.TRAFFIC_STATISTICS");
        paramPreferenceScreen.setPackage(this.e.getPackageName());
        e.a(getActivity(), paramPreferenceScreen);
        a.e().onEvent("datatraffic");
      }
      else if (paramPreference == this.l)
      {
        paramPreferenceScreen = new Intent("wifi.intent.action.DOWNLOADS_MAIN");
        paramPreferenceScreen.setPackage(this.e.getPackageName());
        e.a(getActivity(), paramPreferenceScreen);
        a.e().onEvent("downloadm");
      }
      else
      {
        bool = super.a(paramPreferenceScreen, paramPreference);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d(R.xml.settings_plugin);
    this.j = b("settings_pref_hotspot");
    this.k = b("settings_pref_traffic");
    this.l = b("settings_pref_dm");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/PluginFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */