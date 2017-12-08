package com.analysis.common.upload;

import android.content.Context;
import com.analysis.analytics.g;
import com.analysis.common.tools.c;

public final class o
  implements n
{
  private static o c;
  l a;
  private Context b;
  
  private o(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.a = new l(paramContext);
  }
  
  public static o a(Context paramContext)
  {
    try
    {
      if (c.a(c))
      {
        o localo = new com/analysis/common/upload/o;
        localo.<init>(paramContext);
        c = localo;
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public final void a()
  {
    g.a(new p(this));
  }
  
  public final void a(k paramk)
  {
    g.a(new q(this, paramk));
  }
  
  public final void b(k paramk)
  {
    g.a(new r(this, paramk));
  }
  
  public final void c(k paramk)
  {
    this.a.c(paramk);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */