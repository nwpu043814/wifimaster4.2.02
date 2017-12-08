package com.lantern.wifilocating.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.lantern.wifilocating.push.h.d;
import java.util.Calendar;

public final class i
{
  private static Object a = new Object();
  
  public static int a(Context paramContext, String paramString, d paramd)
  {
    synchronized (a)
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("push_setting", 0);
      paramContext = new java/lang/StringBuilder;
      paramContext.<init>();
      int i = localSharedPreferences.getInt(paramd.a() + "_" + paramString, -1);
      return i;
    }
  }
  
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("push_noti_showing", 0).getString("push_msg", "");
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("push_noti_showing", 0).edit().putString("push_msg", paramString).commit();
  }
  
  public static void a(Context paramContext, String paramString, d paramd, int paramInt)
  {
    synchronized (a)
    {
      paramContext = paramContext.getSharedPreferences("push_setting", 0).edit();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      paramContext.putInt(paramd.a() + "_" + paramString, paramInt).commit();
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext.getSharedPreferences("push_setting", 0).edit().putString("push_server_info", paramString1 + "_dingwentao@wifikey_" + paramString2).commit();
  }
  
  public static String b(Context paramContext)
  {
    return paramContext.getSharedPreferences("push_setting", 0).getString("push_config", null);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("push_setting", 0).edit().putString("push_config", paramString).commit();
  }
  
  public static String c(Context paramContext)
  {
    return paramContext.getSharedPreferences("push_setting", 0).getString("push_option", null);
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("push_setting", 0).edit().putString("push_option", paramString).commit();
  }
  
  public static String d(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("push_setting", 0).getString("push_server_info", "");
    if (!TextUtils.isEmpty(paramContext))
    {
      paramContext = paramContext.split("_dingwentao@wifikey_");
      if ((paramContext == null) || (paramContext.length != 2) || (paramString == null) || (!paramString.equals(paramContext[0]))) {}
    }
    for (paramContext = paramContext[1];; paramContext = "") {
      return paramContext;
    }
  }
  
  public static boolean d(Context paramContext)
  {
    return paramContext.getSharedPreferences("push_setting_notification", 4).getBoolean("push_notification_enable", true);
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext.getSharedPreferences("push_setting_notification", 4).getBoolean("push_notification_night_enable", false))
    {
      int i = Calendar.getInstance().get(11);
      bool1 = bool2;
      if (i < 22) {
        if (i >= 8) {
          break label47;
        }
      }
    }
    label47:
    for (boolean bool1 = bool2;; bool1 = true) {
      return bool1;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */