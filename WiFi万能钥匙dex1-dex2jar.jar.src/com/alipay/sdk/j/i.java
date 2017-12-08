package com.alipay.sdk.j;

import com.alipay.sdk.app.a.a;
import com.alipay.sdk.app.k;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  public static Map a(String paramString)
  {
    k localk = k.a(k.c.h);
    HashMap localHashMap = new HashMap();
    localHashMap.put("resultStatus", Integer.toString(localk.h));
    localHashMap.put("memo", localk.i);
    localHashMap.put("result", "");
    try
    {
      paramString = b(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        a.a("biz", "FormatResultEx", paramString);
        paramString = localHashMap;
      }
    }
  }
  
  private static Map b(String paramString)
  {
    String[] arrayOfString = paramString.split(";");
    paramString = new HashMap();
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++)
    {
      String str1 = arrayOfString[i];
      String str3 = str1.substring(0, str1.indexOf("={"));
      String str2 = str3 + "={";
      int k = str1.indexOf(str2);
      paramString.put(str3, str1.substring(str2.length() + k, str1.lastIndexOf("}")));
    }
    return paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/j/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */