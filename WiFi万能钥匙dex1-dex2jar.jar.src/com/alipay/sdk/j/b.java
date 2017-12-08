package com.alipay.sdk.j;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;

public final class b
{
  private static b d = null;
  public String a;
  private String b;
  private String c;
  
  private b(Context paramContext)
  {
    try
    {
      Object localObject = (TelephonyManager)paramContext.getSystemService("phone");
      a(((TelephonyManager)localObject).getDeviceId());
      String str = ((TelephonyManager)localObject).getSubscriberId();
      localObject = str;
      if (str != null)
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        localObject = (str + "000000000000000").substring(0, 15);
      }
      this.b = ((String)localObject);
      this.a = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        if (TextUtils.isEmpty(this.a)) {
          this.a = "00:00:00:00:00:00";
        }
      }
    }
    finally
    {
      if (TextUtils.isEmpty(this.a)) {
        this.a = "00:00:00:00:00:00";
      }
    }
  }
  
  public static b a(Context paramContext)
  {
    if (d == null) {
      d = new b(paramContext);
    }
    return d;
  }
  
  private void a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      paramString = paramString.getBytes();
      for (int i = 0; i < paramString.length; i++) {
        if ((paramString[i] < 48) || (paramString[i] > 57)) {
          paramString[i] = 48;
        }
      }
      paramString = new String(paramString);
      str = (paramString + "000000000000000").substring(0, 15);
    }
    this.c = str;
  }
  
  public static d b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    for (;;)
    {
      try
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext == null) || (paramContext.getType() != 0)) {
          continue;
        }
        paramContext = d.a(paramContext.getSubtype());
      }
      catch (Exception paramContext)
      {
        paramContext = d.o;
        continue;
      }
      return paramContext;
      if ((paramContext != null) && (paramContext.getType() == 1)) {
        paramContext = d.a;
      } else {
        paramContext = d.o;
      }
    }
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = a(paramContext);
    paramContext = ((b)localObject).b();
    paramContext = paramContext + "|";
    localObject = ((b)localObject).a();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (paramContext = paramContext + "000000000000000";; paramContext = paramContext + (String)localObject) {
      return paramContext.substring(0, 8);
    }
  }
  
  public static String d(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramContext.getResources().getConfiguration().locale.toString();
      }
      catch (Throwable paramContext)
      {
        paramContext = "";
      }
    }
  }
  
  public final String a()
  {
    if (TextUtils.isEmpty(this.b)) {
      this.b = "000000000000000";
    }
    return this.b;
  }
  
  public final String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      this.c = "000000000000000";
    }
    return this.c;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/j/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */