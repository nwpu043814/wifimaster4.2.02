package com.wifi.connect.a;

import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.model.PluginAp;
import com.wifi.connect.model.e;
import java.util.HashMap;

public final class f
{
  private static f a;
  private HashMap<e, PluginAp> b = new HashMap();
  
  public static f a()
  {
    if (a == null) {
      a = new f();
    }
    return a;
  }
  
  public final PluginAp a(WkAccessPoint paramWkAccessPoint)
  {
    try
    {
      HashMap localHashMap = this.b;
      e locale = new com/wifi/connect/model/e;
      locale.<init>(paramWkAccessPoint.a, paramWkAccessPoint.c);
      paramWkAccessPoint = (PluginAp)localHashMap.get(locale);
      return paramWkAccessPoint;
    }
    finally {}
  }
  
  public final void a(String paramString, PluginAp paramPluginAp)
  {
    try
    {
      HashMap localHashMap = this.b;
      e locale = new com/wifi/connect/model/e;
      locale.<init>(paramString, paramPluginAp.c);
      localHashMap.put(locale, paramPluginAp);
      return;
    }
    finally {}
  }
  
  public final boolean b(WkAccessPoint paramWkAccessPoint)
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */