package com.lantern.wifilocating.push.e;

import com.lantern.wifilocating.push.util.b;
import com.lantern.wifilocating.push.util.d;
import com.lantern.wifilocating.push.util.j;

final class c
  implements d.b
{
  c(a parama) {}
  
  public final void a(com.lantern.wifilocating.push.h.a parama)
  {
    if (parama.e())
    {
      parama.f();
      String str2 = parama.c().toLowerCase();
      String str1 = parama.b();
      String str3 = parama.a();
      parama = parama.d();
      b.c("PushLocationProxy.callback : " + str2 + ", " + str1 + ", " + str3 + ", " + parama);
      com.lantern.wifilocating.push.d.f localf = d.a().b();
      if (localf != null)
      {
        localf.k = str2;
        localf.l = str1;
        localf.m = str3;
      }
      j.a(com.lantern.wifilocating.push.c.a(), str1, str3, parama, str2);
      com.lantern.wifilocating.push.f.f.a().c();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */