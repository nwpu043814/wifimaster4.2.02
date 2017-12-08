package com.wifi.connect.plugin.magickey.c;

import com.bluefay.b.h;
import com.c.a.a.a.a.a.a.a.a;
import com.c.a.a.a.a.a.a.a.a.a;
import com.c.a.a.a.a.a.a.a.a.b;
import com.c.a.a.a.a.a.a.a.a.b.a;
import com.lantern.core.f;
import com.lantern.core.k;
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
  private ArrayList<b> c;
  private boolean d;
  
  public e()
  {
    this.a = false;
    this.d = f.e();
  }
  
  public e(b paramb)
  {
    this.a = true;
    this.b = paramb;
    this.d = false;
  }
  
  public e(ArrayList<b> paramArrayList)
  {
    this.a = true;
    this.c = paramArrayList;
    this.d = true;
  }
  
  private void a(b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    h.a("upload one start");
    if (paramb == null) {}
    for (;;)
    {
      return;
      if (com.lantern.core.c.getServer().a("00302003", paramBoolean2)) {
        break;
      }
      h.a("init dev failed");
    }
    String str = com.lantern.core.c.getServer().v();
    a.a.a locala = a.a.l();
    if (paramb.b != null)
    {
      localObject = paramb.b;
      locala.b((String)localObject);
      if (paramb.c == null) {
        break label436;
      }
      localObject = paramb.c;
      label77:
      locala.c((String)localObject);
      if (paramb.f == null) {
        break label443;
      }
      localObject = paramb.f;
      label98:
      locala.f((String)localObject);
      if (paramb.g == null) {
        break label450;
      }
      localObject = paramb.g;
      label119:
      locala.g((String)localObject);
      if (paramb.e == null) {
        break label457;
      }
      localObject = paramb.e;
      label140:
      locala.l((String)localObject);
      if (paramb.d == null) {
        break label464;
      }
      localObject = paramb.d;
      label161:
      locala.e((String)localObject);
      if (paramb.a == null) {
        break label471;
      }
      localObject = paramb.a;
      label182:
      locala.a((String)localObject);
      locala.k(paramb.a());
      locala.h(k.f(com.bluefay.d.a.getAppContext()));
      locala.i(k.h(com.bluefay.d.a.getAppContext()));
      locala.j(k.i(com.lantern.core.c.getAppContext()));
      if (paramb.n == null) {
        break label478;
      }
      localObject = paramb.n;
      label249:
      locala.m((String)localObject);
      if (paramb.o == null) {
        break label485;
      }
      localObject = paramb.o;
      label270:
      locala.n((String)localObject);
      locala.k(paramb.a());
      if (paramb.p == null) {
        break label492;
      }
    }
    int i;
    label436:
    label443:
    label450:
    label457:
    label464:
    label471:
    label478:
    label485:
    label492:
    for (Object localObject = paramb.p;; localObject = "")
    {
      locala.d((String)localObject);
      if (paramb.h == null) {
        break label499;
      }
      ArrayList localArrayList = paramb.h;
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
      break label98;
      localObject = "";
      break label119;
      localObject = "";
      break label140;
      localObject = "";
      break label161;
      localObject = "";
      break label182;
      localObject = "";
      break label249;
      localObject = "";
      break label270;
    }
    label499:
    localObject = ((a.a)locala.c()).b();
    com.lantern.core.c.getServer();
    localObject = com.lantern.core.e.a(str, o.a("00302003", (byte[])localObject));
    h.a(com.bluefay.b.c.a((byte[])localObject), new Object[0]);
    if ((localObject == null) || (localObject.length == 0)) {}
    for (int j = 10;; j = 0)
    {
      label633:
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
                break label633;
              }
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                h.a(localException);
                i = 30;
              }
            }
            h.b("retcode=%s", new Object[] { Integer.valueOf(i) });
            if (i != 1) {
              break label709;
            }
            if (paramBoolean1) {
              break;
            }
            new c(com.lantern.core.c.getAppContext()).a(paramb.i);
            break;
            i = j;
          } while (!paramBoolean2);
          i = j;
        } while (paramBoolean3);
        if (((com.lantern.core.h.a)localObject).d()) {
          break label670;
        }
        i = j;
      } while (!((com.lantern.core.h.a)localObject).e());
      label670:
      com.lantern.core.c.getServer().b("00302003", ((com.lantern.core.h.a)localObject).b());
      a(paramb, paramBoolean1, true, true);
      break;
      label709:
      if (!paramBoolean1) {
        break;
      }
      new c(com.lantern.core.c.getAppContext()).a(paramb);
      break;
    }
  }
  
  private void a(ArrayList<b> paramArrayList, boolean paramBoolean)
  {
    h.a("upload mutil start");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((b)paramArrayList.next(), true, paramBoolean, false);
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
      int j = localList.size();
      for (int i = 0; i < j; i++) {
        a((b)localList.get(i), false, paramBoolean, false);
      }
    }
  }
  
  public final void run()
  {
    if ("D".equals(com.lantern.core.b.a())) {
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */