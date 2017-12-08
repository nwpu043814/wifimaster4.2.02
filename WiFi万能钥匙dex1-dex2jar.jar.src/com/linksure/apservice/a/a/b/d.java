package com.linksure.apservice.a.a.b;

import com.lantern.core.o;
import com.linksure.apservice.a.a.a.b;
import com.linksure.apservice.a.a.c.a;
import com.linksure.apservice.a.a.c.o.a;
import com.linksure.apservice.a.a.c.o.b;
import com.linksure.apservice.a.a.e;
import com.linksure.apservice.a.d.a.c;

public final class d
  implements e
{
  private b a;
  private o b;
  
  public d(b paramb, o paramo)
  {
    this.a = paramb;
    this.b = paramo;
  }
  
  public final boolean a(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new o.a(paramInt, paramString1, paramString2);
    paramString1.a(this.b.s());
    paramString1 = (o.b)this.a.a(paramString1, o.b.class);
    if (paramString1.a == 0) {
      return true;
    }
    throw new c(paramString1.a, paramString1.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */