package com.bluefay.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.bluefay.d.a;

public class d
{
  public static int a(String paramString)
  {
    String str = a.getAppContext().getPackageName();
    return c(a.getAppContext(), str, paramString);
  }
  
  public static long a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getLong(paramString2, paramLong);
  }
  
  public static long a(String paramString, long paramLong)
  {
    String str = a.getAppContext().getPackageName();
    return a(a.getAppContext(), str, paramString, paramLong);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(a.getAppContext().getPackageName(), paramString1, paramString2);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(a.getAppContext(), paramString1, paramString2, paramString3);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getBoolean(paramString2, false);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putInt(paramString2, paramInt);
    return paramContext.commit();
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putBoolean(paramString2, paramBoolean);
    return paramContext.commit();
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    String str = a.getAppContext().getPackageName();
    return a(a.getAppContext(), str, paramString, paramInt);
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, 0);
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 4).edit();
    paramContext.putInt(paramString2, paramInt);
    return paramContext.commit();
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putLong(paramString2, paramLong);
    return paramContext.commit();
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putString(paramString2, paramString3);
    return paramContext.commit();
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences(paramString1, 4).getBoolean(paramString2, paramBoolean);
  }
  
  public static boolean b(String paramString, int paramInt)
  {
    String str = a.getAppContext().getPackageName();
    return b(a.getAppContext(), str, paramString, paramInt);
  }
  
  public static boolean b(String paramString, long paramLong)
  {
    String str = a.getAppContext().getPackageName();
    return b(a.getAppContext(), str, paramString, paramLong);
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    return b(a.getAppContext(), paramString1, paramString2, paramString3);
  }
  
  public static int c(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences(paramString1, 4).getInt(paramString2, 0);
  }
  
  public static String c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return paramContext.getSharedPreferences(paramString1, 4).getString(paramString2, paramString3);
  }
  
  public static boolean c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 4).edit();
    paramContext.putBoolean(paramString2, paramBoolean);
    return paramContext.commit();
  }
  
  public static boolean c(String paramString, long paramLong)
  {
    Object localObject = a.getAppContext().getPackageName();
    localObject = a.getAppContext().getSharedPreferences((String)localObject, 4).edit();
    ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
    return ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static boolean d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 4).edit();
    paramContext.putString(paramString2, paramString3);
    return paramContext.commit();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */