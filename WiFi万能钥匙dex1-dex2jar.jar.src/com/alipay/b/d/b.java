package com.alipay.b.d;

import android.content.Context;
import com.alipay.b.f.h;
import com.alipay.c.a.a.a.a;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  public static Map a(Context paramContext, Map paramMap)
  {
    try
    {
      HashMap localHashMap = new java/util/HashMap;
      localHashMap.<init>();
      String str1 = a.a(paramMap, "tid", "");
      String str5 = a.a(paramMap, "utdid", "");
      String str4 = a.a(paramMap, "userId", "");
      String str3 = a.a(paramMap, "appName", "");
      String str2 = a.a(paramMap, "appKeyClient", "");
      paramMap = a.a(paramMap, "tmxSessionId", "");
      paramContext = h.f(paramContext);
      localHashMap.put("AC1", str1);
      localHashMap.put("AC2", str5);
      localHashMap.put("AC3", "");
      localHashMap.put("AC4", paramContext);
      localHashMap.put("AC5", str4);
      localHashMap.put("AC6", paramMap);
      localHashMap.put("AC7", "");
      localHashMap.put("AC8", str3);
      localHashMap.put("AC9", str2);
      return localHashMap;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */