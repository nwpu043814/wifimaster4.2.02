package com.wifi.connect.plugin.ssrp.d;

import com.bluefay.b.h;
import com.c.a.a.a.a.a.a.a.a;
import com.c.a.a.a.a.a.a.a.a.a;
import com.c.a.a.a.a.a.a.a.a.b;
import com.c.a.a.a.a.a.a.a.a.b.a;
import com.lantern.core.e;
import com.lantern.core.f;
import com.lantern.core.k;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import com.wifi.connect.plugin.ssrp.c.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements Runnable
{
  private boolean a;
  private b b;
  private ArrayList<b> c;
  private boolean d;
  
  public a()
  {
    this.a = false;
    this.d = f.e();
  }
  
  public a(b paramb)
  {
    this.a = true;
    this.b = paramb;
    this.d = false;
  }
  
  private static void a(b paramb, boolean paramBoolean)
  {
    h.a("upload one start");
    if (paramb == null) {
      return;
    }
    com.lantern.core.c.getServer().f("00302003");
    String str = com.lantern.core.c.getServer().v();
    a.a.a locala = a.a.l();
    if (paramb.b != null)
    {
      localObject = paramb.b;
      locala.b((String)localObject);
      if (paramb.c == null) {
        break label400;
      }
      localObject = paramb.c;
      label66:
      locala.c((String)localObject);
      if (paramb.f == null) {
        break label407;
      }
      localObject = paramb.f;
      label87:
      locala.f((String)localObject);
      if (paramb.g == null) {
        break label414;
      }
      localObject = paramb.g;
      label108:
      locala.g((String)localObject);
      if (paramb.e == null) {
        break label421;
      }
      localObject = paramb.e;
      label129:
      locala.l((String)localObject);
      if (paramb.d == null) {
        break label428;
      }
      localObject = paramb.d;
      label150:
      locala.e((String)localObject);
      if (paramb.a == null) {
        break label435;
      }
      localObject = paramb.a;
      label171:
      locala.a((String)localObject);
      if (paramb.m == null) {
        break label442;
      }
      localObject = paramb.m;
      label192:
      locala.k((String)localObject);
      locala.h(k.f(com.bluefay.d.a.getAppContext()));
      locala.i(k.h(com.bluefay.d.a.getAppContext()));
      locala.j(k.i(com.lantern.core.c.getAppContext()));
      if (paramb.n == null) {
        break label449;
      }
    }
    label400:
    label407:
    label414:
    label421:
    label428:
    label435:
    label442:
    label449:
    for (Object localObject = paramb.n;; localObject = "")
    {
      locala.d((String)localObject);
      if (paramb.h == null) {
        break label456;
      }
      ArrayList localArrayList = paramb.h;
      for (i = 0; i < paramb.h.size(); i++)
      {
        localObject = a.a.b.l();
        ((a.a.b.a)localObject).b(((WkAccessPoint)localArrayList.get(i)).b());
        ((a.a.b.a)localObject).c(((WkAccessPoint)localArrayList.get(i)).d);
        ((a.a.b.a)localObject).a(((WkAccessPoint)localArrayList.get(i)).c);
        ((a.a.b.a)localObject).a(((WkAccessPoint)localArrayList.get(i)).a());
        locala.a((a.a.b)((a.a.b.a)localObject).c());
      }
      localObject = "";
      break;
      localObject = "";
      break label66;
      localObject = "";
      break label87;
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
    }
    label456:
    localObject = ((a.a)locala.c()).b();
    com.lantern.core.c.getServer();
    localObject = e.a(str, o.a("00302003", (byte[])localObject));
    h.a(com.bluefay.b.c.a((byte[])localObject), new Object[0]);
    if ((localObject == null) || (localObject.length == 0)) {}
    for (int i = 10;; i = 0)
    {
      try
      {
        com.lantern.core.c.getServer();
        boolean bool = o.b("00302003", (byte[])localObject).c();
        if (bool) {
          i = 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(localException);
          i = 30;
        }
      }
      h.b("ssrpretcode=%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        if (paramBoolean) {
          break;
        }
        new com.wifi.connect.plugin.ssrp.a.a(com.lantern.core.c.getAppContext()).a(paramb.i);
        break;
      }
      if (!paramBoolean) {
        break;
      }
      new com.wifi.connect.plugin.ssrp.a.a(com.lantern.core.c.getAppContext()).a(paramb);
      break;
    }
  }
  
  public final void run()
  {
    if ((this.a) && (this.b != null)) {
      a(this.b, true);
    }
    for (;;)
    {
      return;
      Object localObject;
      if ((this.a) && (this.c != null))
      {
        localObject = this.c;
        h.a("upload mutil start");
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((b)((Iterator)localObject).next(), true);
        }
      }
      else
      {
        h.a("upload all start");
        localObject = new com.wifi.connect.plugin.ssrp.a.a(com.lantern.core.c.getAppContext()).a();
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          h.c("list files count is 0");
        }
        else
        {
          int j = ((List)localObject).size();
          for (int i = 0; i < j; i++) {
            a((b)((List)localObject).get(i), false);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */