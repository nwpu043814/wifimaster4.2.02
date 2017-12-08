package com.analysis.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.analysis.common.c;

public final class p
{
  private static final String a = "up_traffic";
  private static final String b = "down_traffic";
  
  public static o a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        arrayOfLong = c.l(paramContext);
        if ((arrayOfLong[0] > 0L) && (arrayOfLong[1] > 0L)) {
          continue;
        }
        paramContext = null;
      }
      catch (Exception paramContext)
      {
        long[] arrayOfLong;
        SharedPreferences localSharedPreferences;
        long l2;
        long l1;
        paramContext.printStackTrace();
        paramContext = null;
        continue;
      }
      return paramContext;
      localSharedPreferences = paramContext.getSharedPreferences("sp_general_config", 0);
      l2 = localSharedPreferences.getLong("down_traffic", -1L);
      l1 = localSharedPreferences.getLong("up_traffic", -1L);
      paramContext = localSharedPreferences.edit();
      paramContext.putLong("down_traffic", arrayOfLong[0]);
      paramContext.putLong("up_traffic", arrayOfLong[1]);
      paramContext.commit();
      if ((l2 <= 0L) || (l1 <= 0L))
      {
        paramContext = null;
      }
      else
      {
        arrayOfLong[0] -= l2;
        arrayOfLong[1] -= l1;
        if ((arrayOfLong[0] <= 0L) || (arrayOfLong[1] <= 0L))
        {
          paramContext = null;
        }
        else
        {
          paramContext = new com/analysis/model/o;
          paramContext.<init>((int)arrayOfLong[1], (int)arrayOfLong[0], localSharedPreferences.getString("session_id", "null"), localSharedPreferences.getString("login_name", "null"), localSharedPreferences.getString("app_1d", "null"));
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */