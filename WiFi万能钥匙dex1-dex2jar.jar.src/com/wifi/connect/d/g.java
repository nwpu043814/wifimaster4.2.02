package com.wifi.connect.d;

import android.os.AsyncTask;
import com.bluefay.b.h;
import com.c.a.a.a.c.b.a.a;
import com.c.a.a.a.c.b.a.a.a;
import com.c.a.a.a.c.b.b.a;
import com.lantern.core.e;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;

public final class g
  extends AsyncTask<String, Integer, Integer>
{
  private WkAccessPoint a;
  private com.bluefay.b.a b;
  
  public g(WkAccessPoint paramWkAccessPoint, com.bluefay.b.a parama)
  {
    this.a = paramWkAccessPoint;
    this.b = parama;
  }
  
  private int a()
  {
    int j = 0;
    h.a("queryApKeyPB", new Object[0]);
    int i;
    try
    {
      if (!com.lantern.core.c.getServer().a("00302101", false)) {
        i = j;
      }
      for (;;)
      {
        return i;
        i = j;
        if (this.a != null)
        {
          Object localObject1 = com.lantern.core.c.getServer().v();//apurl
          Object localObject2 = this.a;
          a.a.a locala1 = a.a.l();
          locala1.a(((WkAccessPoint)localObject2).b());
          locala1.b(((WkAccessPoint)localObject2).a());
          locala1.c(String.valueOf(((WkAccessPoint)localObject2).c));
          localObject2 = ((a.a)locala1.c()).b();
          com.lantern.core.c.getServer();
          localObject1 = e.a((String)localObject1, o.a("00302101", (byte[])localObject2), 30000, 30000);
          i = j;
          if (localObject1 != null)
          {
            i = j;
            if (localObject1.length != 0)
            {
              h.a(com.bluefay.b.c.a((byte[])localObject1), new Object[0]);
              com.lantern.core.c.getServer();
              localObject1 = o.b("00302101", (byte[])localObject1);
              if (((com.lantern.core.h.a)localObject1).c()) {
                break;
              }
              localObject2 = new com/wifi/connect/model/c;
              ((com.wifi.connect.model.c)localObject2).<init>();
              ((com.wifi.connect.model.c)localObject2).a(((com.lantern.core.h.a)localObject1).a());
              ((com.wifi.connect.model.c)localObject2).b(((com.lantern.core.h.a)localObject1).b());
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>("mResponse:");
              h.a(localObject1, new Object[0]);
              i = j;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      h.a(localException);
      i = 0;
    }
    for (;;)
    {
      b.a locala = b.a.a(localException.g());
      if (locala != null)
      {
        boolean bool = "false".equals(locala.l());
        if (bool)
        {
          i = 1;
          continue;
        }
      }
      i = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */