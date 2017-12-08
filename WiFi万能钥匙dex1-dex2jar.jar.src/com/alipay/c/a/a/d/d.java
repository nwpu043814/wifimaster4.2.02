package com.alipay.c.a.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d
{
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
  }
  
  public static void a(Context paramContext, String paramString, Map paramMap)
  {
    paramString = paramContext.getSharedPreferences(paramString, 0).edit();
    if (paramString != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        paramContext = (String)localIterator.next();
        paramString.putString(paramContext, (String)paramMap.get(paramContext));
      }
      paramString.commit();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */