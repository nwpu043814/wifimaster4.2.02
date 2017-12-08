package com.wifi.connect.c;

import com.c.a.a.a.a.a.a.a.a;
import com.c.a.a.a.a.a.a.a.a.a;
import com.c.a.a.a.a.a.a.a.a.b;
import com.c.a.a.a.a.a.a.a.a.b.a;
import com.lantern.core.b;
import com.lantern.core.e;
import com.lantern.core.f;
import com.lantern.core.k;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  implements Runnable
{
  private boolean a;
  private com.wifi.connect.model.g b;
  private ArrayList<com.wifi.connect.model.g> c;
  private boolean d;
  
  public g()
  {
    this.a = false;
    this.d = f.e();
  }
  
  public g(com.wifi.connect.model.g paramg)
  {
    this.a = true;
    this.b = paramg;
    this.d = false;
  }
  
  private void a(com.wifi.connect.model.g paramg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    com.bluefay.b.h.a("upload one start");
    if (paramg == null) {}
    for (;;)
    {
      return;
      if (com.lantern.core.c.getServer().a("00302003", paramBoolean2)) {
        break;
      }
      com.bluefay.b.h.a("init dev failed");
    }
    String str = com.lantern.core.c.getServer().v();
    a.a.a locala = a.a.l();
    if (paramg.b != null)
    {
      localObject = paramg.b;
      locala.b((String)localObject);
      if (paramg.c == null) {
        break label415;
      }
      localObject = paramg.c;
      label77:
      locala.c((String)localObject);
      locala.f(paramg.a());
      if (paramg.g == null) {
        break label422;
      }
      localObject = paramg.g;
      label108:
      locala.g((String)localObject);
      if (paramg.e == null) {
        break label429;
      }
      localObject = paramg.e;
      label129:
      locala.l((String)localObject);
      if (paramg.d == null) {
        break label436;
      }
      localObject = paramg.d;
      label150:
      locala.e((String)localObject);
      if (paramg.a == null) {
        break label443;
      }
      localObject = paramg.a;
      label171:
      locala.a((String)localObject);
      if (paramg.m == null) {
        break label450;
      }
      localObject = paramg.m;
      label192:
      locala.k((String)localObject);
      locala.h(k.f(com.bluefay.d.a.getAppContext()));
      locala.i(k.h(com.bluefay.d.a.getAppContext()));
      locala.j(k.i(com.lantern.core.c.getAppContext()));
      if (paramg.n == null) {
        break label457;
      }
      localObject = paramg.n;
      label249:
      locala.d((String)localObject);
      locala.f(paramg.a());
      if (paramg.o == null) {
        break label464;
      }
    }
    label415:
    label422:
    label429:
    label436:
    label443:
    label450:
    label457:
    label464:
    for (Object localObject = paramg.o;; localObject = "")
    {
      locala.m((String)localObject);
      if (paramg.h == null) {
        break label471;
      }
      ArrayList localArrayList = paramg.h;
      for (i = 0; i < localArrayList.size(); i++)
      {
        a.a.b.a locala1 = a.a.b.l();
        localObject = (WkAccessPoint)localArrayList.get(i);
        locala1.b(((WkAccessPoint)localObject).b());
        locala1.c(((WkAccessPoint)localObject).d);
        locala1.a(((WkAccessPoint)localObject).c);
        locala1.a(((WkAccessPoint)localObject).a());
        locala.a((a.a.b)locala1.c());
      }
      localObject = "";
      break;
      localObject = "";
      break label77;
      localObject = "";
      break label108;
      localObject = "";
      break label129;
      localObject = "";
      break label150;
      localObject = "";
      break label171;
      localObject = "";
      break label192;
      localObject = "";
      break label249;
    }
    label471:
    localObject = ((a.a)locala.c()).b();
    com.lantern.core.c.getServer();
    localObject = e.a(str, o.a("00302003", (byte[])localObject));
    com.bluefay.b.h.a(com.bluefay.b.c.a((byte[])localObject), new Object[0]);
    if ((localObject == null) || (localObject.length == 0)) {}
    for (int i = 10;; i = 0)
    {
      label605:
      do
      {
        do
        {
          do
          {
            try
            {
              com.lantern.core.c.getServer();
              localObject = o.b("00302003", (byte[])localObject);
              boolean bool = ((com.lantern.core.h.a)localObject).c();
              if (!bool) {
                break label605;
              }
              j = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                com.bluefay.b.h.a(localException);
                int j = 30;
              }
            }
            com.bluefay.b.h.b("retcode=%s", new Object[] { Integer.valueOf(j) });
            if (j != 1) {
              break label681;
            }
            if (paramBoolean1) {
              break;
            }
            new h(com.lantern.core.c.getAppContext()).a(paramg.i);
            break;
            j = i;
          } while (!paramBoolean2);
          j = i;
        } while (paramBoolean3);
        if (((com.lantern.core.h.a)localObject).d()) {
          break label642;
        }
        j = i;
      } while (!((com.lantern.core.h.a)localObject).e());
      label642:
      com.lantern.core.c.getServer().b("00302003", ((com.lantern.core.h.a)localObject).b());
      a(paramg, paramBoolean1, true, true);
      break;
      label681:
      if (!paramBoolean1) {
        break;
      }
      new h(com.lantern.core.c.getAppContext()).a(paramg);
      break;
    }
  }
  
  private void a(ArrayList<com.wifi.connect.model.g> paramArrayList, boolean paramBoolean)
  {
    com.bluefay.b.h.a("upload mutil start");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((com.wifi.connect.model.g)paramArrayList.next(), true, paramBoolean, false);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    com.bluefay.b.h.a("upload all start");
    List localList = new h(com.lantern.core.c.getAppContext()).a();
    if ((localList == null) || (localList.size() == 0)) {
      com.bluefay.b.h.c("list files count is 0");
    }
    for (;;)
    {
      return;
      int j = localList.size();
      for (int i = 0; i < j; i++) {
        a((com.wifi.connect.model.g)localList.get(i), false, paramBoolean, false);
      }
    }
  }
  
  public final void run()
  {
    if ("D".equals(b.a())) {
      if ((this.a) && (this.b != null)) {
        a(this.b, true, true, false);
      }
    }
    for (;;)
    {
      return;
      if ((this.a) && (this.c != null))
      {
        a(this.c, true);
      }
      else
      {
        a(true);
        continue;
        if ((this.a) && (this.b != null)) {
          a(this.b, true, false, false);
        } else if ((this.a) && (this.c != null)) {
          a(this.c, false);
        } else {
          a(false);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */