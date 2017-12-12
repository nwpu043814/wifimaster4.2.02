package com.wifi.backup.c;

import android.os.AsyncTask;
import com.bluefay.b.h;
import com.c.a.a.a.b.c.a.a.a;
import com.c.a.a.a.b.c.a.a.a.b;
import com.lantern.core.e;
import com.lantern.core.o;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private List<com.wifi.backup.c.a.a> b;
  private String c = "";
  
  public a(com.bluefay.b.a parama)
  {
    this.a = parama;
    this.b = new ArrayList();
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    int j = 0;
    int i;
    if (!com.bluefay.a.a.c(com.bluefay.d.a.getAppContext())) {
      i = 10;
    }
    for (;;)
    {
      return i;
      if (!com.lantern.core.c.getServer().a("00302008", paramBoolean1))
      {
        i = 0;
        continue;
      }
      Object localObject = com.lantern.core.c.getServer().v();//apurl
      com.lantern.core.c.getServer();
      localObject = e.a((String)localObject, o.a("00302008", new byte[0]));
      if ((localObject == null) || (localObject.length == 0))
      {
        i = 10;
        continue;
      }
      h.a(com.bluefay.b.c.a((byte[])localObject), new Object[0]);
      com.lantern.core.c.getServer();
      localObject = o.b("00302008", (byte[])localObject);
      if (!((com.lantern.core.h.a)localObject).c())
      {
        h.a("mResponse:" + localObject, new Object[0]);
        if ((paramBoolean1) && (!paramBoolean2) && ((((com.lantern.core.h.a)localObject).d()) || (((com.lantern.core.h.a)localObject).e())))
        {
          com.lantern.core.c.getServer().b("00302008", ((com.lantern.core.h.a)localObject).b());
          paramBoolean2 = true;
          paramBoolean1 = true;
          break;
        }
        i = 10;
        continue;
      }
      try
      {
        List localList = a.a.a(((com.lantern.core.h.a)localObject).g()).l();
        i = k;
        if (localList == null) {
          continue;
        }
        i = k;
        if (localList.size() <= 0) {
          continue;
        }
        for (;;)
        {
          i = k;
          if (j >= localList.size()) {
            break;
          }
          localObject = new com/wifi/backup/c/a/a;
          ((com.wifi.backup.c.a.a)localObject).<init>();
          a.a.b localb = (a.a.b)localList.get(j);
          ((com.wifi.backup.c.a.a)localObject).d(localb.l());
          ((com.wifi.backup.c.a.a)localObject).e(localb.m());
          ((com.wifi.backup.c.a.a)localObject).f(String.valueOf(localb.n()));
          ((com.wifi.backup.c.a.a)localObject).g(localb.p());
          ((com.wifi.backup.c.a.a)localObject).h(localb.q());
          ((com.wifi.backup.c.a.a)localObject).a(localb.r());
          ((com.wifi.backup.c.a.a)localObject).c(localb.o());
          ((com.wifi.backup.c.a.a)localObject).a("0");
          this.b.add(localObject);
          j++;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i = k;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */