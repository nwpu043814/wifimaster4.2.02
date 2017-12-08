package com.lantern.wifilocating.push.d;

import java.util.Map;

public final class c
{
  public static String a(String paramString, Map<String, String> paramMap)
  {
    paramString = new d(paramString);
    paramString.a("Content-Encoding", "gzip");
    return paramString.b(d.a(paramMap));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */