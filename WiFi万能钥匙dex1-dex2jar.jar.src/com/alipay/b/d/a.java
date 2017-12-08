package com.alipay.b.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static Map a(Context paramContext, Map paramMap)
  {
    try
    {
      String str = com.alipay.c.a.a.a.a.a(paramMap, "appchannel", "");
      paramMap = new java/util/HashMap;
      paramMap.<init>();
      paramMap.put("AA1", paramContext.getPackageName());
      com.alipay.c.a.a.b.a.a();
      paramMap.put("AA2", com.alipay.c.a.a.b.a.a(paramContext));
      paramMap.put("AA3", "security-sdk-token");
      paramMap.put("AA4", "3.2.2-20160830");
      paramMap.put("AA6", str);
      return paramMap;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */