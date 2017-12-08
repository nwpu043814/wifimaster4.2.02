package com.analysis.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.analysis.common.upload.k;
import com.analysis.common.upload.o;
import com.analysis.model.crash.d;
import com.analysis.model.f;
import com.analysis.model.i;
import com.analysis.model.j;
import com.analysis.model.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements d
{
  private static final String f = "ALInterface";
  Context a = null;
  m b = new m();
  i c = new i();
  f d;
  boolean e = false;
  private o g;
  private com.analysis.model.crash.a h = new com.analysis.model.crash.a();
  
  public a()
  {
    this.h.a = this;
  }
  
  private void a()
  {
    if (this.a != null) {
      this.a.getSharedPreferences("sp_general_config", 0).edit().remove("login_name").commit();
    }
  }
  
  private static void a(Context paramContext, double paramDouble1, double paramDouble2)
  {
    String str = paramDouble2 + "*" + paramDouble1;
    paramContext.getSharedPreferences("sp_general_config", 0).edit().putString("session_location", str).putLong("session_location_time", System.currentTimeMillis()).commit();
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    paramContext.getSharedPreferences("sp_general_config", 0).edit().putInt("app_city", paramInt).commit();
  }
  
  private void a(Context paramContext, String paramString)
  {
    if (com.analysis.common.tools.c.a(paramContext)) {
      com.analysis.common.tools.a.c("ALInterface", "context is null");
    }
    for (;;)
    {
      return;
      i locali = this.c;
      if (com.analysis.common.tools.c.b(paramString)) {}
      synchronized (locali.f)
      {
        locali.f.put(paramString, Long.valueOf(System.currentTimeMillis()));
        if (!this.e) {
          a(paramContext);
        }
        g.a(new b(this));
      }
    }
  }
  
  private void a(Context paramContext, String paramString, int paramInt, Map<String, String> paramMap)
  {
    if (!this.e) {
      a(paramContext);
    }
    this.d.a.a(paramString, paramInt, paramMap);
  }
  
  private void b(Context paramContext, String paramString)
  {
    if (com.analysis.common.tools.c.a(paramContext)) {
      com.analysis.common.tools.a.c("ALInterface", "context is null");
    }
    for (;;)
    {
      return;
      this.c.a(paramString);
      paramString = this.c;
      Object localObject1 = paramContext.getSharedPreferences("sp_general_config", 0);
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
      if (paramString.g.size() > 0)
      {
        ??? = ((SharedPreferences)localObject1).getString("save_pages", null);
        localObject1 = new com.analysis.common.b();
        if (com.analysis.common.tools.c.b((String)???))
        {
          ((com.analysis.common.b)localObject1).a((String)???);
          ((com.analysis.common.b)localObject1).a(";");
        }
        synchronized (paramString.g)
        {
          Iterator localIterator = paramString.g.iterator();
          if (localIterator.hasNext())
          {
            j localj = (j)localIterator.next();
            ((com.analysis.common.b)localObject1).a(String.format("[\"%s\",%d,%d]", new Object[] { localj.a, Long.valueOf(localj.b), Long.valueOf(localj.c) }));
            ((com.analysis.common.b)localObject1).a(";");
          }
        }
        paramString.g.clear();
        int i = ((com.analysis.common.b)localObject1).f.length();
        ((com.analysis.common.b)localObject1).f.deleteCharAt(i - 1);
        localEditor.remove("save_pages");
        localEditor.putString("save_pages", ((com.analysis.common.b)localObject1).toString());
      }
      localEditor.commit();
      if (!this.e) {
        a(paramContext);
      }
      g.a(new c(this));
    }
  }
  
  private void c(Context paramContext, String paramString)
  {
    if (!this.e) {
      a(paramContext);
    }
    this.d.a.a(paramString, 0, null);
  }
  
  private void d(Context paramContext, String paramString)
  {
    if (this.a != null) {
      this.a.getSharedPreferences("sp_general_config", 0).edit().putString("login_name", paramString).commit();
    }
    for (;;)
    {
      return;
      if (paramContext != null) {
        paramContext.getSharedPreferences("sp_general_config", 0).edit().putString("login_name", paramString).commit();
      }
    }
  }
  
  private static void e(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("sp_general_config", 0).edit().putString("app_1d", paramString).commit();
  }
  
  private static void f(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("sp_general_config", 0).edit().putString("crash_module", paramString).commit();
  }
  
  private static void g(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("sp_general_config", 0).edit().putString("version_name", paramString).commit();
  }
  
  final void a(Context paramContext)
  {
    if (!this.e)
    {
      this.e = true;
      this.a = paramContext.getApplicationContext();
      this.g = o.a(this.a);
      this.d = new f(this.a);
    }
  }
  
  public final void a(Throwable paramThrowable)
  {
    int i;
    Object localObject2;
    i locali;
    long l;
    if (paramThrowable == null)
    {
      i = 0;
      if (i == 0) {
        break label216;
      }
      ??? = new com.analysis.model.crash.c(this.a);
      localObject2 = paramThrowable.getClass().getName().split("\\.");
      ((com.analysis.model.crash.c)???).f = localObject2[(localObject2.length - 1)];
      ((com.analysis.model.crash.c)???).r = com.analysis.model.crash.c.a(paramThrowable);
      this.g.c((k)???);
      locali = this.c;
      paramThrowable = null;
      l = 0L;
    }
    label216:
    label226:
    for (;;)
    {
      synchronized (locali.f)
      {
        localObject2 = locali.f.entrySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          if (((Long)localEntry.getValue()).longValue() <= l) {
            break label226;
          }
          l = ((Long)localEntry.getValue()).longValue();
          paramThrowable = (String)localEntry.getKey();
          continue;
          i = 1;
          break;
        }
        if (com.analysis.common.tools.c.b(paramThrowable)) {
          locali.a(paramThrowable);
        }
        this.a.getSharedPreferences("sp_general_config", 0).edit().commit();
        g.a();
        return;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/analytics/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */