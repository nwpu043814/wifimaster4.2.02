package com.lantern.wifilocating.push.b.a;

import com.lantern.wifilocating.push.b.b.g;
import com.lantern.wifilocating.push.b.b.h;
import com.lantern.wifilocating.push.b.b.i;
import com.lantern.wifilocating.push.b.b.j;
import com.lantern.wifilocating.push.b.b.k;
import com.lantern.wifilocating.push.b.b.l;
import com.lantern.wifilocating.push.b.b.m;
import com.lantern.wifilocating.push.b.b.n;
import com.lantern.wifilocating.push.b.c.a;

public class b
{
  private static b a;
  private k b = new k();
  private g c = new g();
  private i d = new i();
  private j e = new j();
  private l f = new l();
  private m g = new m();
  private h h = new h();
  private a i;
  private boolean j;
  private n k = new n();
  private int l = 0;
  
  private b()
  {
    com.lantern.wifilocating.push.f.f.a(new c(this));
  }
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        b localb = new com/lantern/wifilocating/push/b/a/b;
        localb.<init>();
        a = localb;
      }
      return a;
    }
    finally {}
  }
  
  public final void a(com.lantern.wifilocating.push.b.b.e parame)
  {
    parame = b(parame);
    if (parame != null) {
      parame.b();
    }
  }
  
  public final void a(a parama)
  {
    this.i = parama;
  }
  
  public final void a(String paramString)
  {
    if (this.k != null) {
      this.k.a(paramString);
    }
  }
  
  public final void a(boolean paramBoolean, com.lantern.wifilocating.push.d paramd)
  {
    com.lantern.wifilocating.push.f.f.a().a(new e(this, paramBoolean, paramd));
  }
  
  public final com.lantern.wifilocating.push.b.b.f b(com.lantern.wifilocating.push.b.b.e parame)
  {
    if (parame == com.lantern.wifilocating.push.b.b.e.a) {
      parame = this.b;
    }
    for (;;)
    {
      return parame;
      if (parame == com.lantern.wifilocating.push.b.b.e.b) {
        parame = this.d;
      } else if (parame == com.lantern.wifilocating.push.b.b.e.f) {
        parame = this.f;
      } else if (parame == com.lantern.wifilocating.push.b.b.e.c) {
        parame = this.c;
      } else if (parame == com.lantern.wifilocating.push.b.b.e.g) {
        parame = this.h;
      } else if (parame == com.lantern.wifilocating.push.b.b.e.e) {
        parame = this.g;
      } else if (parame == com.lantern.wifilocating.push.b.b.e.d) {
        parame = this.e;
      } else {
        parame = null;
      }
    }
  }
  
  public final a b()
  {
    return this.i;
  }
  
  public final void c()
  {
    if (this.j) {
      a(com.lantern.wifilocating.push.b.b.e.d);
    }
    for (;;)
    {
      return;
      a(true, new d(this));
    }
  }
  
  public final boolean d()
  {
    return this.j;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */