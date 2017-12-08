package cm.pass.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class r
{
  public static boolean a = false;
  
  public static String a(Context paramContext)
  {
    Object localObject1 = s.a().a(paramContext);
    localObject1 = ((s.b)localObject1).g(((s.b)localObject1).f());
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = ((TelephonyManager)paramContext.getApplicationContext().getSystemService("phone")).getDeviceId();
    }
    for (;;)
    {
      String str = "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
      Object localObject2 = Settings.Secure.getString(paramContext.getApplicationContext().getContentResolver(), "android_id");
      paramContext = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
      str = (String)localObject1 + str + (String)localObject2 + paramContext;
      localObject2 = null;
      try
      {
        paramContext = MessageDigest.getInstance("MD5");
        localObject2 = paramContext;
      }
      catch (NoSuchAlgorithmException paramContext)
      {
        for (;;)
        {
          int i;
          paramContext.printStackTrace();
        }
        localObject1 = paramContext.toUpperCase();
      }
      paramContext = new String();
      localObject1 = paramContext;
      if (localObject2 != null)
      {
        ((MessageDigest)localObject2).update(str.getBytes(), 0, str.length());
        localObject2 = ((MessageDigest)localObject2).digest();
        for (i = 0; i < localObject2.length; i++)
        {
          int j = localObject2[i] & 0xFF;
          localObject1 = paramContext;
          if (j <= 15) {
            localObject1 = paramContext + "0";
          }
          paramContext = (String)localObject1 + Integer.toHexString(j);
        }
      }
      return (String)localObject1;
    }
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString.equals("3")) {
      str = "网关鉴权";
    }
    for (;;)
    {
      return str;
      if (paramString.equals("4"))
      {
        str = "短信上行鉴权";
      }
      else if (paramString.equals("2"))
      {
        str = "短信验证码登录";
      }
      else
      {
        str = paramString;
        if (paramString.equals("-1")) {
          str = "复用中间件登录";
        }
      }
    }
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static boolean a(ConnectivityManager paramConnectivityManager)
  {
    try
    {
      Method localMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      localMethod.setAccessible(true);
      bool = ((Boolean)localMethod.invoke(paramConnectivityManager, new Object[0])).booleanValue();
      paramConnectivityManager = new java/lang/StringBuilder;
      paramConnectivityManager.<init>("data is on ---------");
      j.c("TelephoneUtil", bool);
      return bool;
    }
    catch (Exception paramConnectivityManager)
    {
      for (;;)
      {
        j.a("TelephoneUtil", "data is on ----反射出错-----");
        paramConnectivityManager.printStackTrace();
        boolean bool = false;
      }
    }
  }
  
  public static int b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localConnectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
        paramContext = localConnectivityManager.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isAvailable())) {
          continue;
        }
        i = -1;
      }
      catch (Exception paramContext)
      {
        ConnectivityManager localConnectivityManager;
        int i = -1;
        continue;
      }
      return i;
      i = paramContext.getType();
      if (i == 1)
      {
        j.c("TelephoneUtil", "WIFI");
        if ((a(localConnectivityManager)) && (e.a))
        {
          a = true;
          j.c("TelephoneUtil", "流量数据 WIFI 同开");
          i = 3;
        }
        else
        {
          a = false;
          i = 2;
        }
      }
      else
      {
        if (i != 0) {
          continue;
        }
        j.c("TelephoneUtil", "流量");
        a = false;
        i = 3;
      }
    }
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool = false;
    try
    {
      paramContext = d(paramContext.getApplicationContext());
      if ("0" != paramContext) {
        bool = true;
      }
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return bool;
  }
  
  public static String d(Context paramContext)
  {
    if (Settings.System.getInt(paramContext.getApplicationContext().getContentResolver(), "airplane_mode_on", 0) == 1) {
      paramContext = "0";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        Object localObject = s.a().a(paramContext);
        String str = ((s.b)localObject).h(((s.b)localObject).f());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperator();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if ((((String)localObject).equals("46000")) || (((String)localObject).equals("46002")) || (((String)localObject).equals("46007")) || (((String)localObject).equals("46004")))
          {
            j.a("TelephoneUtil", "中国移动");
            paramContext = "1";
            continue;
          }
          if (("46001".equals(localObject)) || (((String)localObject).equals("46006")) || (((String)localObject).equals("46009")))
          {
            j.a("TelephoneUtil", "中国联通");
            paramContext = "2";
            continue;
          }
          if (("46003".equals(localObject)) || (((String)localObject).equals("46005")) || (((String)localObject).equals("46011")))
          {
            j.a("TelephoneUtil", "中国电信");
            paramContext = "3";
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext = "0";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */