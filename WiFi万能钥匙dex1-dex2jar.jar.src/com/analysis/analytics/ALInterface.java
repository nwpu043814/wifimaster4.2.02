package com.analysis.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.analysis.model.f;
import com.analysis.model.i;
import com.analysis.model.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ALInterface
{
  private static final String TAG = ALInterface.class.getSimpleName();
  private static final a mALAgent = new a();
  
  public static void onEvent(Context paramContext, String paramString)
  {
    a locala = mALAgent;
    if (!locala.e) {
      locala.a(paramContext);
    }
    locala.d.a.a(paramString, 0, null);
  }
  
  public static void onEvent(Context paramContext, String paramString, int paramInt, Map<String, String> paramMap)
  {
    a locala = mALAgent;
    if (!locala.e) {
      locala.a(paramContext);
    }
    locala.d.a.a(paramString, paramInt, paramMap);
  }
  
  public static void onKillProcess(Context paramContext) {}
  
  public static void onPause(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      com.analysis.common.tools.a.a(TAG, "unexpected null context in onPause");
    }
    for (;;)
    {
      return;
      Object localObject1 = paramString;
      if (com.analysis.common.tools.c.a(paramString))
      {
        com.analysis.common.tools.a.a(TAG, "pageName is null or empty");
        localObject1 = paramContext.getClass().getName();
      }
      paramString = mALAgent;
      if (com.analysis.common.tools.c.a(paramContext))
      {
        com.analysis.common.tools.a.c("ALInterface", "context is null");
      }
      else
      {
        paramString.c.a((String)localObject1);
        i locali = paramString.c;
        Object localObject2 = paramContext.getSharedPreferences("sp_general_config", 0);
        localObject1 = ((SharedPreferences)localObject2).edit();
        if (locali.g.size() > 0)
        {
          ??? = ((SharedPreferences)localObject2).getString("save_pages", null);
          localObject2 = new com.analysis.common.b();
          if (com.analysis.common.tools.c.b((String)???))
          {
            ((com.analysis.common.b)localObject2).a((String)???);
            ((com.analysis.common.b)localObject2).a(";");
          }
          synchronized (locali.g)
          {
            Iterator localIterator = locali.g.iterator();
            if (localIterator.hasNext())
            {
              j localj = (j)localIterator.next();
              ((com.analysis.common.b)localObject2).a(String.format("[\"%s\",%d,%d]", new Object[] { localj.a, Long.valueOf(localj.b), Long.valueOf(localj.c) }));
              ((com.analysis.common.b)localObject2).a(";");
            }
          }
          locali.g.clear();
          int i = ((com.analysis.common.b)localObject2).f.length();
          ((com.analysis.common.b)localObject2).f.deleteCharAt(i - 1);
          ((SharedPreferences.Editor)localObject1).remove("save_pages");
          ((SharedPreferences.Editor)localObject1).putString("save_pages", ((com.analysis.common.b)localObject2).toString());
        }
        ((SharedPreferences.Editor)localObject1).commit();
        if (!paramString.e) {
          paramString.a(paramContext);
        }
        g.a(new c(paramString));
      }
    }
  }
  
  public static void onResume(Context paramContext, String arg1)
  {
    if (paramContext == null) {
      com.analysis.common.tools.a.a(TAG, "unexpected null context in onResume");
    }
    for (;;)
    {
      return;
      String str = ???;
      if (com.analysis.common.tools.c.a(???))
      {
        com.analysis.common.tools.a.a(TAG, "pageName is null or empty");
        str = paramContext.getClass().getName();
      }
      a locala = mALAgent;
      if (com.analysis.common.tools.c.a(paramContext))
      {
        com.analysis.common.tools.a.c("ALInterface", "context is null");
        continue;
      }
      i locali = locala.c;
      if (com.analysis.common.tools.c.b(str)) {}
      synchronized (locali.f)
      {
        locali.f.put(str, Long.valueOf(System.currentTimeMillis()));
        if (!locala.e) {
          locala.a(paramContext);
        }
        g.a(new b(locala));
      }
    }
  }
  
  public static void onSignIn(Context paramContext, String paramString)
  {
    a locala = mALAgent;
    if (locala.a != null) {
      locala.a.getSharedPreferences("sp_general_config", 0).edit().putString("login_name", paramString).commit();
    }
    for (;;)
    {
      return;
      if (paramContext != null) {
        paramContext.getSharedPreferences("sp_general_config", 0).edit().putString("login_name", paramString).commit();
      }
    }
  }
  
  public static void onSignIn(String paramString)
  {
    onSignIn(null, paramString);
  }
  
  public static void onSignOff()
  {
    a locala = mALAgent;
    if (locala.a != null) {
      locala.a.getSharedPreferences("sp_general_config", 0).edit().remove("login_name").commit();
    }
  }
  
  public static void setAppId(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("sp_general_config", 0).edit().putString("app_1d", paramString).commit();
  }
  
  public static void setAppkey(Context paramContext, String paramString)
  {
    d.a(paramString);
  }
  
  public static void setCatchUncaughtExceptions(boolean paramBoolean)
  {
    d.a = paramBoolean;
  }
  
  public static void setCity(Context paramContext, int paramInt)
  {
    paramContext.getSharedPreferences("sp_general_config", 0).edit().putInt("app_city", paramInt).commit();
  }
  
  public static void setContinueSessionMills(long paramLong)
  {
    d.d = paramLong;
  }
  
  private static void setCrashModule(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("sp_general_config", 0).edit().putString("crash_module", paramString).commit();
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    com.analysis.common.tools.a.a = paramBoolean;
    setOpenTest(paramBoolean);
  }
  
  public static void setLocation(Context paramContext, double paramDouble1, double paramDouble2)
  {
    String str = paramDouble2 + "*" + paramDouble1;
    paramContext.getSharedPreferences("sp_general_config", 0).edit().putString("session_location", str).putLong("session_location_time", System.currentTimeMillis()).commit();
  }
  
  public static void setOpenTest(boolean paramBoolean)
  {
    d.a(paramBoolean);
  }
  
  public static void setVersionName(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("sp_general_config", 0).edit().putString("version_name", paramString).commit();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/analytics/ALInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */