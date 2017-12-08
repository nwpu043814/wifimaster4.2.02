package com.wifi.connect.a;

import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.model.e;
import java.util.HashMap;

public final class g
{
  private static g a;
  private HashMap<e, WkAccessPoint> b = new HashMap();
  
  public static g a()
  {
    if (a == null) {
      a = new g();
    }
    return a;
  }
  
  public final void a(String paramString, WkAccessPoint paramWkAccessPoint)
  {
    try
    {
      HashMap localHashMap = this.b;
      e locale = new com/wifi/connect/model/e;
      locale.<init>(paramString, paramWkAccessPoint.c);
      localHashMap.put(locale, paramWkAccessPoint);
      return;
    }
    finally {}
  }
  
  public final boolean a(WkAccessPoint paramWkAccessPoint)
  {
    try
    {
      HashMap localHashMap = this.b;
      e locale = new com/wifi/connect/model/e;
      locale.<init>(paramWkAccessPoint.a, paramWkAccessPoint.c);
      boolean bool = localHashMap.containsKey(locale);
      return bool;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */