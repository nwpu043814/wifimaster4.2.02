package com.lantern.wifilocating.push.b.d;

import com.lantern.wifilocating.push.b.b.e;
import com.lantern.wifilocating.push.b.b.p;
import com.lantern.wifilocating.push.d;
import com.lantern.wifilocating.push.f.a.a.a;
import com.lantern.wifilocating.push.f.a.c;
import com.lantern.wifilocating.push.f.f;
import com.lantern.wifilocating.push.util.h;

public final class b
  implements c, Runnable
{
  private b a = new b((byte)0);
  private b b = new b((byte)0);
  private boolean c = true;
  private d d;
  
  public b(boolean paramBoolean, d paramd)
  {
    this.c = paramBoolean;
    this.d = paramd;
  }
  
  private void a(int paramInt)
  {
    if (this.d != null) {
      this.d.a(paramInt, null);
    }
  }
  
  private void a(p paramp, int paramInt)
  {
    if (paramp.a() == e.c) {
      paramp = this.a;
    }
    for (;;)
    {
      if (paramp != null) {}
      try
      {
        paramp.a = paramInt;
        paramp.notify();
        do
        {
          return;
        } while (paramp.a() != e.a);
        paramp = this.b;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(localException);
        }
      }
      finally {}
    }
  }
  
  private static void a(b paramb)
  {
    try
    {
      paramb.a = a.a;
      paramb.wait(60000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
    finally {}
  }
  
  public final void onEvent(com.lantern.wifilocating.push.f.a.a parama)
  {
    int i = parama.a();
    parama = parama.b();
    if (!(parama instanceof p)) {}
    for (;;)
    {
      return;
      if (i == a.a.e) {
        a((p)parama, a.b);
      } else if (i == a.a.f) {
        a((p)parama, a.c);
      }
    }
  }
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        f.a(this);
        bool = com.lantern.wifilocating.push.b.a.b.a().d();
        if (bool)
        {
          com.lantern.wifilocating.push.b.a.b.a().a(e.c);
          a(this.a);
          if (this.a.a == a.b)
          {
            locala1 = new com/lantern/wifilocating/push/f/a/a;
            locala1.<init>(a.a.k);
            f.a(locala1);
            a(1);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        com.lantern.wifilocating.push.f.a.a locala1;
        h.a(localThrowable);
        f.b(this);
        continue;
        this.b.a = a.c;
        continue;
      }
      finally
      {
        f.b(this);
      }
      if ((!bool) || (this.a.a != a.b))
      {
        locala1 = new com/lantern/wifilocating/push/f/a/a;
        locala1.<init>(a.a.j);
        f.a(locala1);
        if (a.a(this.c))
        {
          com.lantern.wifilocating.push.b.a.b.a().a(e.a);
          a(this.b);
        }
      }
      else
      {
        if (this.b.a != a.b) {
          break label195;
        }
        locala1 = new com/lantern/wifilocating/push/f/a/a;
        locala1.<init>(a.a.k);
        f.a(locala1);
        a(1);
        continue;
      }
      label195:
      com.lantern.wifilocating.push.f.a.a locala2 = new com/lantern/wifilocating/push/f/a/a;
      locala2.<init>(a.a.l);
      f.a(locala2);
      a(0);
    }
  }
  
  private static enum a {}
  
  private static final class b
  {
    public int a;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */