package com.analysis.common.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.analysis.common.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class c
  implements a
{
  private static int a(Date paramDate1, Date paramDate2)
  {
    Date localDate;
    if (paramDate1.after(paramDate2))
    {
      localDate = paramDate2;
      paramDate2 = paramDate1;
    }
    for (;;)
    {
      return (int)((paramDate2.getTime() - localDate.getTime()) / 1000L);
      localDate = paramDate1;
    }
  }
  
  public static String a()
  {
    String str = null;
    if (a(null)) {
      str = "null";
    }
    return str;
  }
  
  private static String a(int paramInt)
  {
    if (paramInt == Integer.MIN_VALUE) {}
    for (String str = a();; str = String.valueOf(paramInt)) {
      return str;
    }
  }
  
  public static String a(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(paramLong));
  }
  
  private static String a(Date paramDate)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(paramDate);
  }
  
  private static boolean a(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.toString().equals(Locale.CHINA.toString());
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(Object paramObject)
  {
    boolean bool = true;
    int i;
    if (paramObject == null)
    {
      i = 0;
      if (i != 0) {
        break label19;
      }
    }
    for (;;)
    {
      return bool;
      i = 1;
      break;
      label19:
      bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramString != null)
    {
      j = paramString.length();
      if (j != 0) {}
    }
    else
    {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      for (int i = 0;; i++)
      {
        if (i >= j) {
          break label47;
        }
        bool1 = bool2;
        if (!Character.isWhitespace(paramString.charAt(i))) {
          break;
        }
      }
      label47:
      bool1 = true;
    }
  }
  
  private static String b()
  {
    String str = null;
    if (a(null)) {
      str = "null";
    }
    return str;
  }
  
  public static String b(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US).format(new Date(paramLong));
  }
  
  private static String b(Date paramDate)
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(paramDate);
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool = true;
    if (paramContext.getResources().getConfiguration().orientation == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private static boolean b(Object paramObject)
  {
    if (paramObject == null) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (!a(paramString)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static String c(long paramLong)
  {
    if (paramLong == Long.MIN_VALUE) {}
    for (String str = a();; str = String.valueOf(paramLong)) {
      return str;
    }
  }
  
  private static Date c(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private static boolean c()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  private static boolean c(Context paramContext)
  {
    return "Wi-Fi".equals(com.analysis.common.c.h(paramContext)[0]);
  }
  
  private static boolean d(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    int i;
    if (paramContext == null)
    {
      i = 0;
      if (i == 0) {
        break label35;
      }
    }
    label35:
    for (boolean bool = paramContext.isConnectedOrConnecting();; bool = false)
    {
      return bool;
      i = 1;
      break;
    }
  }
  
  private static boolean e(Context paramContext)
  {
    if ((paramContext.getApplicationInfo().flags & 0x2) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/tools/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */