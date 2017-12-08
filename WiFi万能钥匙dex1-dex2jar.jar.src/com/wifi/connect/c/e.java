package com.wifi.connect.c;

import com.bluefay.b.h;
import com.c.a.a.a.e.a.a.a;
import com.c.a.a.a.e.a.a.a.a;
import com.c.a.a.a.e.a.a.a.b;
import com.c.a.a.a.e.a.a.a.b.a;
import com.c.a.a.a.e.a.a.a.d;
import com.c.a.a.a.e.a.a.a.d.a;
import com.lantern.core.h.a;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  implements Runnable
{
  private boolean a;
  private b b;
  
  public e()
  {
    this.a = false;
  }
  
  public e(b paramb)
  {
    this.a = true;
    this.b = paramb;
  }
  
  private void a(b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    h.a("upload one start");
    if (paramb == null) {
      return;
    }
    Object localObject1;
    if (com.lantern.core.c.getServer().a("00302004", paramBoolean2))
    {
      a.a.a locala = a.a.l();
      a.a.b.a locala1 = a.a.b.l();
      Object localObject2;
      if (paramb.b != null)
      {
        localObject1 = paramb.b;
        localObject2 = locala1.a((String)localObject1);
        if (paramb.a == null) {
          break label200;
        }
        localObject1 = paramb.a;
        label67:
        localObject2 = ((a.a.b.a)localObject2).b((String)localObject1);
        if (paramb.c == null) {
          break label207;
        }
      }
      label200:
      label207:
      for (localObject1 = paramb.c;; localObject1 = "")
      {
        ((a.a.b.a)localObject2).c((String)localObject1).d(String.valueOf(System.currentTimeMillis()));
        localObject2 = paramb.d.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (WkAccessPoint)((Iterator)localObject2).next();
          locala1.a((a.a.d)a.a.d.l().d(String.valueOf(((WkAccessPoint)localObject1).d)).b(((WkAccessPoint)localObject1).b()).c(String.valueOf(((WkAccessPoint)localObject1).c)).a(((WkAccessPoint)localObject1).a()).c());
        }
        localObject1 = "";
        break;
        localObject1 = "";
        break label67;
      }
      locala.a((a.a.b)locala1.c());
      localObject1 = ((a.a)locala.c()).b();
      com.lantern.core.c.getServer();
      localObject1 = o.a("00302004", (byte[])localObject1);
      localObject1 = com.lantern.core.e.a(com.lantern.core.c.getServer().v(), (byte[])localObject1);
      h.a(com.bluefay.b.c.a((byte[])localObject1), new Object[0]);
      if ((localObject1 != null) && (localObject1.length != 0)) {
        break label468;
      }
    }
    label370:
    label407:
    label446:
    label468:
    for (int j = 10;; j = 0)
    {
      do
      {
        do
        {
          do
          {
            try
            {
              com.lantern.core.c.getServer();
              localObject1 = o.b("00302004", (byte[])localObject1);
              boolean bool = ((a)localObject1).c();
              if (!bool) {
                break label370;
              }
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                h.a(localException);
                int i = 30;
              }
            }
            h.b("retcode=%s", new Object[] { Integer.valueOf(i) });
            if (i != 1) {
              break label446;
            }
            if (paramBoolean1) {
              break;
            }
            new c(com.lantern.core.c.getAppContext()).a(paramb.e);
            break;
            i = j;
          } while (!paramBoolean2);
          i = j;
        } while (paramBoolean3);
        if (((a)localObject1).d()) {
          break label407;
        }
        i = j;
      } while (!((a)localObject1).e());
      com.lantern.core.c.getServer().b("00302004", ((a)localObject1).b());
      a(paramb, paramBoolean1, true, true);
      break;
      if (!paramBoolean1) {
        break;
      }
      new c(com.lantern.core.c.getAppContext()).a(paramb);
      break;
      break;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    h.a("upload all start");
    List localList = new c(com.lantern.core.c.getAppContext()).a();
    if ((localList == null) || (localList.size() == 0)) {
      h.c("list files count is 0");
    }
    for (;;)
    {
      return;
      if (com.lantern.core.c.getServer().a("00302004", paramBoolean))
      {
        int j = localList.size();
        for (int i = 0; i < j; i++) {
          a((b)localList.get(i), false, paramBoolean, false);
        }
      }
    }
  }
  
  public final void run()
  {
    if ("D".equals(com.lantern.core.b.a())) {
      if (this.a) {
        a(this.b, true, true, false);
      }
    }
    for (;;)
    {
      return;
      a(true);
      continue;
      if (this.a) {
        a(this.b, true, false, false);
      } else {
        a(false);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */