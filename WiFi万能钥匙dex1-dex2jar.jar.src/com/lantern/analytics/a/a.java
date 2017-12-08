package com.lantern.analytics.a;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public final class a
{
  private File a;
  private FilenameFilter b = new b(this);
  
  public a(Context paramContext, String paramString)
  {
    if (paramString != null) {}
    for (this.a = new File(paramContext.getFilesDir(), "crash_" + paramString);; this.a = new File(paramContext.getFilesDir(), "crash"))
    {
      if (!this.a.exists()) {
        this.a.mkdir();
      }
      return;
    }
  }
  
  public final boolean a(String paramString)
  {
    try
    {
      String str2 = this.a.getAbsolutePath();
      String str1 = File.separator;
      long l = System.currentTimeMillis() / 1000L;
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l * 1000L);
      SimpleDateFormat localSimpleDateFormat = new java/text/SimpleDateFormat;
      Locale localLocale = new java/util/Locale;
      localLocale.<init>("en");
      localSimpleDateFormat.<init>("yyyyMMdd-HHmmss", localLocale);
      boolean bool = com.bluefay.b.b.a(String.format("%s%s%s%s", new Object[] { str2, str1, "log-", localSimpleDateFormat.format(localCalendar.getTime()) }), paramString, "UTF-8");
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final File[] a()
  {
    try
    {
      File[] arrayOfFile = this.a.listFiles(this.b);
      c localc = new com/lantern/analytics/a/c;
      localc.<init>(this);
      Arrays.sort(arrayOfFile, localc);
      return arrayOfFile;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean b(String paramString)
  {
    try
    {
      File localFile = new java/io/File;
      localFile.<init>(this.a, paramString);
      boolean bool = localFile.delete();
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */