package com.wifi.backup.a;

import com.lantern.core.model.WkAccessPoint;
import java.util.HashMap;

public final class a
{
  private static a a;
  private HashMap<WkAccessPoint, String> b = new HashMap();
  
  public static a b()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  public final HashMap<WkAccessPoint, String> a()
  {
    return this.b;
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint)
  {
    try
    {
      this.b.remove(paramWkAccessPoint);
      return;
    }
    finally {}
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint, String paramString)
  {
    try
    {
      this.b.put(paramWkAccessPoint, paramString);
      return;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */