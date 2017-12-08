package com.alipay.b.h;

import java.util.LinkedList;

public final class b
{
  private static b a = new b();
  private Thread b = null;
  private LinkedList c = new LinkedList();
  
  public static b a()
  {
    return a;
  }
  
  public final void a(Runnable paramRunnable)
  {
    try
    {
      this.c.add(paramRunnable);
      if (this.b == null)
      {
        paramRunnable = new java/lang/Thread;
        c localc = new com/alipay/b/h/c;
        localc.<init>(this);
        paramRunnable.<init>(localc);
        this.b = paramRunnable;
        this.b.start();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */