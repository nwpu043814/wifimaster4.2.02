package com.alipay.b.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.alipay.c.a.a.a.a.b;
import com.alipay.c.a.a.d.d;
import java.util.UUID;

public class h
{
  private static String a = "";
  
  public static long a(Context paramContext)
  {
    long l2 = 86400000L;
    paramContext = com.alipay.c.a.a.d.a.a(paramContext, "vkeyid_settings", "update_time_interval");
    long l1 = l2;
    if (com.alipay.c.a.a.a.a.b(paramContext)) {}
    try
    {
      l1 = Long.parseLong(paramContext);
      return l1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, "update_time_interval", paramString);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    com.alipay.c.a.a.d.a.a(paramContext, "vkeyid_settings", "vkey_valid" + paramString, String.valueOf(paramLong));
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    com.alipay.c.a.a.d.a.a(paramContext, "vkeyid_settings", paramString1, paramString2);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      a(paramContext, "log_switch", str);
      return;
    }
  }
  
  public static String b(Context paramContext)
  {
    return com.alipay.c.a.a.d.a.a(paramContext, "vkeyid_settings", "last_machine_boot_time");
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, "last_machine_boot_time", paramString);
  }
  
  public static String c(Context paramContext)
  {
    return com.alipay.c.a.a.d.a.a(paramContext, "vkeyid_settings", "last_apdid_env");
  }
  
  public static void c(Context paramContext, String paramString)
  {
    a(paramContext, "last_apdid_env", paramString);
  }
  
  public static void d(Context paramContext, String paramString)
  {
    a(paramContext, "agent_switch", paramString);
  }
  
  public static boolean d(Context paramContext)
  {
    paramContext = com.alipay.c.a.a.d.a.a(paramContext, "vkeyid_settings", "log_switch");
    if ((paramContext != null) && ("1".equals(paramContext))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String e(Context paramContext)
  {
    return com.alipay.c.a.a.d.a.a(paramContext, "vkeyid_settings", "dynamic_key");
  }
  
  public static void e(Context paramContext, String paramString)
  {
    a(paramContext, "dynamic_key", paramString);
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      if (com.alipay.c.a.a.a.a.a(a))
      {
        String str = d.a(paramContext, "alipay_vkey_random", "random", "");
        a = str;
        if (com.alipay.c.a.a.a.a.a(str))
        {
          a = b.a(UUID.randomUUID().toString());
          str = a;
          if (str != null)
          {
            paramContext = paramContext.getSharedPreferences("alipay_vkey_random", 0).edit();
            if (paramContext != null)
            {
              paramContext.putString("random", str);
              paramContext.commit();
            }
          }
        }
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static void f(Context paramContext, String paramString)
  {
    a(paramContext, "webrtc_url", paramString);
  }
  
  public static long g(Context paramContext, String paramString)
  {
    l2 = 0L;
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("vkey_valid");
        paramContext = com.alipay.c.a.a.d.a.a(paramContext, "vkeyid_settings", paramString);
        if (!com.alipay.c.a.a.a.a.a(paramContext)) {
          continue;
        }
        l1 = l2;
      }
      catch (Throwable paramContext)
      {
        long l1 = l2;
        continue;
      }
      return l1;
      l1 = Long.parseLong(paramContext);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */