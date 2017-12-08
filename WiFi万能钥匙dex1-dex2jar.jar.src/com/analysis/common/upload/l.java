package com.analysis.common.upload;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class l
  implements com.analysis.common.a, n
{
  g f;
  private Context g;
  private i h;
  private m i;
  
  public l(Context paramContext)
  {
    this.g = paramContext.getApplicationContext();
    this.f = new g(paramContext);
    this.h = i.a(paramContext);
    this.i = new m(paramContext);
  }
  
  private void a(String paramString)
  {
    i locali = this.h;
    if (!com.analysis.common.tools.c.a(paramString))
    {
      String str = "crash_" + System.currentTimeMillis();
      i.a(new File(locali.a, str), paramString);
    }
  }
  
  private void d()
  {
    int j;
    if (!b())
    {
      j = 0;
      if (j == 0) {
        break label23;
      }
      c();
    }
    for (;;)
    {
      return;
      j = 1;
      break;
      label23:
      g();
    }
  }
  
  private boolean e()
  {
    if (!b()) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    SharedPreferences localSharedPreferences = this.g.getSharedPreferences("sp_general_config", 0);
    Object localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA);
    String str = localSharedPreferences.getString("crash_date", "null");
    localObject = ((SimpleDateFormat)localObject).format(new Date());
    boolean bool1 = bool2;
    if ("Wi-Fi".equals(com.analysis.common.c.h(this.g)[0]))
    {
      bool1 = bool2;
      if (!str.equals(localObject)) {
        bool1 = true;
      }
    }
    if (bool1) {
      localSharedPreferences.edit().putString("crash_date", (String)localObject).commit();
    }
    return bool1;
  }
  
  private void g()
  {
    Object localObject1;
    if (this.f.a() > 0)
    {
      if (this.f.a() != 0) {
        break label74;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label168;
      }
    }
    label74:
    label168:
    for (int j = 0;; j = 1)
    {
      Object localObject4;
      if (j != 0)
      {
        ??? = this.h;
        localObject4 = ((h)localObject1).toString();
        if (!com.analysis.common.tools.c.a((String)localObject4))
        {
          localObject1 = ((i)???).a();
          i.a(new File(((i)???).a, (String)localObject1), (String)localObject4);
        }
      }
      return;
      localObject1 = new h();
      for (;;)
      {
        synchronized (this.f)
        {
          Iterator localIterator = ((g)???).a.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject4 = (k)localIterator.next();
          if (localObject4 == null)
          {
            j = 0;
            if (j == 0) {
              continue;
            }
            ((k)localObject4).a((h)localObject1);
          }
        }
        j = 1;
      }
      ((g)???).a.clear();
      break;
    }
  }
  
  private void h()
  {
    d locald = new d(this.g);
    if (com.analysis.common.tools.c.a(locald.j)) {
      locald.j = i.a(locald.i);
    }
    locald.j.a(new e(locald), new f(locald));
  }
  
  private h i()
  {
    h localh;
    if (this.f.a() == 0) {
      localh = null;
    }
    for (;;)
    {
      return localh;
      localh = new h();
      for (;;)
      {
        synchronized (this.f)
        {
          Iterator localIterator = ???.a.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          k localk = (k)localIterator.next();
          if (localk == null)
          {
            j = 0;
            if (j == 0) {
              continue;
            }
            localk.a(localh);
          }
        }
        int j = 1;
      }
      ???.a.clear();
    }
  }
  
  public final void a()
  {
    if (b()) {
      c();
    }
    for (;;)
    {
      return;
      com.analysis.common.tools.a.a("ALInterface", "network is unavailable");
    }
  }
  
  public final void a(k paramk)
  {
    boolean bool = paramk instanceof com.analysis.model.k;
    int j;
    if (paramk == null)
    {
      j = 0;
      if (j != 0)
      {
        if (bool)
        {
          com.analysis.model.k localk = (com.analysis.model.k)paramk;
          this.f.a(localk.f);
          g localg = this.f;
          List localList = localk.g;
          localg.a.addAll(localList);
          this.f.a(localk.h);
        }
        this.f.a(paramk);
      }
      if (b()) {
        break label106;
      }
      j = 0;
      label92:
      if (j == 0) {
        break label111;
      }
      c();
    }
    for (;;)
    {
      return;
      j = 1;
      break;
      label106:
      j = 1;
      break label92;
      label111:
      g();
    }
  }
  
  public final void b(k paramk)
  {
    if (paramk == null) {}
    for (int j = 0;; j = 1)
    {
      if (j != 0) {
        this.f.a(paramk);
      }
      return;
    }
  }
  
  final boolean b()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.g.getSystemService("connectivity")).getActiveNetworkInfo();
    int j;
    if (localNetworkInfo == null)
    {
      j = 0;
      if (j == 0) {
        break label38;
      }
    }
    label38:
    for (boolean bool = localNetworkInfo.isConnectedOrConnecting();; bool = false)
    {
      return bool;
      j = 1;
      break;
    }
  }
  
  final void c()
  {
    int k = 0;
    g();
    Object localObject1 = new a(this.g);
    if (com.analysis.common.tools.c.a(((a)localObject1).n)) {
      ((a)localObject1).n = i.a(((a)localObject1).m);
    }
    ((a)localObject1).n.a(new b((a)localObject1), new c((a)localObject1));
    SharedPreferences localSharedPreferences = this.g.getSharedPreferences("sp_general_config", 0);
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA);
    localObject1 = localSharedPreferences.getString("crash_date", "null");
    localObject2 = ((SimpleDateFormat)localObject2).format(new Date());
    int j = k;
    if ("Wi-Fi".equals(com.analysis.common.c.h(this.g)[0]))
    {
      j = k;
      if (!((String)localObject1).equals(localObject2)) {
        j = 1;
      }
    }
    if (j != 0) {
      localSharedPreferences.edit().putString("crash_date", (String)localObject2).commit();
    }
    if (j != 0) {
      new d(this.g).a();
    }
  }
  
  public final void c(k paramk)
  {
    if (com.analysis.common.tools.c.a(paramk)) {}
    for (;;)
    {
      return;
      String str1 = paramk.toString();
      paramk = this.h;
      if (!com.analysis.common.tools.c.a(str1))
      {
        String str2 = "crash_" + System.currentTimeMillis();
        i.a(new File(paramk.a, str2), str1);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */