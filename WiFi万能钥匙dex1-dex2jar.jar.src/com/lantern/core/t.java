package com.lantern.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;

public final class t
{
  private static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("WkUserSettings", 0);
    if (paramContext != null) {
      paramContext.edit().putBoolean(paramString, paramBoolean).commit();
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, "settings_pref_share_auto", paramBoolean);
  }
  
  public static boolean a(Context paramContext)
  {
    return b(paramContext, "settings_pref_share_auto", false);
  }
  
  public static Boolean b(Context paramContext)
  {
    Object localObject = null;
    paramContext = paramContext.getSharedPreferences("WkUserSettings", 0);
    if (paramContext != null)
    {
      paramContext = paramContext.getString("settings_pref_user_share_auto", null);
      if (!TextUtils.isEmpty(paramContext)) {
        break label40;
      }
    }
    label40:
    for (paramContext = (Context)localObject;; paramContext = Boolean.valueOf(paramContext))
    {
      return paramContext;
      paramContext = null;
      break;
    }
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("WkUserSettings", 0);
    if (paramContext != null) {
      paramContext.edit().putString("settings_pref_user_share_auto", String.valueOf(paramBoolean)).commit();
    }
  }
  
  private static boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("WkUserSettings", 0);
    boolean bool = paramBoolean;
    if (paramContext != null) {
      bool = paramContext.getBoolean(paramString, paramBoolean);
    }
    return bool;
  }
  
  public static void c(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, "settings_pref_show_icon_notification", paramBoolean);
    paramContext = Message.obtain();
    if (paramBoolean) {}
    for (paramContext.what = 128031;; paramContext.what = 128032)
    {
      c.dispatch(paramContext);
      return;
    }
  }
  
  public static boolean c(Context paramContext)
  {
    return b(paramContext, "settings_pref_backup_auto", false);
  }
  
  public static void d(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, "settings_pref_remind_when_quit", paramBoolean);
  }
  
  public static boolean d(Context paramContext)
  {
    return b(paramContext, "settings_pref_show_icon_notification", true);
  }
  
  public static void e(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, "settings_pref_auto_enable_mobile", paramBoolean);
  }
  
  public static boolean e(Context paramContext)
  {
    return b(paramContext, "settings_pref_check_version_startup", true);
  }
  
  public static void f(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, "settings_pref_nearbyap_notify_tip", paramBoolean);
  }
  
  public static boolean f(Context paramContext)
  {
    return b(paramContext, "settings_pref_remind_when_quit", true);
  }
  
  public static boolean g(Context paramContext)
  {
    return b(paramContext, "settings_pref_auto_enable_mobile", false);
  }
  
  public static boolean h(Context paramContext)
  {
    return b(paramContext, "settings_pref_nearbyap_notify_tip", true);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */