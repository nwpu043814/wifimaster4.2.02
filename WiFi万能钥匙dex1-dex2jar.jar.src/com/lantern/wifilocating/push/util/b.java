package com.lantern.wifilocating.push.util;

import android.util.Log;
import java.util.Locale;

public final class b
{
  private static boolean a = false;
  
  public static final void a(String paramString)
  {
    if (a()) {
      Log.i("PushSocket", d(paramString));
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  private static boolean a()
  {
    if ((a) || (g.b())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static final void b(String paramString)
  {
    if (a()) {
      Log.i("PushSync", d(paramString));
    }
  }
  
  public static final void c(String paramString)
  {
    if (a()) {
      Log.i("PushLog", d(paramString));
    }
  }
  
  private static final String d(String paramString)
  {
    try
    {
      Object localObject = new java/lang/Throwable;
      ((Throwable)localObject).<init>();
      localObject = localObject.fillInStackTrace().getStackTrace()[2];
      paramString = String.format(Locale.getDefault(), "[%s,%d,%s] %s", new Object[] { ((StackTraceElement)localObject).getFileName(), Integer.valueOf(((StackTraceElement)localObject).getLineNumber()), ((StackTraceElement)localObject).getMethodName(), paramString });
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */