package com.wifi.connect.plugin.magickey.database;

import com.wifi.connect.plugin.magickey.b.b;
import java.util.HashMap;

public final class a
{
  private static a a;
  private HashMap<String, b> b = new HashMap();
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  public final void a(String paramString)
  {
    try
    {
      this.b.remove(paramString);
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, b paramb)
  {
    try
    {
      this.b.put(paramString, paramb);
      return;
    }
    finally {}
  }
  
  public final b b(String paramString)
  {
    try
    {
      paramString = (b)this.b.get(paramString);
      return paramString;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/database/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */