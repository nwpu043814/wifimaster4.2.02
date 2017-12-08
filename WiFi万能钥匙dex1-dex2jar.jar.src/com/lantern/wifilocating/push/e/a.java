package com.lantern.wifilocating.push.e;

import android.os.SystemClock;
import com.lantern.wifilocating.push.f.f;
import com.lantern.wifilocating.push.util.j;

public class a
{
  private static a b;
  com.lantern.wifilocating.push.f.a.c a = new b(this);
  private int c = 0;
  private long d = 0L;
  
  public static final a a()
  {
    if (b == null) {}
    try
    {
      if (b == null)
      {
        a locala = new com/lantern/wifilocating/push/e/a;
        locala.<init>();
        b = locala;
      }
      return b;
    }
    finally {}
  }
  
  private void d()
  {
    com.lantern.wifilocating.push.c.b localb = (com.lantern.wifilocating.push.c.b)com.lantern.wifilocating.push.c.b.a.a().a(com.lantern.wifilocating.push.c.b.class);
    if (!localb.c()) {}
    for (;;)
    {
      return;
      if (j.c(com.lantern.wifilocating.push.c.a()))
      {
        long l = SystemClock.elapsedRealtime();
        if (l - this.d >= localb.b())
        {
          this.d = l;
          d.a().a(new c(this));
        }
      }
    }
  }
  
  public final void b()
  {
    if (!((com.lantern.wifilocating.push.c.b)com.lantern.wifilocating.push.c.b.a.a().a(com.lantern.wifilocating.push.c.b.class)).c()) {}
    for (;;)
    {
      return;
      if (com.lantern.wifilocating.push.b.a.b.a().d()) {
        d();
      }
      f.a(this.a);
    }
  }
  
  public final void c()
  {
    com.lantern.wifilocating.push.c.b localb = (com.lantern.wifilocating.push.c.b)com.lantern.wifilocating.push.c.b.a.a().a(com.lantern.wifilocating.push.c.b.class);
    this.c += 1;
    if (this.c % localb.a() == 0) {
      d();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */