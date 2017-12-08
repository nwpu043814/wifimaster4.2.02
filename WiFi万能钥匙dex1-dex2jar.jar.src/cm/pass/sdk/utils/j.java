package cm.pass.sdk.utils;

import android.util.Log;

public class j
{
  private static boolean a = false;
  
  public static void a(String paramString1, String paramString2)
  {
    if (a) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (a) {
      Log.d("outer", "[" + paramString1 + "] : " + paramString2);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */