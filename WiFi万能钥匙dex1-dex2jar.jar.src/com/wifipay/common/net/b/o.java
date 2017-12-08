package com.wifipay.common.net.b;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class o
{
  private AtomicInteger a = new AtomicInteger();
  private final Set b = new HashSet();
  private final PriorityBlockingQueue c = new PriorityBlockingQueue();
  private final h d;
  private final s e;
  private i[] f;
  private List g = new ArrayList();
  
  public o(h paramh)
  {
    this(paramh, 2);
  }
  
  public o(h paramh, int paramInt)
  {
    this(paramh, paramInt, new b(new Handler(Looper.getMainLooper())));
  }
  
  public o(h paramh, int paramInt, s params)
  {
    this.d = paramh;
    this.f = new i[paramInt];
    this.e = params;
  }
  
  public k a(k paramk)
  {
    paramk.a(this);
    synchronized (this.b)
    {
      this.b.add(paramk);
      paramk.a(c());
      paramk.b("add-to-queue");
      if (!paramk.r()) {
        this.c.add(paramk);
      }
      return paramk;
    }
  }
  
  public void a()
  {
    b();
    for (int i = 0; i < this.f.length; i++)
    {
      i locali = new i(this.c, this.d, this.e);
      this.f[i] = locali;
      locali.start();
    }
  }
  
  public void a(p paramp)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if (paramp.a(localk)) {
          localk.g();
        }
      }
    }
  }
  
  public void b()
  {
    for (int i = 0; i < this.f.length; i++) {
      if (this.f[i] != null) {
        this.f[i].a();
      }
    }
  }
  
  void b(k paramk)
  {
    synchronized (this.b)
    {
      this.b.remove(paramk);
      synchronized (this.g)
      {
        Iterator localIterator = this.g.iterator();
        if (localIterator.hasNext()) {
          ((q)localIterator.next()).a(paramk);
        }
      }
    }
  }
  
  public int c()
  {
    return this.a.incrementAndGet();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */