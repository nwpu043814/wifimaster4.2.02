package com.lantern.wifilocating.push.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.lantern.wifilocating.push.e;
import com.lantern.wifilocating.push.f;
import com.lantern.wifilocating.push.service.SubPushService;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class j
{
  public static Intent a(Context paramContext, BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    try
    {
      paramContext = paramContext.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  public static String a()
  {
    String str = Locale.getDefault().getLanguage();
    if (TextUtils.isEmpty(str)) {
      str = "cn";
    }
    for (;;)
    {
      return str;
      if (str.equalsIgnoreCase("zh")) {
        str = "cn";
      } else {
        str = "en";
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramContext != null)
    {
      paramContext = b(paramContext);
      localObject1 = localObject2;
      if (paramContext != null)
      {
        localObject1 = localObject2;
        if (paramContext.isConnected())
        {
          if (paramContext.getType() != 1) {
            break label41;
          }
          localObject1 = "WIFI";
        }
      }
    }
    for (;;)
    {
      return (String)localObject1;
      label41:
      localObject1 = localObject2;
      if (paramContext.getType() == 0) {
        switch (paramContext.getSubtype())
        {
        default: 
          paramContext = paramContext.getSubtypeName();
          if ((!paramContext.equalsIgnoreCase("TD-SCDMA")) && (!paramContext.equalsIgnoreCase("WCDMA")))
          {
            localObject1 = paramContext;
            if (!paramContext.equalsIgnoreCase("CDMA2000")) {}
          }
          else
          {
            localObject1 = "3G";
          }
          break;
        case 1: 
        case 2: 
        case 4: 
        case 7: 
        case 11: 
          localObject1 = "2G";
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          localObject1 = "3G";
          break;
        case 13: 
          localObject1 = "4G";
        }
      }
    }
  }
  
  public static String a(e parame)
  {
    if (parame != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>();
        Object localObject = parame.a();
        if (localObject != null)
        {
          localJSONObject.put("p1", localObject);
          localObject = parame.d();
          if (localObject != null)
          {
            localJSONObject.put("p2", localObject);
            localObject = parame.e();
            if (localObject == null) {
              continue;
            }
            localJSONObject.put("p3", localObject);
            localObject = parame.f();
            if (localObject == null) {
              continue;
            }
            localJSONObject.put("p4", localObject);
            localObject = parame.b();
            if (localObject == null) {
              continue;
            }
            localJSONObject.put("p5", localObject);
            localObject = parame.c();
            if (localObject == null) {
              continue;
            }
            localJSONObject.put("p6", localObject);
            if (!(parame instanceof f)) {
              continue;
            }
            localObject = (f)parame;
            parame = ((f)localObject).g();
            if (parame == null) {
              continue;
            }
            localJSONObject.put("p7", parame);
            parame = ((f)localObject).h();
            if (parame == null) {
              continue;
            }
            localJSONObject.put("p8", parame);
            parame = localJSONObject.toString();
            return parame;
          }
        }
        else
        {
          localObject = "";
          continue;
        }
        localObject = "";
        continue;
        localObject = "";
        continue;
        localObject = "";
        continue;
        localObject = "";
        continue;
        localObject = "";
        continue;
        parame = "";
        continue;
        parame = "";
        continue;
        localJSONObject.put("p7", "");
        localJSONObject.put("p8", "");
        continue;
        parame = null;
      }
      catch (Exception parame)
      {
        h.a(parame);
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      str = URLDecoder.decode(paramString1, paramString2);
      return str;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        str = paramString1;
      }
    }
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      paramString = localJSONObject;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = paramString;
        paramString = null;
      }
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
    return paramString;
  }
  
  public static void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      paramContext.startActivity(paramIntent);
      for (;;)
      {
        return;
        if (paramInt != 1) {
          break;
        }
        paramContext.startService(paramIntent);
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        continue;
        if (paramInt == 2) {
          paramContext.sendBroadcast(paramIntent);
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString4))) {}
    for (;;)
    {
      return;
      new k(paramString1, paramString2, paramString3, paramString4, paramContext).start();
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      for (;;)
      {
        paramCloseable.printStackTrace();
      }
    }
  }
  
  public static void a(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (IOException paramSocket)
    {
      for (;;)
      {
        paramSocket.printStackTrace();
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            bool = ((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName.equals(paramString);
            if (!bool) {
              continue;
            }
            bool = true;
            return bool;
          }
        }
      }
      catch (Throwable paramContext)
      {
        h.a(paramContext);
      }
      boolean bool = false;
    }
  }
  
  public static NetworkInfo b(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null)
        {
          paramContext = paramContext.getActiveNetworkInfo();
          return paramContext;
        }
        paramContext = null;
        continue;
        paramContext = null;
      }
      catch (Throwable paramContext)
      {
        h.a(paramContext);
      }
    }
  }
  
  public static String b(String paramString)
  {
    String str;
    if (!"\000\000:\000\000:\000\000:\000\000:\000\000:\000\000".equals(paramString))
    {
      str = paramString;
      if (!"00:00:00:00:00:00".equals(paramString)) {}
    }
    else
    {
      str = "";
    }
    return str;
  }
  
  public static String c(String paramString)
  {
    int i = 0;
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      int j = paramString.length();
      str = paramString;
      if (j > 1)
      {
        str = paramString;
        if (paramString.charAt(0) == '"')
        {
          str = paramString;
          if (paramString.charAt(j - 1) == '"') {
            str = paramString.substring(1, j - 1);
          }
        }
      }
    }
    if ((TextUtils.isEmpty(str)) || (str.startsWith("0x")) || (str.startsWith("0X")) || (str.equalsIgnoreCase("<unknown ssid>")) || (str.equalsIgnoreCase("null"))) {
      i = 1;
    }
    if (i != 0) {}
    for (paramString = "";; paramString = str.replaceAll("\000|\001|\002|\003|\004|\005|\006|\007", "*")) {
      return paramString;
    }
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      paramContext = b(paramContext);
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.isConnectedOrConnecting()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static f d(String paramString)
  {
    localObject2 = null;
    localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        if (localJSONObject.length() != 0) {
          continue;
        }
        localObject1 = localObject2;
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        localObject1 = localObject2;
        continue;
      }
      return (f)localObject1;
      localObject1 = new com/lantern/wifilocating/push/f;
      ((f)localObject1).<init>();
      ((f)localObject1).a(localJSONObject.optString("p1"));
      ((f)localObject1).d(localJSONObject.optString("p2"));
      ((f)localObject1).e(localJSONObject.optString("p3"));
      ((f)localObject1).f(localJSONObject.optString("p4"));
      ((f)localObject1).b(localJSONObject.optString("p5"));
      ((f)localObject1).c(localJSONObject.optString("p6"));
      ((f)localObject1).g(localJSONObject.optString("p7"));
      ((f)localObject1).h(localJSONObject.optString("p8"));
    }
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool = true;
    if (paramContext != null)
    {
      paramContext = b(paramContext);
      if ((paramContext == null) || (paramContext.getType() != 1)) {}
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label27;
      }
      paramContext = paramContext.getDeviceId();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        label27:
        paramContext = "";
      }
    }
    return paramContext;
  }
  
  public static String f(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.getConnectionInfo();
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.getMacAddress();
      }
      catch (Exception paramContext)
      {
        h.a(paramContext);
        paramContext = "";
        continue;
      }
      return paramContext;
      paramContext = "";
    }
  }
  
  public static String g(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = b(paramContext);
      if (paramContext != null) {
        if (paramContext.getType() == 0) {
          paramContext = "g";
        }
      }
    }
    for (;;)
    {
      return paramContext;
      if (paramContext.getType() == 1) {
        paramContext = "w";
      } else {
        paramContext = "g";
      }
    }
  }
  
  public static String h(Context paramContext)
  {
    localObject = "";
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      if (str != null)
      {
        paramContext = str;
        localObject = str;
        if (str.length() > 0) {}
      }
      else
      {
        paramContext = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
    return paramContext;
  }
  
  public static int i(Context paramContext)
  {
    int j = -1;
    try
    {
      i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        int i = j;
      }
    }
  }
  
  public static String j(Context paramContext)
  {
    Object localObject1 = null;
    if (paramContext != null) {}
    try
    {
      String str2 = paramContext.getApplicationInfo().processName;
      localObject1 = str2;
      if (str2 == null) {
        localObject1 = paramContext.getPackageName();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        String str1 = paramContext.getPackageName();
      }
    }
    finally
    {
      paramContext.getPackageName();
    }
    return (String)localObject1;
  }
  
  public static void k(Context paramContext)
  {
    if ((!a(paramContext, paramContext.getPackageName())) && (n(paramContext))) {}
    try
    {
      Thread.sleep(1000L);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
      }
    }
  }
  
  public static boolean l(Context paramContext)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        String str = Settings.System.getString(paramContext.getContentResolver(), "disable_notification");
        if (str != null) {
          if (!str.equals("true"))
          {
            bool = str.equals("1");
            if (!bool) {}
          }
          else
          {
            bool = false;
            return bool;
          }
        }
      }
      catch (Throwable localThrowable) {}
    }
    for (;;)
    {
      try
      {
        h.a(localThrowable);
        Object localObject1 = paramContext.getSystemService("appops");
        Object localObject2 = paramContext.getApplicationInfo();
        paramContext = paramContext.getApplicationContext().getPackageName();
        int i = ((ApplicationInfo)localObject2).uid;
        Object localObject3 = Class.forName("android.app.AppOpsManager");
        localObject2 = ((Class)localObject3).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
        localObject3 = (Integer)((Class)localObject3).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
        if (localObject3 == null) {
          break label214;
        }
        paramContext = (Integer)((Method)localObject2).invoke(localObject1, new Object[] { Integer.valueOf(((Integer)localObject3).intValue()), Integer.valueOf(i), paramContext });
        if (paramContext != null)
        {
          i = paramContext.intValue();
          if (i == 0)
          {
            bool = true;
            break;
          }
          bool = false;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
      bool = true;
      break;
      label214:
      paramContext = null;
    }
  }
  
  public static boolean m(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (o(paramContext)) {
          continue;
        }
        bool = false;
      }
      catch (Throwable paramContext)
      {
        String str;
        h.a(paramContext);
        boolean bool = false;
        continue;
      }
      return bool;
      if (p(paramContext))
      {
        bool = false;
      }
      else
      {
        str = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName();
        if (str == null) {
          continue;
        }
        bool = str.equals(paramContext.getPackageName());
        if (!bool) {
          continue;
        }
        bool = true;
      }
    }
  }
  
  private static boolean n(Context paramContext)
  {
    try
    {
      Intent localIntent = new android/content/Intent;
      localIntent.<init>(paramContext, SubPushService.class);
      paramContext = paramContext.startService(localIntent);
      if (paramContext != null)
      {
        bool = true;
        return bool;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        paramContext = null;
        continue;
        boolean bool = false;
      }
    }
  }
  
  private static boolean o(Context paramContext)
  {
    try
    {
      bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        boolean bool = false;
      }
    }
  }
  
  private static boolean p(Context paramContext)
  {
    try
    {
      bool = ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      return bool;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        boolean bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */