package com.wifipay.common.eventbus;

import com.wifipay.common.logging.Logger;
import java.util.concurrent.ExecutorService;

final class b
  implements Runnable
{
  private final k a;
  private final EventBus b;
  private volatile boolean c;
  
  b(EventBus paramEventBus)
  {
    this.b = paramEventBus;
    this.a = new k();
  }
  
  public final void a(p paramp, Object paramObject)
  {
    paramp = j.a(paramp, paramObject);
    try
    {
      this.a.a(paramp);
      if (!this.c)
      {
        this.c = true;
        this.b.a().execute(this);
      }
      return;
    }
    finally {}
  }
  
  public final void run()
  {
    try
    {
      localObject4 = this.a.a(1000);
      localObject1 = localObject4;
      if (localObject4 != null) {}
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Object localObject1;
        localInterruptedException = localInterruptedException;
        Object localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>();
        Logger.w("Event %s %s", new Object[] { Thread.currentThread().getName() + " was interruppted", localInterruptedException });
        this.c = false;
      }
    }
    finally
    {
      this.c = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/eventbus/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */