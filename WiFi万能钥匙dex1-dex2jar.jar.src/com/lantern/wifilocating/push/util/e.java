package com.lantern.wifilocating.push.util;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.util.UUID;

public final class e
{
  private static String a;
  private static MessageDigest b = null;
  
  static
  {
    try
    {
      b = MessageDigest.getInstance("MD5");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        System.out.println(localException.getMessage());
      }
    }
  }
  
  private static String a()
  {
    try
    {
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("DWT").append(Build.BOARD).append(Build.BRAND).append(Build.CPU_ABI).append(Build.DEVICE).append(Build.DISPLAY).append(Build.HOST).append(Build.ID).append(Build.MANUFACTURER).append(Build.MODEL).append(Build.PRODUCT).append(Build.TAGS).append(Build.TYPE).append(Build.USER);
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        Object localObject2 = null;
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        paramContext = null;
      }
    }
  }
  
  private static String a(String paramString)
  {
    if (b != null)
    {
      byte[] arrayOfByte = b.digest(paramString.getBytes());
      paramString = new StringBuilder(40);
      int j = arrayOfByte.length;
      int i = 0;
      if (i < j)
      {
        int k = arrayOfByte[i];
        if ((k & 0xFF) >> 4 == 0) {
          paramString.append("0").append(Integer.toHexString(k & 0xFF));
        }
        for (;;)
        {
          i++;
          break;
          paramString.append(Integer.toHexString(k & 0xFF));
        }
      }
    }
    for (paramString = paramString.toString();; paramString = null) {
      return paramString;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    new f(paramContext, paramString).start();
  }
  
  private static String b(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        paramContext = null;
      }
    }
  }
  
  public static String b(Context paramContext, String paramString)
  {
    Object localObject2;
    if (TextUtils.isEmpty(a))
    {
      Object localObject1 = a(paramContext);
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = a();
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = b(paramContext);
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = j.b(j.f(paramContext));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label87;
      }
    }
    label87:
    for (paramContext = UUID.randomUUID().toString().replace("-", "");; paramContext = a((String)localObject2 + paramString))
    {
      a = paramContext;
      return a;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */