package com.wifi.connect.d;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.bluefay.b.h;
import com.c.a.a.a.d.a.a.a.a;
import com.c.a.a.a.d.a.a.a.a.a;
import com.c.a.a.a.d.a.a.a.a.b;
import com.c.a.a.a.d.a.a.a.a.b.a;
import com.lantern.core.e;
import com.lantern.core.k;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.n;
import com.lantern.core.o;
import java.util.ArrayList;

public final class i
  extends AsyncTask<String, Integer, Integer>
{
  private int a;
  private int b;
  private com.bluefay.b.a c;
  private WkAccessPoint d;
  private String e;
  private ArrayList<WkAccessPoint> f;
  private com.wifi.connect.model.f g;
  private boolean h;
  private boolean i = false;
  
  public i(WkAccessPoint paramWkAccessPoint, String paramString, int paramInt1, int paramInt2, ArrayList<WkAccessPoint> paramArrayList, com.bluefay.b.a parama)
  {
    this.d = paramWkAccessPoint;
    this.e = paramString;
    this.a = paramInt1;
    this.b = paramInt2;
    this.f = paramArrayList;
    this.c = parama;
    this.h = com.lantern.core.f.e();
  }
  
  public i(WkAccessPoint paramWkAccessPoint, String paramString, int paramInt1, int paramInt2, ArrayList<WkAccessPoint> paramArrayList, boolean paramBoolean, com.bluefay.b.a parama)
  {
    this.d = paramWkAccessPoint;
    this.e = paramString;
    this.a = paramInt1;
    this.b = paramInt2;
    this.f = paramArrayList;
    this.c = parama;
    this.h = com.lantern.core.f.e();
    this.i = paramBoolean;
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (this.i) {}
    String str1;
    for (Object localObject1 = "00302012";; str1 = "00302000")
    {
      if (!com.lantern.core.c.getServer().a("00302000", paramBoolean1)) {}
      Object localObject2;
      for (;;)
      {
        return j;
        localObject2 = com.lantern.core.c.getServer().v();
        Context localContext = com.bluefay.d.a.getAppContext();
        Object localObject4 = this.d;
        String str2 = this.e;
        j = this.a;
        ArrayList localArrayList = this.f;
        Object localObject3 = a.a.l();
        ((a.a.a)localObject3).c(((WkAccessPoint)localObject4).a());
        ((a.a.a)localObject3).b(((WkAccessPoint)localObject4).b());
        ((a.a.a)localObject3).b(((WkAccessPoint)localObject4).c);
        ((a.a.a)localObject3).a(n.a(Uri.encode(str2), com.lantern.core.c.getServer().l(), com.lantern.core.c.getServer().m()));
        ((a.a.a)localObject3).a(j);
        ((a.a.a)localObject3).f(k.i(localContext));
        ((a.a.a)localObject3).e(k.h(localContext));
        ((a.a.a)localObject3).d(k.f(localContext));
        ((a.a.a)localObject3).g(String.valueOf(((WkAccessPoint)localObject4).d));
        for (j = 0; j < localArrayList.size(); j++)
        {
          localObject4 = a.a.b.l();
          ((a.a.b.a)localObject4).b(((WkAccessPoint)localArrayList.get(j)).b());
          ((a.a.b.a)localObject4).c(((WkAccessPoint)localArrayList.get(j)).d);
          ((a.a.b.a)localObject4).a(((WkAccessPoint)localArrayList.get(j)).c);
          ((a.a.b.a)localObject4).a(((WkAccessPoint)localArrayList.get(j)).a());
          ((a.a.a)localObject3).a((a.a.b)((a.a.b.a)localObject4).c());
        }
        localObject3 = ((a.a)((a.a.a)localObject3).c()).b();
        com.lantern.core.c.getServer();
        localObject2 = e.a((String)localObject2, o.a((String)localObject1, (byte[])localObject3));
        if ((localObject2 != null) && (localObject2.length != 0)) {
          break;
        }
        j = 10;
      }
      h.a(com.bluefay.b.c.a((byte[])localObject2), new Object[0]);
      for (;;)
      {
        try
        {
          com.lantern.core.c.getServer();
          localObject1 = o.b((String)localObject1, (byte[])localObject2);
          boolean bool = ((com.lantern.core.h.a)localObject1).c();
          if (!bool) {
            continue;
          }
          j = 1;
        }
        catch (Exception localException)
        {
          h.a(localException);
          j = 30;
          continue;
          this.g = null;
          j = 30;
          continue;
        }
        h.b("retcode=%s", new Object[] { Integer.valueOf(j) });
        if (j != 1) {
          continue;
        }
        this.g = new com.wifi.connect.model.f();
        this.g.a("0");
        this.g.a = this.a;
        this.g.b = this.b;
        break;
        if ((paramBoolean1) && (!paramBoolean2) && ((((com.lantern.core.h.a)localObject1).d()) || (((com.lantern.core.h.a)localObject1).e())))
        {
          com.lantern.core.c.getServer().b("00302000", ((com.lantern.core.h.a)localObject1).b());
          j = a(true, true);
          break;
        }
        j = 1;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */