package com.wifipay.sdk.app;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class g
{
  final a a = new a(this.d, null);
  private final Handler.Callback b;
  private final b c;
  private Lock d = new ReentrantLock();
  
  public g()
  {
    this.b = null;
    this.c = new b();
  }
  
  public g(Handler.Callback paramCallback)
  {
    this.b = paramCallback;
    this.c = new b(new WeakReference(paramCallback));
  }
  
  public g(Looper paramLooper)
  {
    this.b = null;
    this.c = new b(paramLooper);
  }
  
  private c c(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new NullPointerException("Runnable can't be null");
    }
    paramRunnable = new a(this.d, paramRunnable);
    this.a.a(paramRunnable);
    return paramRunnable.d;
  }
  
  public final boolean a(Message paramMessage)
  {
    return this.c.sendMessage(paramMessage);
  }
  
  public final boolean a(Runnable paramRunnable)
  {
    return this.c.post(c(paramRunnable));
  }
  
  public final boolean a(Runnable paramRunnable, long paramLong)
  {
    return this.c.postDelayed(c(paramRunnable), paramLong);
  }
  
  public final void b(Runnable paramRunnable)
  {
    paramRunnable = this.a.a(paramRunnable);
    if (paramRunnable != null) {
      this.c.removeCallbacks(paramRunnable);
    }
  }
  
  static class a
  {
    a a;
    a b;
    final Runnable c;
    final g.c d;
    Lock e;
    
    public a(Lock paramLock, Runnable paramRunnable)
    {
      this.c = paramRunnable;
      this.e = paramLock;
      this.d = new g.c(new WeakReference(paramRunnable), new WeakReference(this));
    }
    
    public g.c a()
    {
      this.e.lock();
      try
      {
        if (this.b != null) {
          this.b.a = this.a;
        }
        if (this.a != null) {
          this.a.b = this.b;
        }
        this.b = null;
        this.a = null;
        return this.d;
      }
      finally
      {
        this.e.unlock();
      }
    }
    
    /* Error */
    public g.c a(Runnable paramRunnable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 24	com/wifipay/sdk/app/g$a:e	Ljava/util/concurrent/locks/Lock;
      //   4: invokeinterface 43 1 0
      //   9: aload_0
      //   10: getfield 47	com/wifipay/sdk/app/g$a:a	Lcom/wifipay/sdk/app/g$a;
      //   13: astore_2
      //   14: aload_2
      //   15: ifnull +35 -> 50
      //   18: aload_2
      //   19: getfield 22	com/wifipay/sdk/app/g$a:c	Ljava/lang/Runnable;
      //   22: aload_1
      //   23: if_acmpne +19 -> 42
      //   26: aload_2
      //   27: invokevirtual 53	com/wifipay/sdk/app/g$a:a	()Lcom/wifipay/sdk/app/g$c;
      //   30: astore_1
      //   31: aload_0
      //   32: getfield 24	com/wifipay/sdk/app/g$a:e	Ljava/util/concurrent/locks/Lock;
      //   35: invokeinterface 50 1 0
      //   40: aload_1
      //   41: areturn
      //   42: aload_2
      //   43: getfield 47	com/wifipay/sdk/app/g$a:a	Lcom/wifipay/sdk/app/g$a;
      //   46: astore_2
      //   47: goto -33 -> 14
      //   50: aload_0
      //   51: getfield 24	com/wifipay/sdk/app/g$a:e	Ljava/util/concurrent/locks/Lock;
      //   54: invokeinterface 50 1 0
      //   59: aconst_null
      //   60: astore_1
      //   61: goto -21 -> 40
      //   64: astore_1
      //   65: aload_0
      //   66: getfield 24	com/wifipay/sdk/app/g$a:e	Ljava/util/concurrent/locks/Lock;
      //   69: invokeinterface 50 1 0
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	a
      //   0	76	1	paramRunnable	Runnable
      //   13	34	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   9	14	64	finally
      //   18	31	64	finally
      //   42	47	64	finally
    }
    
    public void a(a parama)
    {
      this.e.lock();
      try
      {
        if (this.a != null) {
          this.a.b = parama;
        }
        parama.a = this.a;
        this.a = parama;
        parama.b = this;
        return;
      }
      finally
      {
        this.e.unlock();
      }
    }
  }
  
  private static class b
    extends Handler
  {
    private final WeakReference a;
    
    b()
    {
      this.a = null;
    }
    
    b(Looper paramLooper)
    {
      super();
      this.a = null;
    }
    
    b(WeakReference paramWeakReference)
    {
      this.a = paramWeakReference;
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.a == null) {}
      for (;;)
      {
        return;
        Handler.Callback localCallback = (Handler.Callback)this.a.get();
        if (localCallback != null) {
          localCallback.handleMessage(paramMessage);
        }
      }
    }
  }
  
  static class c
    implements Runnable
  {
    private final WeakReference a;
    private final WeakReference b;
    
    c(WeakReference paramWeakReference1, WeakReference paramWeakReference2)
    {
      this.a = paramWeakReference1;
      this.b = paramWeakReference2;
    }
    
    public void run()
    {
      Runnable localRunnable = (Runnable)this.a.get();
      g.a locala = (g.a)this.b.get();
      if (locala != null) {
        locala.a();
      }
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/app/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */