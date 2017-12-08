package com.linksure.apservice.a;

import android.content.Context;
import com.lantern.core.c;
import com.lantern.core.f;

public final class e
{
  static String a = "http://wifiservice.51y5.net";
  static String b = a + "/serviceaccount/fa.sec";
  
  public static String a()
  {
    return a(c.getAppContext());
  }
  
  public static String a(Context paramContext)
  {
    paramContext = f.a(paramContext).a("apshost");
    if (paramContext != null) {}
    for (paramContext = String.format("%s%s", new Object[] { paramContext, "/serviceaccount/fa.sec" });; paramContext = String.format("%s%s", new Object[] { "http://wifiservice.51y5.net", "/serviceaccount/fa.sec" })) {
      return paramContext;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */