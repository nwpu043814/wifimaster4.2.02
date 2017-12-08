package com.wifi.connect;

import com.lantern.core.c;
import com.lantern.core.f;

public final class a
{
  public static String a()
  {
    String str = f.a(c.getAppContext()).a("aphost");
    if (str != null) {}
    for (str = String.format("%s%s", new Object[] { str, "/ap/fa.sec" });; str = String.format("%s%s", new Object[] { "http://ap.51y5.net", "/ap/fa.sec" })) {
      return str;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */