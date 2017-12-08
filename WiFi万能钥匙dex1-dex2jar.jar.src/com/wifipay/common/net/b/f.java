package com.wifipay.common.net.b;

class f
  implements Runnable
{
  private final k b;
  private final r c;
  private final Runnable d;
  
  public f(b paramb, k paramk, r paramr, Runnable paramRunnable)
  {
    this.b = paramk;
    this.c = paramr;
    this.d = paramRunnable;
  }
  
  public void run()
  {
    if (this.b.h()) {
      this.b.c("canceled-at-delivery");
    }
    label44:
    label99:
    label109:
    for (;;)
    {
      return;
      if (this.c.a())
      {
        this.b.a(this.c.a);
        if (!this.c.c) {
          break label99;
        }
        this.b.b("intermediate-response");
      }
      for (;;)
      {
        if (this.d == null) {
          break label109;
        }
        this.d.run();
        break;
        this.b.b(this.c.b);
        break label44;
        this.b.c("done");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */