package com.lantern.settings.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View;
import bluefay.preference.CheckBoxPreference;
import bluefay.preference.Preference;
import bluefay.preference.PreferenceScreen;
import bluefay.preference.r;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.bluefay.preference.PSPreferenceFragment;
import com.lantern.analytics.a;
import com.lantern.core.b;
import com.lantern.core.config.ShareApNewConf;
import com.lantern.core.config.d;
import com.lantern.core.p;
import com.lantern.core.t;
import com.lantern.settings.R.xml;

public class SettingsFragment
  extends PSPreferenceFragment
{
  private CheckBoxPreference j;
  private CheckBoxPreference k;
  private CheckBoxPreference l;
  private CheckBoxPreference m;
  private CheckBoxPreference n;
  private CheckBoxPreference o;
  private CheckBoxPreference p;
  private CheckBoxPreference q;
  private CheckBoxPreference r;
  private boolean s = true;
  private boolean t = true;
  private String u;
  
  private boolean f()
  {
    boolean bool2 = false;
    String str = this.e.getPackageName();
    Object localObject = Settings.Secure.getString(this.e.getContentResolver(), "enabled_notification_listeners");
    boolean bool1 = bool2;
    String[] arrayOfString;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      arrayOfString = ((String)localObject).split(":");
    }
    for (int i = 0;; i++)
    {
      bool1 = bool2;
      if (i < arrayOfString.length)
      {
        localObject = ComponentName.unflattenFromString(arrayOfString[i]);
        if ((localObject != null) && (str.equals(((ComponentName)localObject).getPackageName()))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
    }
  }
  
  public final boolean a(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    if (this.j == paramPreference) {
      t.c(this.e, this.j.b());
    }
    for (;;)
    {
      return super.a(paramPreferenceScreen, paramPreference);
      if (this.l == paramPreference)
      {
        h.a("shareauto" + this.l.b(), new Object[0]);
        t.a(this.e, this.l.b());
        t.b(this.e, this.l.b());
      }
      else
      {
        boolean bool;
        if (this.o == paramPreference)
        {
          bool = this.o.b();
          this.e.getSharedPreferences("push_setting_notification", 4).edit().putBoolean("push_notification_enable", bool).commit();
          if (bool)
          {
            this.p.b(true);
            this.p.a(p.m(this.e));
          }
          else
          {
            this.p.b(false);
            this.p.a(false);
          }
        }
        else
        {
          Object localObject;
          if (this.p == paramPreference)
          {
            localObject = this.e;
            bool = this.p.b();
            ((Context)localObject).getSharedPreferences("push_setting_notification", 4).edit().putBoolean("push_notification_night_enable", bool).commit();
          }
          else if (this.q == paramPreference)
          {
            t.f(this.e, this.q.b());
          }
          else if (this.r == paramPreference)
          {
            localObject = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            ((Intent)localObject).addFlags(268435456);
            e.a(this.e, (Intent)localObject);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c().a("WkUserSettings");
    d(R.xml.settings_main);
    this.u = b.c();
    this.j = ((CheckBoxPreference)b("settings_pref_show_icon_notification"));
    this.k = ((CheckBoxPreference)b("settings_pref_remind_when_quit"));
    this.l = ((CheckBoxPreference)b("settings_pref_share_auto"));
    this.m = ((CheckBoxPreference)b("settings_pref_backup_auto"));
    this.n = ((CheckBoxPreference)b("settings_pref_check_version_startup"));
    this.o = ((CheckBoxPreference)b("settings_pref_new_message_tip"));
    this.p = ((CheckBoxPreference)b("settings_pref_new_message_night_tip"));
    this.q = ((CheckBoxPreference)b("settings_pref_nearbyap_notify_tip"));
    this.r = ((CheckBoxPreference)b("settings_pref_enable_notif"));
    if (t.b(this.e) == null) {
      t.b(this.e, t.a(this.e));
    }
    paramBundle = (ShareApNewConf)d.a(this.e).a(ShareApNewConf.class);
    boolean bool;
    if (paramBundle != null)
    {
      bool = paramBundle.i();
      this.s = bool;
      if (this.s) {
        break label414;
      }
      a(this.l);
      if (paramBundle == null) {
        break label409;
      }
      bool = paramBundle.j();
      label223:
      if (bool) {
        t.a(this.e, false);
      }
      label235:
      paramBundle = p.d(this.e, "").trim();
      if ((paramBundle.length() == 0) || ("a0000000000000000000000000000001".equals(paramBundle))) {
        break label451;
      }
      bool = true;
      label268:
      this.t = bool;
      if (!this.t) {
        a(this.m);
      }
      if ((!this.s) && (!this.t)) {
        a(b("backup_and_share_group"));
      }
      bool = this.e.getSharedPreferences("push_setting_notification", 4).getBoolean("push_notification_enable", true);
      this.o.a(bool);
      if (!bool) {
        break label456;
      }
      this.p.b(true);
      this.p.a(p.m(this.e));
    }
    for (;;)
    {
      if ("C".equals(this.u)) {
        a(this.q);
      }
      if (Build.VERSION.SDK_INT < 18) {
        a(this.r);
      }
      return;
      bool = true;
      break;
      label409:
      bool = false;
      break label223;
      label414:
      paramBundle = t.b(this.e);
      if (paramBundle == null) {
        break label235;
      }
      t.a(this.e, paramBundle.booleanValue());
      this.l.a(paramBundle.booleanValue());
      break label235;
      label451:
      bool = false;
      break label268;
      label456:
      this.p.b(false);
      this.p.a(false);
    }
  }
  
  public void onDestroyView()
  {
    a locala = a.e();
    if (this.j.b())
    {
      localObject = "asn1";
      locala.onEvent((String)localObject);
      locala = a.e();
      if (!this.k.b()) {
        break label278;
      }
      localObject = "asqn1";
      label41:
      locala.onEvent((String)localObject);
      if (this.s)
      {
        locala = a.e();
        if (!this.l.b()) {
          break label285;
        }
        localObject = "asautos1";
        label71:
        locala.onEvent((String)localObject);
      }
      if (this.t)
      {
        locala = a.e();
        if (!this.m.b()) {
          break label292;
        }
        localObject = "asautob1";
        label101:
        locala.onEvent((String)localObject);
      }
      locala = a.e();
      if (!this.n.b()) {
        break label299;
      }
      localObject = "asnver1";
      label124:
      locala.onEvent((String)localObject);
      locala = a.e();
      if (!this.o.b()) {
        break label306;
      }
      localObject = "asnnews1";
      label147:
      locala.onEvent((String)localObject);
      locala = a.e();
      if (!this.p.b()) {
        break label313;
      }
      localObject = "nighton";
      label170:
      locala.onEvent((String)localObject);
      if (!"C".equals(this.u))
      {
        locala = a.e();
        if (!this.q.b()) {
          break label320;
        }
        localObject = "nnon";
        label206:
        locala.onEvent((String)localObject);
      }
      localObject = (CheckBoxPreference)b("settings_pref_auto_enable_mobile");
      if (localObject != null)
      {
        locala = a.e();
        if (!((CheckBoxPreference)localObject).b()) {
          break label327;
        }
        localObject = "onsetcheck";
        label241:
        locala.onEvent((String)localObject);
      }
      locala = a.e();
      if (!f()) {
        break label334;
      }
    }
    label278:
    label285:
    label292:
    label299:
    label306:
    label313:
    label320:
    label327:
    label334:
    for (Object localObject = "wfnoshow2t";; localObject = "wfnoshow2f")
    {
      locala.onEvent((String)localObject);
      super.onDestroyView();
      return;
      localObject = "asn0";
      break;
      localObject = "asqn0";
      break label41;
      localObject = "asautos0";
      break label71;
      localObject = "asautob0";
      break label101;
      localObject = "asnver0";
      break label124;
      localObject = "asnnews0";
      break label147;
      localObject = "nightoff";
      break label170;
      localObject = "nnoff";
      break label206;
      localObject = "offsetcheck";
      break label241;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (Build.VERSION.SDK_INT >= 18)
    {
      if (!f()) {
        break label28;
      }
      this.r.a(true);
    }
    for (;;)
    {
      return;
      label28:
      this.r.a(false);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (paramView != null) {
      paramView.setBackgroundColor(Color.rgb(255, 255, 255));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/SettingsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */