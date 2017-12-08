package com.lantern.settings.ui.developer;

import android.os.Bundle;
import bluefay.preference.Preference;
import bluefay.preference.PreferenceScreen;
import bluefay.preference.r;
import com.bluefay.a.e;
import com.bluefay.b.b;
import com.bluefay.preference.PSPreferenceFragment;
import com.lantern.analytics.a.a;
import com.lantern.core.c;
import com.lantern.settings.R.xml;
import java.io.File;

public class DeveloperFragment
  extends PSPreferenceFragment
{
  private Preference j;
  private Preference k;
  
  public final boolean a(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.j == paramPreference)
    {
      paramPreference = new a(this.e, null).a();
      bool1 = bool2;
      if (paramPreference != null)
      {
        int n = paramPreference.length;
        int m = paramPreference.length;
        for (int i = 0; i < m; i++)
        {
          paramPreferenceScreen = paramPreference[i];
          b.a(paramPreferenceScreen, new File(c.getAppExternalRootDir(), paramPreferenceScreen.getName()));
        }
        e.a("拷贝Crash日志数目:" + n);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (this.k != paramPreference) {
        bool1 = super.a(paramPreferenceScreen, paramPreference);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c().a("wifikey_developer");
    d(R.xml.settings_developer);
    this.j = b("settings_pref_copy_crash");
    this.k = b("settings_pref_upload_logcat");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/developer/DeveloperFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */