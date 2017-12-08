package com.lantern.favorite.c;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class a
{
  public static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new SimpleDateFormat("HH:mm", Locale.getDefault());
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTime(new Date(paramLong));
    localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(localCalendar.getTimeInMillis()));
    if ((System.currentTimeMillis() - localCalendar.getTimeInMillis()) / 86400000L > 2L)
    {
      localStringBuilder.append(a(localCalendar));
      localStringBuilder.append(" ");
      localStringBuilder.append(a((String)localObject));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(a(localCalendar));
      localStringBuilder.append(" ");
      localStringBuilder.append(a((String)localObject));
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
    }
  }
  
  private static String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    int i;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.contains(":"))
      {
        i = Integer.parseInt(paramString.split(":")[0]);
        if ((i <= 0) || (i > 5)) {
          break label46;
        }
        str1 = "凌晨";
      }
    }
    for (;;)
    {
      return str1;
      label46:
      if ((5 < i) && (i <= 12)) {
        str1 = "上午";
      } else {
        str1 = "下午";
      }
    }
  }
  
  private static String a(Calendar paramCalendar)
  {
    long l = (System.currentTimeMillis() - paramCalendar.getTimeInMillis()) / 86400000L;
    if (l == 0L) {
      paramCalendar = "";
    }
    for (;;)
    {
      return paramCalendar;
      if (l == 1L) {
        paramCalendar = "昨天";
      } else if (l == 2L) {
        paramCalendar = "前天";
      } else {
        paramCalendar = new SimpleDateFormat("MM月dd日", Locale.getDefault()).format(Long.valueOf(paramCalendar.getTimeInMillis()));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */