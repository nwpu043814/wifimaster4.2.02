package com.analysis.common.tools;

import android.util.Log;

public final class a
{
  public static boolean a = false;
  private static final String b = "Logger";
  
  public static void a(String paramString1, String paramString2)
  {
    if (a) {
      Log.v(paramString1, paramString2);
    }
  }
  
  private static void a(String paramString1, String paramString2, Exception paramException)
  {
    if (a) {
      Log.v(paramString1, paramException.toString() + ": [" + paramString2 + "]");
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a) {
      Log.i(paramString1, paramString2);
    }
  }
  
  private static void b(String paramString1, String paramString2, Exception paramException)
  {
    if (a) {
      Log.d(paramString1, paramException.toString() + ": [" + paramString2 + "]");
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a) {
      Log.w(paramString1, paramString2);
    }
  }
  
  private static void c(String paramString1, String paramString2, Exception paramException)
  {
    if (a) {
      Log.i(paramString1, paramException.toString() + ": [" + paramString2 + "]");
    }
  }
  
  private static void d(String paramString1, String paramString2)
  {
    if (a) {
      Log.d(paramString1, paramString2);
    }
  }
  
  private static void d(String paramString1, String paramString2, Exception paramException)
  {
    if (a)
    {
      Log.w(paramString1, paramException.toString() + ": [" + paramString2 + "]");
      for (paramException : paramException.getStackTrace()) {
        Log.w(paramString1, "        at\t " + paramException.toString());
      }
    }
  }
  
  private static void e(String paramString1, String paramString2)
  {
    if (a) {
      Log.e(paramString1, paramString2);
    }
  }
  
  private static void e(String paramString1, String paramString2, Exception paramException)
  {
    if (a)
    {
      Log.e(paramString1, paramException.toString() + ": [" + paramString2 + "]");
      for (paramException : paramException.getStackTrace()) {
        Log.e(paramString1, "        at\t " + paramException.toString());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/tools/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */