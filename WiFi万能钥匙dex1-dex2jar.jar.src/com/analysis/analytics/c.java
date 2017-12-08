package com.analysis.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class c
  extends f
{
  c(a parama) {}
  
  public final void a()
  {
    Object localObject = this.a.a.getApplicationContext().getSharedPreferences("sp_general_config", 0);
    if (!com.analysis.common.tools.c.a(localObject))
    {
      if ((((SharedPreferences)localObject).getLong("last_resume", 0L) != 0L) || (!d.e)) {
        break label52;
      }
      com.analysis.common.tools.a.a("ALInterface", "onPause called before onResume");
    }
    for (;;)
    {
      return;
      label52:
      long l = System.currentTimeMillis();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("last_resume", 0L);
      ((SharedPreferences.Editor)localObject).putLong("last_pause", l);
      ((SharedPreferences.Editor)localObject).putLong("session_end_time", l);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/analytics/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */