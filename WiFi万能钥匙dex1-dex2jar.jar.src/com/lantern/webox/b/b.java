package com.lantern.webox.b;

final class b
  implements Runnable
{
  b(long paramLong, Runnable paramRunnable) {}
  
  public final void run()
  {
    try
    {
      if (this.a > 0L) {
        Thread.sleep(this.a);
      }
      this.b.run();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */