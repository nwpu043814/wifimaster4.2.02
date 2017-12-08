package com.lantern.feed.d;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.bluefay.b.h;
import com.lantern.feed.R.string;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class c
{
  public static long a(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat;
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
      localObject = null;
    }
    for (;;)
    {
      try
      {
        paramString = localSimpleDateFormat.parse(paramString);
        if (paramString != null)
        {
          l = paramString.getTime();
          return l;
        }
      }
      catch (ParseException paramString)
      {
        h.a(paramString);
        paramString = (String)localObject;
        continue;
      }
      long l = 0L;
    }
  }
  
  public static String a(long paramLong)
  {
    Resources localResources = com.lantern.core.c.getAppContext().getResources();
    String str;
    if (localResources == null) {
      str = "刚刚";
    }
    for (;;)
    {
      return str;
      if (paramLong <= 0L)
      {
        str = localResources.getString(R.string.feed_time_1);
      }
      else
      {
        paramLong = System.currentTimeMillis() - paramLong;
        str = localResources.getString(R.string.feed_time_1);
        int i;
        if (paramLong > 31449600000L)
        {
          i = (int)(paramLong / 31449600000L);
          str = i + localResources.getString(R.string.feed_time_5);
        }
        else if (paramLong > 86400000L)
        {
          i = (int)(paramLong / 86400000L);
          str = i + localResources.getString(R.string.feed_time_4);
        }
        else if (paramLong > 3600000L)
        {
          i = (int)(paramLong / 3600000L);
          str = i + localResources.getString(R.string.feed_time_3);
        }
        else if (paramLong > 60000L)
        {
          i = (int)(paramLong / 60000L);
          str = i + localResources.getString(R.string.feed_time_2);
        }
        else if (paramLong >= 0L)
        {
          str = localResources.getString(R.string.feed_time_1);
        }
      }
    }
  }
  
  public static String b(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(paramLong));
  }
  
  public static String c(long paramLong)
  {
    return DateUtils.formatElapsedTime(paramLong / 1000L);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */