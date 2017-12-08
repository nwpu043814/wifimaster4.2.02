package com.alipay.android.a.a.a;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public final class u
  implements g
{
  private static u b = null;
  private static final ThreadFactory i = new w();
  Context a;
  private ThreadPoolExecutor c;
  private j d;
  private long e;
  private long f;
  private long g;
  private int h;
  
  private u(Context paramContext)
  {
    this.a = paramContext;
    this.d = j.a("android");
    this.c = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), i, new ThreadPoolExecutor.CallerRunsPolicy());
    try
    {
      this.c.allowCoreThreadTimeOut(true);
      CookieSyncManager.createInstance(this.a);
      CookieManager.getInstance().setAcceptCookie(true);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public static final u a(Context paramContext)
  {
    if (b != null) {}
    for (paramContext = b;; paramContext = b(paramContext)) {
      return paramContext;
    }
  }
  
  /* Error */
  private static final u b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 26	com/alipay/android/a/a/a/u:b	Lcom/alipay/android/a/a/a/u;
    //   6: ifnull +12 -> 18
    //   9: getstatic 26	com/alipay/android/a/a/a/u:b	Lcom/alipay/android/a/a/a/u;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 2	com/alipay/android/a/a/a/u
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: invokespecial 96	com/alipay/android/a/a/a/u:<init>	(Landroid/content/Context;)V
    //   27: aload_1
    //   28: putstatic 26	com/alipay/android/a/a/a/u:b	Lcom/alipay/android/a/a/a/u;
    //   31: aload_1
    //   32: astore_0
    //   33: goto -20 -> 13
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	paramContext	Context
    //   21	11	1	localu	u
    // Exception table:
    //   from	to	target	type
    //   3	13	36	finally
    //   18	31	36	finally
  }
  
  public final j a()
  {
    return this.d;
  }
  
  public final Future a(ad paramad)
  {
    long l2 = 0L;
    String str;
    int j;
    long l4;
    long l3;
    long l1;
    if (ac.a(this.a))
    {
      str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
      j = this.c.getActiveCount();
      l4 = this.c.getCompletedTaskCount();
      l3 = this.c.getTaskCount();
      if (this.g != 0L) {
        break label209;
      }
      l1 = 0L;
      if (this.h != 0) {
        break label229;
      }
    }
    for (;;)
    {
      String.format(str, new Object[] { Integer.valueOf(j), Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(this.e), Long.valueOf(this.f), Long.valueOf(this.g), Integer.valueOf(this.h) });
      paramad = new aa(this, (y)paramad);
      paramad = new v(this, paramad, paramad);
      this.c.execute(paramad);
      return paramad;
      label209:
      l1 = this.e * 1000L / this.g >> 10;
      break;
      label229:
      l2 = this.f / this.h;
    }
  }
  
  public final void a(long paramLong)
  {
    this.e += paramLong;
  }
  
  public final void b(long paramLong)
  {
    this.f += paramLong;
    this.h += 1;
  }
  
  public final void c(long paramLong)
  {
    this.g += paramLong;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */