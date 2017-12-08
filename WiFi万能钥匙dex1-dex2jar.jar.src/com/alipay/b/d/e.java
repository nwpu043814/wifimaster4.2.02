package com.alipay.b.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class e
{
  private static Map a = null;
  private static final String[] b = { "AD1", "AD2", "AD3", "AD5", "AD6", "AD7", "AD8", "AD9", "AD10", "AD11", "AD12", "AD13", "AD14", "AD15", "AD16", "AD18", "AD20", "AD21", "AD23", "AD24", "AD26", "AD27", "AD28", "AD29", "AD30", "AD31", "AD34", "AA1", "AA2", "AA3", "AA4", "AA5", "AC4", "AE1", "AE2", "AE3", "AE4", "AE5", "AE6", "AE7", "AE8", "AE9", "AE10", "AE11", "AE12", "AE13", "AE14", "AE15" };
  
  private static String a(Map paramMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(paramMap.keySet());
    Collections.sort(localArrayList);
    int i = 0;
    if (i < localArrayList.size())
    {
      String str3 = (String)localArrayList.get(i);
      String str2 = (String)paramMap.get(str3);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (i == 0) {}
      for (str2 = "";; str2 = "&")
      {
        localStringBuffer.append(str2 + str3 + "=" + str1);
        i++;
        break;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static Map a(Context paramContext, Map paramMap)
  {
    try
    {
      if (a == null) {
        c(paramContext, paramMap);
      }
      a.putAll(d.a());
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String b(Context paramContext, Map paramMap)
  {
    try
    {
      a(paramContext, paramMap);
      paramContext = new java/util/TreeMap;
      paramContext.<init>();
      for (paramMap : b) {
        if (a.containsKey(paramMap)) {
          paramContext.put(paramMap, a.get(paramMap));
        }
      }
      paramContext = com.alipay.c.a.a.a.a.b.a(a(paramContext));
      return paramContext;
    }
    finally {}
  }
  
  private static void c(Context paramContext, Map paramMap)
  {
    try
    {
      TreeMap localTreeMap = new java/util/TreeMap;
      localTreeMap.<init>();
      a = localTreeMap;
      localTreeMap.putAll(b.a(paramContext, paramMap));
      a.putAll(d.a(paramContext));
      a.putAll(c.a(paramContext));
      a.putAll(a.a(paramContext, paramMap));
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */