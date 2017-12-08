package com.lantern.wifilocating.push.b.a;

import com.lantern.wifilocating.push.b.b.e;
import com.lantern.wifilocating.push.b.b.p;
import com.lantern.wifilocating.push.f.a.a.a;
import com.lantern.wifilocating.push.f.f;

final class c
  implements com.lantern.wifilocating.push.f.a.c
{
  c(b paramb) {}
  
  public final void onEvent(com.lantern.wifilocating.push.f.a.a parama)
  {
    int i = parama.a();
    if (com.lantern.wifilocating.push.b.e.a.a(e.a, parama))
    {
      b.a(this.a, true);
      b.a(this.a);
    }
    for (;;)
    {
      return;
      if (!com.lantern.wifilocating.push.b.e.a.b(e.a, parama)) {
        break label188;
      }
      b.a(this.a, false);
      b.b(this.a);
      com.lantern.wifilocating.push.util.b.c("Consecutive Login Failed Times : " + b.c(this.a));
      if (b.c(this.a) <= 1) {
        break;
      }
      b.a(this.a);
      f.a(new com.lantern.wifilocating.push.f.a.a(a.a.m));
    }
    parama = (p)parama.b();
    if ((parama.b() instanceof Integer)) {
      if (((Integer)parama.b()).intValue() == 428282369) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.a.a(false, null);
        break;
        i = 0;
        continue;
      }
      this.a.a(true, null);
      break;
      label188:
      if (i == a.a.k)
      {
        b.a(this.a, true);
        break;
      }
      if (i != a.a.h) {
        break;
      }
      b.a(this.a, false);
      this.a.a(true, null);
      break;
      i = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */