package com.lantern.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.bluefay.a.d;
import com.bluefay.b.b;
import java.io.File;

public final class p
  extends d
{
  public static long a(Context paramContext)
  {
    return a(paramContext, "sdk_common", "last_feed_recommend_reddot_show_time", 0L);
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    b(paramContext, "sdk_common", "last_feed_recommend_reddot_show_time", paramLong);
  }
  
  public static boolean a()
  {
    boolean bool = true;
    String str = a("sdk_device", "uhid", "");
    if ((str.length() == 0) || ("a0000000000000000000000000000001".equals(str))) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    return a(paramContext, "sdk_upgrade", "vercode", paramInt);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return b(paramContext, "sdk_device", "mobile", paramString);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    return a(paramContext, "sdk_upgrade", "has_upgrade", paramBoolean);
  }
  
  public static long b(Context paramContext)
  {
    return a(paramContext, "sdk_common", "last_feed_reddot_show_time", 0L);
  }
  
  static String b()
  {
    String str = k.m(c.getAppContext());
    Object localObject = ".wkcid";
    if (str != null) {
      localObject = ".wkcid" + str;
    }
    localObject = b.a(new File(Environment.getExternalStorageDirectory(), (String)localObject).getAbsolutePath());
    if (localObject != null)
    {
      str = n.c(new String((byte[])localObject), "YJm8T!uw2Wo^Yi80", "T9&m6OHpo%AYm$oM");
      localObject = str;
      if (TextUtils.isEmpty(str)) {}
    }
    for (localObject = str.trim();; localObject = "") {
      return (String)localObject;
    }
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return a(paramContext, "sdk_device", "dhid", paramString);
  }
  
  public static String b(String paramString)
  {
    return a("sdk_device", "dhid", paramString);
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    b(paramContext, "sdk_common", "last_feed_reddot_show_time", paramLong);
  }
  
  public static String c(Context paramContext)
  {
    return a(paramContext, "sdk_device", "mobile", "");
  }
  
  public static String c(String paramString)
  {
    String str = a("sdk_device", "uhid", paramString);
    if (str != null)
    {
      paramString = str;
      if (!str.equals("")) {}
    }
    else
    {
      paramString = "a0000000000000000000000000000001";
    }
    return paramString;
  }
  
  public static void c(Context paramContext, String paramString)
  {
    b(paramContext, "sdk_device", "dhid", paramString);
  }
  
  public static String d(Context paramContext)
  {
    return a(paramContext, "sdk_device", "nickname", null);
  }
  
  public static String d(Context paramContext, String paramString)
  {
    paramString = a(paramContext, "sdk_device", "uhid", paramString);
    if (paramString != null)
    {
      paramContext = paramString;
      if (!paramString.equals("")) {}
    }
    else
    {
      paramContext = "a0000000000000000000000000000001";
    }
    return paramContext;
  }
  
  public static String d(String paramString)
  {
    return a("sdk_device", "init_channel", paramString);
  }
  
  public static String e(Context paramContext)
  {
    return a(paramContext, "sdk_device", "avatar", null);
  }
  
  public static void e(Context paramContext, String paramString)
  {
    b(paramContext, "sdk_device", "uhid", paramString);
  }
  
  public static boolean e(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    Object localObject;
    for (boolean bool = false;; bool = b.a(((File)localObject).getAbsolutePath(), paramString.getBytes()))
    {
      return bool;
      String str = k.m(c.getAppContext());
      localObject = ".wkchannel";
      if (str != null) {
        localObject = ".wkchannel" + str;
      }
      localObject = new File(Environment.getExternalStorageDirectory(), (String)localObject);
      paramString = n.a(paramString, "YJm8T!uw2Wo^Yi80", "T9&m6OHpo%AYm$oM");
    }
  }
  
  public static String f(Context paramContext)
  {
    return a(paramContext, "sdk_device", "userToken", "");
  }
  
  public static boolean f(Context paramContext, String paramString)
  {
    return b(paramContext, "sdk_device", "init_channel", paramString);
  }
  
  public static void g(Context paramContext, String paramString)
  {
    b(paramContext, "sdk_device", "sessionid", paramString);
  }
  
  public static boolean g(Context paramContext)
  {
    return b(paramContext, "sdk_upgrade", "timestamp", System.currentTimeMillis());
  }
  
  public static int h(Context paramContext)
  {
    try
    {
      i = b(paramContext, "sdk_upgrade", "vercode");
      return i;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public static void h(Context paramContext, String paramString)
  {
    d(paramContext, "sdk_device", "simserialnumber", paramString);
  }
  
  public static void i(Context paramContext, String paramString)
  {
    b(paramContext, "sdk_device", "nickname", paramString);
  }
  
  public static boolean i(Context paramContext)
  {
    return b(paramContext, "sdk_device", "firststart", true);
  }
  
  public static String j(Context paramContext)
  {
    return c(paramContext, "sdk_device", "apk_start_date", "");
  }
  
  public static void j(Context paramContext, String paramString)
  {
    b(paramContext, "sdk_device", "gender", paramString);
  }
  
  public static void k(Context paramContext)
  {
    c(paramContext, "sdk_device", "connectshowhostguide", false);
  }
  
  public static void k(Context paramContext, String paramString)
  {
    b(paramContext, "sdk_device", "avatar", paramString);
  }
  
  public static long l(Context paramContext)
  {
    return a(paramContext, "sdk_common", "last_activity_time", 0L);
  }
  
  public static void l(Context paramContext, String paramString)
  {
    b(paramContext, "sdk_device", "userToken", paramString);
  }
  
  public static boolean m(Context paramContext)
  {
    return paramContext.getSharedPreferences("push_setting_notification", 4).getBoolean("push_notification_night_enable", false);
  }
  
  public static boolean m(Context paramContext, String paramString)
  {
    return b(paramContext, "sdk_upgrade", "channel", paramString);
  }
  
  public static void n(Context paramContext, String paramString)
  {
    d(paramContext, "sdk_device", "apk_start_date", paramString);
  }
  
  public static void o(Context paramContext, String paramString)
  {
    d(paramContext, "shopmsg", "msg", paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */