package com.tencent.wxop.stat.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public final class q
{
  private static SharedPreferences db = null;
  
  private static SharedPreferences S(Context paramContext)
  {
    try
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(".mta-wxop", 0);
      db = localSharedPreferences;
      if (localSharedPreferences == null) {
        db = PreferenceManager.getDefaultSharedPreferences(paramContext);
      }
      paramContext = db;
      return paramContext;
    }
    finally {}
  }
  
  public static int a(Context paramContext, String paramString, int paramInt)
  {
    paramString = l.e(paramContext, "wxop_" + paramString);
    return S(paramContext).getInt(paramString, paramInt);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramString = l.e(paramContext, "wxop_" + paramString);
    paramContext = S(paramContext).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.commit();
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = l.e(paramContext, "wxop_" + paramString1);
    return S(paramContext).getString(paramString1, paramString2);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    paramString = l.e(paramContext, "wxop_" + paramString);
    paramContext = S(paramContext).edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = l.e(paramContext, "wxop_" + paramString1);
    paramContext = S(paramContext).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
  
  public static long f(Context paramContext, String paramString)
  {
    paramString = l.e(paramContext, "wxop_" + paramString);
    return S(paramContext).getLong(paramString, 0L);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */