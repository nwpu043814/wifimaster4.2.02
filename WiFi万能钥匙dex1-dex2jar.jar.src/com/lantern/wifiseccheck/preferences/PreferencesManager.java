package com.lantern.wifiseccheck.preferences;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferencesManager
{
  private static final String PREFS_NAME = "sec_check";
  private static PreferencesManager instance;
  private SharedPreferences prefs;
  
  private PreferencesManager(Application paramApplication)
  {
    this.prefs = paramApplication.getSharedPreferences("sec_check", 4);
  }
  
  public static PreferencesManager getInstance(Application paramApplication)
  {
    try
    {
      if (instance == null)
      {
        PreferencesManager localPreferencesManager = new com/lantern/wifiseccheck/preferences/PreferencesManager;
        localPreferencesManager.<init>(paramApplication);
        instance = localPreferencesManager;
      }
      return instance;
    }
    finally {}
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.prefs.getString(paramString1, paramString2);
  }
  
  public boolean setString(String paramString1, String paramString2)
  {
    return this.prefs.edit().putString(paramString1, paramString2).commit();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/preferences/PreferencesManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */