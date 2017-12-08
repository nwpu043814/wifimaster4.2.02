package com.tencent.mm.sdk.b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;

public final class a
{
  private static int level = 6;
  public static d q;
  private static a r;
  private static a s;
  private static final String t;
  
  static
  {
    Object localObject = new b();
    r = (a)localObject;
    s = (a)localObject;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
    ((StringBuilder)localObject).append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
    ((StringBuilder)localObject).append("] BOARD:[" + Build.BOARD);
    ((StringBuilder)localObject).append("] DEVICE:[" + Build.DEVICE);
    ((StringBuilder)localObject).append("] DISPLAY:[" + Build.DISPLAY);
    ((StringBuilder)localObject).append("] FINGERPRINT:[" + Build.FINGERPRINT);
    ((StringBuilder)localObject).append("] HOST:[" + Build.HOST);
    ((StringBuilder)localObject).append("] MANUFACTURER:[" + Build.MANUFACTURER);
    ((StringBuilder)localObject).append("] MODEL:[" + Build.MODEL);
    ((StringBuilder)localObject).append("] PRODUCT:[" + Build.PRODUCT);
    ((StringBuilder)localObject).append("] TAGS:[" + Build.TAGS);
    ((StringBuilder)localObject).append("] TYPE:[" + Build.TYPE);
    ((StringBuilder)localObject).append("] USER:[" + Build.USER + "]");
    t = ((StringBuilder)localObject).toString();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((s != null) && (s.h() <= 4)) {
      if (paramVarArgs != null) {
        break label70;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = i(paramString1);
      paramString1 = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString1.h(paramString2, paramVarArgs);
      return;
      label70:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ((s != null) && (s.h() <= 3))
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      paramString2 = i(paramString1);
      paramString1 = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString1.g(paramString2, str);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if ((s != null) && (s.h() <= 2))
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      paramString2 = i(paramString1);
      paramString1 = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString1.e(paramString2, str);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if ((s != null) && (s.h() <= 1))
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      paramString2 = i(paramString1);
      paramString1 = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString1.f(paramString2, str);
    }
  }
  
  private static String i(String paramString)
  {
    String str = paramString;
    if (q != null) {
      str = q.i(paramString);
    }
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void f(String paramString1, String paramString2);
    
    public abstract void g(String paramString1, String paramString2);
    
    public abstract int h();
    
    public abstract void h(String paramString1, String paramString2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */