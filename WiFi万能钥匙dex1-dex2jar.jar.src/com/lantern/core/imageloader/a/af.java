package com.lantern.core.imageloader.a;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class af
  extends ThreadPoolExecutor
{
  af()
  {
    super(6, 6, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new at.b());
  }
  
  public final Future<?> submit(Runnable paramRunnable)
  {
    paramRunnable = new a((c)paramRunnable);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  private static final class a
    extends FutureTask<c>
    implements Comparable<a>
  {
    private final c a;
    
    public a(c paramc)
    {
      super(null);
      this.a = paramc;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */