package com.lantern.wifilocating.push.f;

import android.os.SystemClock;

final class b
  implements Runnable
{
  b(a parama) {}
  
  public final void run()
  {
    long l = SystemClock.elapsedRealtime();
    if (a.c() == 0L) {
      a.a(l);
    }
    label146:
    for (;;)
    {
      int i = 0;
      c localc = f.a().b();
      if (localc != null) {
        if (i != 0)
        {
          if (a.a(this.a))
          {
            localc.removeCallbacks(a.b(this.a));
            a.a(this.a, false);
          }
          a.b(this.a).run();
        }
      }
      for (;;)
      {
        return;
        if (l - a.c() < 5000L) {
          break label146;
        }
        i = 1;
        break;
        a.a(this.a, true);
        localc.removeCallbacks(a.b(this.a));
        localc.postDelayed(a.b(this.a), 2000L);
        continue;
        a.b(this.a).run();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */