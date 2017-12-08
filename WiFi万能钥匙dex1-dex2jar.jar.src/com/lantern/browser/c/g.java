package com.lantern.browser.c;

import android.content.Context;
import com.lantern.browser.R.string;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class g
{
  private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
  
  public static String a(Context paramContext, long paramLong)
  {
    long l = System.currentTimeMillis() - paramLong;
    if (l > 0L) {
      if (l < 60000L) {
        paramContext = paramContext.getString(R.string.comment_time_1);
      }
    }
    for (;;)
    {
      return paramContext;
      if (l < 3600000L) {
        paramContext = String.format(paramContext.getString(R.string.comment_time_2), new Object[] { Long.valueOf(l / 60000L) });
      } else if (l < 86400000L) {
        paramContext = String.format(paramContext.getString(R.string.comment_time_3), new Object[] { Long.valueOf(l / 3600000L) });
      } else {
        paramContext = a.format(new Date(paramLong));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */