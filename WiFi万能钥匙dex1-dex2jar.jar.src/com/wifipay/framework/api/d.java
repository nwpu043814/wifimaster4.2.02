package com.wifipay.framework.api;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class d
{
  final a a = new a(this.d, null);
  private final Handler.Callback b;
  private final b c;
  private Lock d = new ReentrantLock();
  
  public d()
  {
    this.b = null;
    this.c = new b();
  }
  
  public d(Handler.Callback paramCallback)
  {
    this.b = paramCallback;
    this.c = new b(new WeakReference(paramCallback));
  }
  
  private c a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new NullPointerException("Runnable can't be null");
    }
    paramRunnable = new a(this.d, paramRunnable);
    this.a.a(paramRunnable);
    return paramRunnable.d;
  }
  
  public final void a(Object paramObject)
  {
    this.c.removeCallbacksAndMessages(paramObject);
  }
  
  public final boolean a(int paramInt)
  {
    return this.c.sendEmptyMessage(paramInt);
  }
  
  public final boolean a(int paramInt, long paramLong)
  {
    return this.c.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public final boolean a(Message paramMessage)
  {
    return this.c.sendMessage(paramMessage);
  }
  
  public final boolean a(Runnable paramRunnable, long paramLong)
  {
    return this.c.postDelayed(a(paramRunnable), paramLong);
  }
  
  public final void b(int paramInt)
  {
    this.c.removeMessages(paramInt);
  }
  
  static class a
  {
    a a;
    a b;
    final Runnable c;
    final d.c d;
    Lock e;
    
    public a(Lock paramLock, Runnable paramRunnable)
    {
      this.c = paramRunnable;
      this.e = paramLock;
      this.d = new d.c(new WeakReference(paramRunnable), new WeakReference(this));
    }
    
    public d.c a()
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
    private final WeakReference<Handler.Callback> a;
    
    b()
    {
      this.a = null;
    }
    
    b(WeakReference<Handler.Callback> paramWeakReference)
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
    private final WeakReference<Runnable> a;
    private final WeakReference<d.a> b;
    
    c(WeakReference<Runnable> paramWeakReference, WeakReference<d.a> paramWeakReference1)
    {
      this.a = paramWeakReference;
      this.b = paramWeakReference1;
    }
    
    public void run()
    {
      Runnable localRunnable = (Runnable)this.a.get();
      d.a locala = (d.a)this.b.get();
      if (locala != null) {
        locala.a();
      }
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/api/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */