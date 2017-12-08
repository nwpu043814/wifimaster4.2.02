package com.analysis.analytics;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class g
{
  private static final long a = 10L;
  private static List<WeakReference<ScheduledFuture<?>>> b = new ArrayList();
  private static ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();
  
  public static void a()
  {
    Iterator localIterator = b.iterator();
    label58:
    while (localIterator.hasNext())
    {
      ScheduledFuture localScheduledFuture = (ScheduledFuture)((WeakReference)localIterator.next()).get();
      if (localScheduledFuture == null) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label58;
        }
        localScheduledFuture.cancel(false);
        break;
      }
    }
    b.clear();
    if (!c.isShutdown()) {
      c.shutdown();
    }
    try
    {
      c.awaitTermination(10L, TimeUnit.SECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (c.isShutdown()) {
      c = Executors.newSingleThreadScheduledExecutor();
    }
    c.execute(paramRunnable);
  }
  
  private static void a(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (c.isShutdown()) {
        c = Executors.newSingleThreadScheduledExecutor();
      }
      List localList = b;
      WeakReference localWeakReference = new java/lang/ref/WeakReference;
      localWeakReference.<init>(c.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS));
      localList.add(localWeakReference);
      return;
    }
    finally {}
  }
  
  /* Error */
  private static void b(Runnable paramRunnable)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 30	com/analysis/analytics/g:c	Ljava/util/concurrent/ScheduledExecutorService;
    //   6: invokeinterface 69 1 0
    //   11: ifeq +9 -> 20
    //   14: invokestatic 28	java/util/concurrent/Executors:newSingleThreadScheduledExecutor	()Ljava/util/concurrent/ScheduledExecutorService;
    //   17: putstatic 30	com/analysis/analytics/g:c	Ljava/util/concurrent/ScheduledExecutorService;
    //   20: getstatic 30	com/analysis/analytics/g:c	Ljava/util/concurrent/ScheduledExecutorService;
    //   23: aload_0
    //   24: invokeinterface 112 2 0
    //   29: astore_0
    //   30: aload_0
    //   31: ldc2_w 7
    //   34: getstatic 78	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   37: invokeinterface 117 4 0
    //   42: pop
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 85	java/lang/InterruptedException:printStackTrace	()V
    //   52: goto -9 -> 43
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 118	java/util/concurrent/ExecutionException:printStackTrace	()V
    //   66: goto -23 -> 43
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual 119	java/util/concurrent/TimeoutException:printStackTrace	()V
    //   74: goto -31 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   30	43	47	java/lang/InterruptedException
    //   3	20	55	finally
    //   20	30	55	finally
    //   30	43	55	finally
    //   48	52	55	finally
    //   62	66	55	finally
    //   70	74	55	finally
    //   30	43	61	java/util/concurrent/ExecutionException
    //   30	43	69	java/util/concurrent/TimeoutException
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/analytics/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */