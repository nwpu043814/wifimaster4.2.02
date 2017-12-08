package com.linksure.apservice.a.c;

import android.content.Context;
import com.lantern.core.o;
import com.lantern.core.p;
import com.linksure.apservice.a.g;
import com.linksure.apservice.b.k;

public final class ao
  implements g
{
  private o a;
  private Context b;
  private k c;
  
  public ao(Context paramContext, o paramo)
  {
    this.b = paramContext;
    this.a = paramo;
  }
  
  public final k a()
  {
    if (!this.a.j()) {}
    for (k localk = null;; localk = this.c)
    {
      return localk;
      if (this.c == null) {
        this.c = new k();
      }
      this.c.a = p.d(this.b);
      this.c.b = p.e(this.b);
    }
  }
  
  public final boolean b()
  {
    return this.a.j();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/c/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */