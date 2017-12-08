package com.linksure.apservice.a.f;

import android.text.format.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class f
{
  private static SimpleDateFormat a = new SimpleDateFormat("hh:mm");
  private static String[] b = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
  
  public static String a(long paramLong)
  {
    String str;
    if (paramLong == 0L) {
      str = "";
    }
    for (;;)
    {
      return str;
      paramLong = System.currentTimeMillis() - paramLong;
      if (paramLong > 31104000000L)
      {
        paramLong /= 31104000000L;
        str = paramLong + " 年前";
      }
      else if (paramLong > 2592000000L)
      {
        paramLong /= 2592000000L;
        str = paramLong + " 个月前";
      }
      else if (paramLong > 86400000L)
      {
        paramLong /= 86400000L;
        str = paramLong + " 天前";
      }
      else if (paramLong > 3600000L)
      {
        paramLong /= 3600000L;
        str = paramLong + " 小时前";
      }
      else if (paramLong > 60000L)
      {
        paramLong /= 60000L;
        str = paramLong + " 分钟前";
      }
      else
      {
        str = "刚刚";
      }
    }
  }
  
  private static StringBuilder a(StringBuilder paramStringBuilder, Time paramTime)
  {
    if (paramTime.hour < 4) {
      paramStringBuilder.append("凌晨");
    }
    for (;;)
    {
      paramStringBuilder.append(a.format(new Date(paramTime.toMillis(true))));
      return paramStringBuilder;
      if (paramTime.hour < 9) {
        paramStringBuilder.append("早上");
      } else if (paramTime.hour < 12) {
        paramStringBuilder.append("上午");
      } else if (paramTime.hour < 13) {
        paramStringBuilder.append("中午");
      } else if (paramTime.hour < 18) {
        paramStringBuilder.append("下午");
      } else {
        paramStringBuilder.append("晚上");
      }
    }
  }
  
  public static String b(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    Object localObject = new Time();
    ((Time)localObject).set(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localTime.year == ((Time)localObject).year) && (localTime.yearDay == ((Time)localObject).yearDay)) {
      localObject = a(localStringBuilder, localTime).toString();
    }
    for (;;)
    {
      return (String)localObject;
      ((Time)localObject).set(System.currentTimeMillis() - 86400000L);
      if ((localTime.year == ((Time)localObject).year) && (localTime.yearDay == ((Time)localObject).yearDay))
      {
        localStringBuilder.append("昨天 ");
        a(localStringBuilder, localTime);
        localObject = localStringBuilder.toString();
      }
      else if (localTime.getWeekNumber() == ((Time)localObject).getWeekNumber())
      {
        localStringBuilder.append(b[localTime.weekDay]).append(" ");
        a(localStringBuilder, localTime);
        localObject = localStringBuilder.toString();
      }
      else
      {
        localObject = localTime.format("%Y/%m/%d %H:%M");
      }
    }
  }
  
  public static String c(long paramLong)
  {
    String str;
    if (paramLong == 0L) {
      str = "";
    }
    for (;;)
    {
      return str;
      if (paramLong > 1073741824L) {
        str = (paramLong >> 30) + "G";
      } else if (paramLong > 1048576L) {
        str = (paramLong >> 20) + "M";
      } else if (paramLong > 1024L) {
        str = (paramLong >> 10) + "K";
      } else {
        str = paramLong + "byte";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */