package com.wifipay.common.net.b.b;

import java.util.Map;

public class g
{
  public static String a(Map paramMap)
  {
    return a(paramMap, "ISO-8859-1");
  }
  
  public static String a(Map paramMap, String paramString)
  {
    Object localObject = (String)paramMap.get("Content-Type");
    paramMap = paramString;
    if (localObject != null) {
      localObject = ((String)localObject).split(";");
    }
    for (int i = 1;; i++)
    {
      paramMap = paramString;
      if (i < localObject.length)
      {
        paramMap = localObject[i].trim().split("=");
        if ((paramMap.length == 2) && (paramMap[0].equals("charset"))) {
          paramMap = paramMap[1];
        }
      }
      else
      {
        return paramMap;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */