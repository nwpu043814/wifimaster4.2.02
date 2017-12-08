package com.analysis.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.analysis.model.i;
import com.analysis.model.k;
import com.analysis.model.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class b
  extends f
{
  b(a parama) {}
  
  public final void a()
  {
    Context localContext = this.a.a.getApplicationContext();
    SharedPreferences localSharedPreferences1 = localContext.getSharedPreferences("sp_general_config", 0);
    long l3;
    long l1;
    if (!com.analysis.common.tools.c.a(localSharedPreferences1))
    {
      long l2 = localSharedPreferences1.getLong("last_resume", 0L);
      l3 = localSharedPreferences1.getLong("last_pause", 0L);
      l1 = System.currentTimeMillis();
      if ((l2 == 0L) || (l1 - l2 >= d.d)) {
        break label771;
      }
      com.analysis.common.tools.a.a("ALInterface", "onResume called before onPause");
    }
    label341:
    label513:
    label520:
    label568:
    label599:
    label771:
    label802:
    label807:
    label812:
    label897:
    for (;;)
    {
      int i = 0;
      Object localObject2;
      Object localObject1;
      if (i != 0)
      {
        String str = "android_" + com.analysis.common.c.d(localContext) + "_" + System.currentTimeMillis();
        k localk = new k();
        SharedPreferences localSharedPreferences2 = localContext.getSharedPreferences("sp_general_config", 0);
        localk.i = localSharedPreferences2.getString("session_id", "null");
        localk.q = localSharedPreferences2.getString("app_1d", "null");
        localk.j = localSharedPreferences2.getLong("app_start_time", Long.MIN_VALUE);
        localk.k = localSharedPreferences2.getLong("session_start_time", Long.MIN_VALUE);
        localk.l = localSharedPreferences2.getLong("session_end_time", Long.MIN_VALUE);
        localk.m = com.analysis.common.c.h(localContext)[0];
        localk.p = com.analysis.common.c.d(localContext);
        localk.o = localSharedPreferences2.getString("login_name", "null");
        localk.n = com.analysis.common.c.a(localContext, localSharedPreferences2);
        SharedPreferences localSharedPreferences3 = localContext.getSharedPreferences("sp_general_config", 0);
        i = localSharedPreferences3.getInt("app_version_code", 0);
        if ((!localSharedPreferences3.getBoolean("upload_state", false)) || (com.analysis.common.c.b(localContext) != i))
        {
          localObject2 = new com.analysis.model.a();
          i = Build.VERSION.SDK_INT;
          if (i == Integer.MIN_VALUE)
          {
            localObject1 = com.analysis.common.tools.c.a();
            ((com.analysis.model.a)localObject2).g = ((String)localObject1);
            ((com.analysis.model.a)localObject2).h = Build.BRAND;
            ((com.analysis.model.a)localObject2).i = Build.MODEL;
            ((com.analysis.model.a)localObject2).j = com.analysis.common.c.j(localContext);
            ((com.analysis.model.a)localObject2).k = com.analysis.common.c.c(localContext);
            ((com.analysis.model.a)localObject2).l = com.analysis.common.c.k(localContext);
            ((com.analysis.model.a)localObject2).m = com.analysis.common.c.d(localContext);
            ((com.analysis.model.a)localObject2).n = com.analysis.common.c.e(localContext);
            ((com.analysis.model.a)localObject2).o = com.analysis.common.c.f(localContext);
            ((com.analysis.model.a)localObject2).p = com.analysis.common.c.g(localContext);
            ((com.analysis.model.a)localObject2).q = localSharedPreferences3.getString("login_name", "null");
            ((com.analysis.model.a)localObject2).r = localSharedPreferences3.getString("app_1d", "null");
            localObject1 = localSharedPreferences3.edit();
            ((SharedPreferences.Editor)localObject1).putInt("app_version_code", com.analysis.common.c.b(localContext));
            ((SharedPreferences.Editor)localObject1).putBoolean("upload_state", true);
            ((SharedPreferences.Editor)localObject1).commit();
            localObject1 = localObject2;
            if (localObject1 != null) {
              break label802;
            }
            i = 0;
            if (i != 0) {
              localk.f = ((com.analysis.model.a)localObject1);
            }
            localObject1 = i.a(localSharedPreferences2);
            if (com.analysis.common.tools.c.a(localk.g)) {
              localk.g = new ArrayList();
            }
            if (localObject1 != null) {
              break label807;
            }
            i = 0;
            if (i != 0) {
              localk.g.addAll((Collection)localObject1);
            }
            localObject1 = p.a(localContext);
            if (localObject1 != null) {
              break label812;
            }
            i = 0;
            if (i != 0) {
              localk.h = ((com.analysis.model.o)localObject1);
            }
            localObject1 = localSharedPreferences2.edit();
            ((SharedPreferences.Editor)localObject1).remove("session_start_time");
            ((SharedPreferences.Editor)localObject1).remove("last_pause");
            ((SharedPreferences.Editor)localObject1).remove("last_resume");
            ((SharedPreferences.Editor)localObject1).putString("pages", "");
            ((SharedPreferences.Editor)localObject1).commit();
            com.analysis.common.upload.o.a(localContext).a(localk);
            l1 = System.currentTimeMillis();
            localObject1 = localSharedPreferences1.edit();
            ((SharedPreferences.Editor)localObject1).putString("session_id", str);
            ((SharedPreferences.Editor)localObject1).putLong("session_start_time", l1);
            ((SharedPreferences.Editor)localObject1).putLong("last_resume", l1);
            ((SharedPreferences.Editor)localObject1).putLong("last_pause", 0L);
            ((SharedPreferences.Editor)localObject1).commit();
            com.analysis.common.tools.a.a("ALInterface", "Start new session: " + str);
          }
        }
      }
      for (;;)
      {
        return;
        if (l1 - l3 <= d.d) {
          break label897;
        }
        i = 1;
        break;
        localObject1 = String.valueOf(i);
        break label341;
        localObject1 = null;
        break label513;
        i = 1;
        break label520;
        i = 1;
        break label568;
        i = 1;
        break label599;
        localObject1 = localSharedPreferences1.getString("session_id", "null");
        l1 = System.currentTimeMillis();
        localObject2 = localSharedPreferences1.edit();
        ((SharedPreferences.Editor)localObject2).putLong("last_resume", l1);
        ((SharedPreferences.Editor)localObject2).putLong("last_pause", 0L);
        ((SharedPreferences.Editor)localObject2).commit();
        com.analysis.common.tools.a.a("ALInterface", "Extend current session: " + (String)localObject1);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/analytics/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */