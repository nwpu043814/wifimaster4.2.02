package com.lantern.browser;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bn
{
  private List<bh> a = new ArrayList();
  private bh b;
  private at c;
  
  public bn(at paramat)
  {
    this.c = paramat;
  }
  
  public final bh a(Context paramContext)
  {
    paramContext = new bh(this, this.c, paramContext);
    if (this.b != null) {
      this.b.a(false);
    }
    this.b = paramContext;
    this.a.add(paramContext);
    this.c.a(paramContext.a());
    return paramContext;
  }
  
  public final List<bh> a()
  {
    return this.a;
  }
  
  public final void a(bh parambh)
  {
    if (this.a.contains(parambh))
    {
      this.a.remove(parambh);
      if (this.b.equals(parambh))
      {
        int i = this.a.size();
        if (i <= 0) {
          break label92;
        }
        this.b = ((bh)this.a.get(i - 1));
        this.b.a(true);
      }
    }
    for (;;)
    {
      this.c.b(parambh.a());
      parambh.e();
      return;
      label92:
      this.b = null;
    }
  }
  
  public final bh b()
  {
    return this.b;
  }
  
  public final void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bh)localIterator.next()).e();
    }
    this.a.clear();
    this.a = null;
    this.b = null;
  }
  
  public final void d()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bh)localIterator.next()).e();
    }
    this.b = null;
    this.a.clear();
    a(this.c.getContext());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */