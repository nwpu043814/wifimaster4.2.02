package com.wifipay.sdk.util;

import java.net.URLDecoder;

public class d
{
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (paramString1.length() != 0) {
        break label22;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label22:
      int i = paramString1.lastIndexOf("&");
      bool1 = bool2;
      if (paramString1.length() > i)
      {
        String str = paramString1.substring(0, i + 1);
        paramString1 = paramString1.substring(i + 1);
        try
        {
          bool1 = g.a(str.getBytes("UTF-8"), paramString2, URLDecoder.decode(paramString1, "UTF-8"));
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          bool1 = bool2;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */