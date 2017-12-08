package com.alipay.c.a.a.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.alipay.c.a.a.a.a;
import java.io.File;
import java.lang.reflect.Method;

public final class d
{
  private static d a = new d();
  
  public static d a()
  {
    return a;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      paramString2 = paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
    return paramString2;
  }
  
  public static boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if ((!Build.HARDWARE.contains("goldfish")) && (!Build.PRODUCT.contains("sdk")) && (!Build.FINGERPRINT.contains("generic"))) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramContext)
      {
        Object localObject;
        int j;
        int i;
        boolean bool = false;
        continue;
      }
      return bool;
      localObject = (TelephonyManager)paramContext.getSystemService("phone");
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId();
        if (localObject != null)
        {
          j = ((String)localObject).length();
          if (j != 0) {}
        }
        else
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          bool = true;
          continue;
        }
        i = 0;
        if (i < j)
        {
          if ((!Character.isWhitespace(((String)localObject).charAt(i))) && (((String)localObject).charAt(i) != '0'))
          {
            i = 0;
            continue;
          }
          i++;
          continue;
        }
        i = 1;
        continue;
      }
      bool = a.a(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
    }
  }
  
  public static String b()
  {
    return "android";
  }
  
  public static boolean c()
  {
    boolean bool1 = true;
    int i = 0;
    if (i < 5) {}
    for (;;)
    {
      try
      {
        File localFile = new java/io/File;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localFile.<init>(new String[] { "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/" }[i] + "su");
        boolean bool2 = localFile.exists();
        if (bool2) {
          return bool1;
        }
        i++;
      }
      catch (Exception localException) {}
      bool1 = false;
    }
  }
  
  public static String d()
  {
    return Build.BOARD;
  }
  
  public static String e()
  {
    return Build.BRAND;
  }
  
  public static String f()
  {
    return Build.DEVICE;
  }
  
  public static String g()
  {
    return Build.DISPLAY;
  }
  
  public static String h()
  {
    return Build.VERSION.INCREMENTAL;
  }
  
  public static String i()
  {
    return Build.MANUFACTURER;
  }
  
  public static String j()
  {
    return Build.MODEL;
  }
  
  public static String k()
  {
    return Build.PRODUCT;
  }
  
  public static String l()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String m()
  {
    return Build.VERSION.SDK;
  }
  
  public static String n()
  {
    return Build.TAGS;
  }
  
  public static String o()
  {
    return a("ro.kernel.qemu", "0");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */