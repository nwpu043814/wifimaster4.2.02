package ct;

import android.util.Log;

public final class bb
{
  private static volatile boolean a = true;
  private static volatile boolean b = false;
  
  public static void a(String paramString1, String paramString2)
  {
    if (a) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      Log.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (a) {
      Log.w(paramString, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a) {
      Log.w(paramString1, paramString2);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */