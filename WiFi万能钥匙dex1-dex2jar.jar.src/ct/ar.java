package ct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

public final class ar
{
  private static ar a;
  
  private ar(Context paramContext)
  {
    paramContext.getApplicationContext();
  }
  
  public static ar a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null))
      {
        ar localar = new ct/ar;
        localar.<init>(paramContext.getApplicationContext());
        a = localar;
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static String a()
  {
    try
    {
      String str1 = Build.MODEL;
      return str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        String str2 = "null";
      }
    }
  }
  
  public static String b()
  {
    try
    {
      String str1 = Build.VERSION.RELEASE;
      return str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        String str2 = "null";
      }
    }
  }
  
  public static String b(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      paramContext = (Context)localObject;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
      }
    }
  }
  
  public static String c()
  {
    try
    {
      String str1 = Build.VERSION.SDK;
      return str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        String str2 = "null";
      }
    }
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      paramContext = (Context)localObject;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
      }
    }
  }
  
  public static String d()
  {
    Object localObject = null;
    try
    {
      String str = Build.BRAND;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    return (String)localObject;
  }
  
  public static String d(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      paramContext = (Context)localObject;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static String e(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    String str = "unknown";
    for (;;)
    {
      try
      {
        localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null)
        {
          paramContext = str;
          return paramContext;
        }
        if (localNetworkInfo.getType() == 1)
        {
          paramContext = "wifi";
          continue;
        }
      }
      catch (Exception paramContext)
      {
        NetworkInfo localNetworkInfo;
        paramContext.printStackTrace();
        paramContext = "unknown";
        continue;
      }
      if (localNetworkInfo.getType() != 0) {
        continue;
      }
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        continue;
      }
      switch (paramContext.getNetworkType())
      {
      default: 
        paramContext = "unknown";
        break;
      case 1: 
        paramContext = "GPRS";
        break;
      case 2: 
        paramContext = "EDGE";
        break;
      case 3: 
        paramContext = "UMTS";
        break;
      case 8: 
        paramContext = "HSDPA";
        break;
      case 9: 
        paramContext = "HSUPA";
        break;
      case 10: 
        paramContext = "HSPA";
        break;
      case 4: 
        paramContext = "CDMA";
        break;
      case 5: 
        paramContext = "EVDO_0";
        break;
      case 6: 
        paramContext = "EVDO_A";
        break;
      case 7: 
        paramContext = "1xRTT";
        break;
      case 11: 
        paramContext = "iDen";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */