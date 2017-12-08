package com.linksure.apservice.ui.category;

import android.content.Context;
import com.linksure.apservice.a.a;
import com.linksure.apservice.a.g;

public final class m
  implements b.a
{
  private g a;
  private a b;
  private b.b c;
  
  public m(Context paramContext, b.b paramb)
  {
    this.c = ((b.b)com.linksure.apservice.utils.i.a(b.b.class, paramb));
    this.a = com.linksure.apservice.a.i.d(paramContext);
    this.b = com.linksure.apservice.a.i.a(paramContext);
  }
  
  public final void a()
  {
    com.linksure.apservice.utils.i.a(this.c).a();
  }
  
  public final void a(String paramString, int paramInt)
  {
    this.b.b(paramString, paramInt, new o(this));
  }
  
  public final void a(boolean paramBoolean, String paramString)
  {
    int i = 1;
    if (!this.a.b())
    {
      this.c.m_();
      if (i == 0) {
        break label49;
      }
    }
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.c.l_();
        break;
      }
      i = 0;
      break;
      label49:
      this.b.a(paramString, new p(this, paramString));
    }
  }
  
  public final void b()
  {
    com.linksure.apservice.utils.i.a(this.c).b();
  }
  
  public final void c()
  {
    this.b.b(new n(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */