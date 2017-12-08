package com.tencent.a.a.a.a;

import android.content.Context;

public abstract class f
{
  protected Context e = null;
  
  protected f(Context paramContext)
  {
    this.e = paramContext;
  }
  
  public final void a(c paramc)
  {
    if (paramc == null) {}
    for (;;)
    {
      return;
      paramc = paramc.toString();
      if (a()) {
        b(h.g(paramc));
      }
    }
  }
  
  protected abstract boolean a();
  
  protected abstract String b();
  
  protected abstract void b(String paramString);
  
  public final c e()
  {
    c localc = null;
    if (a()) {}
    for (String str = h.f(b());; str = null)
    {
      if (str != null) {
        localc = c.c(str);
      }
      return localc;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/a/a/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */