package com.alipay.b.c;

import android.content.Context;
import android.os.Build;
import com.alipay.c.a.a.e.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class a
{
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = b(paramContext, paramString1, paramString2, paramString3);
      paramString2 = new java/lang/StringBuilder;
      paramString2.<init>();
      paramContext = paramContext.getFilesDir().getAbsolutePath() + "/log/ap";
      paramString2 = Calendar.getInstance().getTime();
      paramString3 = new java/text/SimpleDateFormat;
      paramString3.<init>("yyyyMMdd");
      paramString2 = paramString3.format(paramString2);
      paramString3 = new java/lang/StringBuilder;
      paramString3.<init>();
      d.a(paramContext, paramString2 + ".log", paramString1.toString());
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      d.a(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    try
    {
      d.a(paramThrowable);
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  private static com.alipay.c.a.a.e.a b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    try
    {
      paramContext = paramContext.getPackageName();
      return new com.alipay.c.a.a.e.a(Build.MODEL, paramContext, "security-sdk-token", "3.2.2-20160830", paramString1, paramString2, paramString3);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */