package com.alipay.sdk.k;

final class b
  implements Runnable
{
  b(a parama) {}
  
  public final void run()
  {
    if (a.c(this.a) == null)
    {
      a.a(this.a, new a.a(this.a, a.a(this.a)));
      a.c(this.a).setCancelable(a.d(this.a));
    }
    try
    {
      if (!a.c(this.a).isShowing()) {
        a.c(this.a).show();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/k/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */