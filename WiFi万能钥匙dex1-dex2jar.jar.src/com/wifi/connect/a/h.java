package com.wifi.connect.a;

import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.model.WebAuthAp;
import com.wifi.connect.model.e;
import java.util.HashMap;

public final class h
{
  private static h a;
  private HashMap<e, WebAuthAp> b = new HashMap();
  
  public static h a()
  {
    if (a == null) {
      a = new h();
    }
    return a;
  }
  
  public final WebAuthAp a(WkAccessPoint paramWkAccessPoint)
  {
    try
    {
      HashMap localHashMap = this.b;
      e locale = new com/wifi/connect/model/e;
      locale.<init>(paramWkAccessPoint.a, paramWkAccessPoint.c);
      paramWkAccessPoint = (WebAuthAp)localHashMap.get(locale);
      return paramWkAccessPoint;
    }
    finally {}
  }
  
  public final void a(String paramString, WebAuthAp paramWebAuthAp)
  {
    try
    {
      HashMap localHashMap = this.b;
      e locale = new com/wifi/connect/model/e;
      locale.<init>(paramString, paramWebAuthAp.c);
      localHashMap.put(locale, paramWebAuthAp);
      return;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */