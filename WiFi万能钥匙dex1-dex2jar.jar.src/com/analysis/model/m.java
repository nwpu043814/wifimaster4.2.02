package com.analysis.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.analysis.analytics.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class m
  implements com.analysis.common.a
{
  private static final String f = "last_resume";
  private static final String g = "last_pause";
  
  private static String a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    int j = 0;
    String str = "android_" + com.analysis.common.c.d(paramContext) + "_" + System.currentTimeMillis();
    k localk = new k();
    Object localObject1 = paramContext.getSharedPreferences("sp_general_config", 0);
    localk.i = ((SharedPreferences)localObject1).getString("session_id", "null");
    localk.q = ((SharedPreferences)localObject1).getString("app_1d", "null");
    localk.j = ((SharedPreferences)localObject1).getLong("app_start_time", Long.MIN_VALUE);
    localk.k = ((SharedPreferences)localObject1).getLong("session_start_time", Long.MIN_VALUE);
    localk.l = ((SharedPreferences)localObject1).getLong("session_end_time", Long.MIN_VALUE);
    localk.m = com.analysis.common.c.h(paramContext)[0];
    localk.p = com.analysis.common.c.d(paramContext);
    localk.o = ((SharedPreferences)localObject1).getString("login_name", "null");
    localk.n = com.analysis.common.c.a(paramContext, (SharedPreferences)localObject1);
    Object localObject2 = b.a(paramContext);
    if (localObject2 == null)
    {
      i = 0;
      if (i != 0) {
        localk.f = ((a)localObject2);
      }
      localObject2 = i.a((SharedPreferences)localObject1);
      if (com.analysis.common.tools.c.a(localk.g)) {
        localk.g = new ArrayList();
      }
      if (localObject2 != null) {
        break label422;
      }
      i = 0;
      label243:
      if (i != 0) {
        localk.g.addAll((Collection)localObject2);
      }
      localObject2 = p.a(paramContext);
      if (localObject2 != null) {
        break label427;
      }
    }
    label422:
    label427:
    for (int i = j;; i = 1)
    {
      if (i != 0) {
        localk.h = ((o)localObject2);
      }
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).remove("session_start_time");
      ((SharedPreferences.Editor)localObject1).remove("last_pause");
      ((SharedPreferences.Editor)localObject1).remove("last_resume");
      ((SharedPreferences.Editor)localObject1).putString("pages", "");
      ((SharedPreferences.Editor)localObject1).commit();
      com.analysis.common.upload.o.a(paramContext).a(localk);
      long l = System.currentTimeMillis();
      paramContext = paramSharedPreferences.edit();
      paramContext.putString("session_id", str);
      paramContext.putLong("session_start_time", l);
      paramContext.putLong("last_resume", l);
      paramContext.putLong("last_pause", 0L);
      paramContext.commit();
      return str;
      i = 1;
      break;
      i = 1;
      break label243;
    }
  }
  
  private static void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("sp_general_config", 0);
    if (com.analysis.common.tools.c.a(localSharedPreferences)) {}
    for (;;)
    {
      return;
      long l2 = localSharedPreferences.getLong("last_resume", 0L);
      long l1 = localSharedPreferences.getLong("last_pause", 0L);
      long l3 = System.currentTimeMillis();
      label72:
      label74:
      k localk;
      Object localObject2;
      Object localObject3;
      if ((l2 != 0L) && (l3 - l2 < d.d))
      {
        com.analysis.common.tools.a.a("ALInterface", "onResume called before onPause");
        i = 0;
        if (i == 0) {
          break label544;
        }
        localObject1 = "android_" + com.analysis.common.c.d(paramContext) + "_" + System.currentTimeMillis();
        localk = new k();
        localObject2 = paramContext.getSharedPreferences("sp_general_config", 0);
        localk.i = ((SharedPreferences)localObject2).getString("session_id", "null");
        localk.q = ((SharedPreferences)localObject2).getString("app_1d", "null");
        localk.j = ((SharedPreferences)localObject2).getLong("app_start_time", Long.MIN_VALUE);
        localk.k = ((SharedPreferences)localObject2).getLong("session_start_time", Long.MIN_VALUE);
        localk.l = ((SharedPreferences)localObject2).getLong("session_end_time", Long.MIN_VALUE);
        localk.m = com.analysis.common.c.h(paramContext)[0];
        localk.p = com.analysis.common.c.d(paramContext);
        localk.o = ((SharedPreferences)localObject2).getString("login_name", "null");
        localk.n = com.analysis.common.c.a(paramContext, (SharedPreferences)localObject2);
        localObject3 = b.a(paramContext);
        if (localObject3 != null) {
          break label529;
        }
        i = 0;
        label271:
        if (i != 0) {
          localk.f = ((a)localObject3);
        }
        localObject3 = i.a((SharedPreferences)localObject2);
        if (com.analysis.common.tools.c.a(localk.g)) {
          localk.g = new ArrayList();
        }
        if (localObject3 != null) {
          break label534;
        }
        i = 0;
        label319:
        if (i != 0) {
          localk.g.addAll((Collection)localObject3);
        }
        localObject3 = p.a(paramContext);
        if (localObject3 != null) {
          break label539;
        }
      }
      label529:
      label534:
      label539:
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          localk.h = ((o)localObject3);
        }
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).remove("session_start_time");
        ((SharedPreferences.Editor)localObject2).remove("last_pause");
        ((SharedPreferences.Editor)localObject2).remove("last_resume");
        ((SharedPreferences.Editor)localObject2).putString("pages", "");
        ((SharedPreferences.Editor)localObject2).commit();
        com.analysis.common.upload.o.a(paramContext).a(localk);
        l1 = System.currentTimeMillis();
        paramContext = localSharedPreferences.edit();
        paramContext.putString("session_id", (String)localObject1);
        paramContext.putLong("session_start_time", l1);
        paramContext.putLong("last_resume", l1);
        paramContext.putLong("last_pause", 0L);
        paramContext.commit();
        com.analysis.common.tools.a.a("ALInterface", "Start new session: " + (String)localObject1);
        break;
        if (l3 - l1 <= d.d) {
          break label72;
        }
        i = 1;
        break label74;
        i = 1;
        break label271;
        i = 1;
        break label319;
      }
      label544:
      paramContext = localSharedPreferences.getString("session_id", "null");
      l1 = System.currentTimeMillis();
      Object localObject1 = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putLong("last_resume", l1);
      ((SharedPreferences.Editor)localObject1).putLong("last_pause", 0L);
      ((SharedPreferences.Editor)localObject1).commit();
      com.analysis.common.tools.a.a("ALInterface", "Extend current session: " + paramContext);
    }
  }
  
  private static void a(SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.remove("session_start_time");
    paramSharedPreferences.remove("last_pause");
    paramSharedPreferences.remove("last_resume");
    paramSharedPreferences.putString("pages", "");
    paramSharedPreferences.commit();
  }
  
  private static void b(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("sp_general_config", 0);
    if (com.analysis.common.tools.c.a(paramContext)) {}
    for (;;)
    {
      return;
      if ((paramContext.getLong("last_resume", 0L) == 0L) && (d.e))
      {
        com.analysis.common.tools.a.a("ALInterface", "onPause called before onResume");
      }
      else
      {
        long l = System.currentTimeMillis();
        paramContext = paramContext.edit();
        paramContext.putLong("last_resume", 0L);
        paramContext.putLong("last_pause", l);
        paramContext.putLong("session_end_time", l);
        paramContext.commit();
      }
    }
  }
  
  private static boolean b(SharedPreferences paramSharedPreferences)
  {
    boolean bool = false;
    long l2 = paramSharedPreferences.getLong("last_resume", 0L);
    long l3 = paramSharedPreferences.getLong("last_pause", 0L);
    long l1 = System.currentTimeMillis();
    if ((l2 != 0L) && (l1 - l2 < d.d)) {
      com.analysis.common.tools.a.a("ALInterface", "onResume called before onPause");
    }
    for (;;)
    {
      return bool;
      if (l1 - l3 > d.d) {
        bool = true;
      }
    }
  }
  
  private static k c(Context paramContext)
  {
    k localk = new k();
    SharedPreferences localSharedPreferences1 = paramContext.getSharedPreferences("sp_general_config", 0);
    localk.i = localSharedPreferences1.getString("session_id", "null");
    localk.q = localSharedPreferences1.getString("app_1d", "null");
    localk.j = localSharedPreferences1.getLong("app_start_time", Long.MIN_VALUE);
    localk.k = localSharedPreferences1.getLong("session_start_time", Long.MIN_VALUE);
    localk.l = localSharedPreferences1.getLong("session_end_time", Long.MIN_VALUE);
    localk.m = com.analysis.common.c.h(paramContext)[0];
    localk.p = com.analysis.common.c.d(paramContext);
    localk.o = localSharedPreferences1.getString("login_name", "null");
    localk.n = com.analysis.common.c.a(paramContext, localSharedPreferences1);
    SharedPreferences localSharedPreferences2 = paramContext.getSharedPreferences("sp_general_config", 0);
    int i = localSharedPreferences2.getInt("app_version_code", 0);
    Object localObject;
    if ((!localSharedPreferences2.getBoolean("upload_state", false)) || (com.analysis.common.c.b(paramContext) != i))
    {
      a locala = new a();
      i = Build.VERSION.SDK_INT;
      if (i == Integer.MIN_VALUE)
      {
        localObject = com.analysis.common.tools.c.a();
        locala.g = ((String)localObject);
        locala.h = Build.BRAND;
        locala.i = Build.MODEL;
        locala.j = com.analysis.common.c.j(paramContext);
        locala.k = com.analysis.common.c.c(paramContext);
        locala.l = com.analysis.common.c.k(paramContext);
        locala.m = com.analysis.common.c.d(paramContext);
        locala.n = com.analysis.common.c.e(paramContext);
        locala.o = com.analysis.common.c.f(paramContext);
        locala.p = com.analysis.common.c.g(paramContext);
        locala.q = localSharedPreferences2.getString("login_name", "null");
        locala.r = localSharedPreferences2.getString("app_1d", "null");
        localObject = localSharedPreferences2.edit();
        ((SharedPreferences.Editor)localObject).putInt("app_version_code", com.analysis.common.c.b(paramContext));
        ((SharedPreferences.Editor)localObject).putBoolean("upload_state", true);
        ((SharedPreferences.Editor)localObject).commit();
        localObject = locala;
        label356:
        if (localObject != null) {
          break label513;
        }
        i = 0;
        label362:
        if (i != 0) {
          localk.f = ((a)localObject);
        }
        localObject = i.a(localSharedPreferences1);
        if (com.analysis.common.tools.c.a(localk.g)) {
          localk.g = new ArrayList();
        }
        if (localObject != null) {
          break label518;
        }
        i = 0;
        label407:
        if (i != 0) {
          localk.g.addAll((Collection)localObject);
        }
        paramContext = p.a(paramContext);
        if (paramContext != null) {
          break label523;
        }
      }
    }
    label513:
    label518:
    label523:
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        localk.h = paramContext;
      }
      paramContext = localSharedPreferences1.edit();
      paramContext.remove("session_start_time");
      paramContext.remove("last_pause");
      paramContext.remove("last_resume");
      paramContext.putString("pages", "");
      paramContext.commit();
      return localk;
      localObject = String.valueOf(i);
      break;
      localObject = null;
      break label356;
      i = 1;
      break label362;
      i = 1;
      break label407;
    }
  }
  
  private static String d(Context paramContext)
  {
    return "android_" + com.analysis.common.c.d(paramContext) + "_" + System.currentTimeMillis();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */