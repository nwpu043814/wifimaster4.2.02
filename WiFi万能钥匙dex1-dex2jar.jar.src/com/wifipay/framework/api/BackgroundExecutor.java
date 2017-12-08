package com.wifipay.framework.api;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class BackgroundExecutor
{
  public static final Executor a;
  public static final WrongThreadListener b;
  private static Executor c;
  private static WrongThreadListener d;
  private static final List<a> e = new ArrayList();
  private static final ThreadLocal<String> f = new ThreadLocal();
  
  static
  {
    Object localObject = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    a = (Executor)localObject;
    c = (Executor)localObject;
    localObject = new a();
    b = (WrongThreadListener)localObject;
    d = (WrongThreadListener)localObject;
  }
  
  private static Future<?> a(Runnable paramRunnable, int paramInt)
  {
    Object localObject = null;
    if (paramInt > 0)
    {
      if (!(c instanceof ScheduledExecutorService)) {
        throw new IllegalArgumentException("The executor set does not support scheduling");
      }
      paramRunnable = ((ScheduledExecutorService)c).schedule(paramRunnable, paramInt, TimeUnit.MILLISECONDS);
    }
    for (;;)
    {
      return (Future)paramRunnable;
      if ((c instanceof ExecutorService))
      {
        paramRunnable = ((ExecutorService)c).submit(paramRunnable);
      }
      else
      {
        c.execute(paramRunnable);
        paramRunnable = (Runnable)localObject;
      }
    }
  }
  
  public static void a(a parama)
  {
    Future localFuture = null;
    try
    {
      if ((a.a(parama) == null) || (!b(a.a(parama))))
      {
        a.a(parama, true);
        localFuture = a(parama, a.b(parama));
      }
      if ((a.c(parama) != null) || (a.a(parama) != null))
      {
        a.a(parama, localFuture);
        e.add(parama);
      }
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        int i = e.size() - 1;
        if (i < 0) {
          break;
        }
        a locala = (a)e.get(i);
        if (paramString.equals(a.c(locala)))
        {
          if (a.d(locala) == null) {
            continue;
          }
          a.d(locala).cancel(paramBoolean);
          if (!a.e(locala).getAndSet(true)) {
            a.f(locala);
          }
        }
        i--;
        continue;
        if (a.g(locala))
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("A task with id ");
          Log.w("BackgroundExecutor", a.c(locala) + " cannot be cancelled (the executor set does not support it)");
        }
        else
        {
          e.remove(i);
        }
      }
      finally {}
    }
  }
  
  private static boolean b(String paramString)
  {
    Iterator localIterator = e.iterator();
    if (!localIterator.hasNext()) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      a locala = (a)localIterator.next();
      if ((!a.g(locala)) || (!paramString.equals(a.a(locala)))) {
        break;
      }
    }
  }
  
  private static a c(String paramString)
  {
    int j = e.size();
    int i = 0;
    if (i < j) {
      if (!paramString.equals(a.a((a)e.get(i)))) {}
    }
    for (paramString = (a)e.remove(i);; paramString = null)
    {
      return paramString;
      i++;
      break;
    }
  }
  
  public static abstract interface WrongThreadListener
  {
    public abstract void onBgExpected(String... paramVarArgs);
    
    public abstract void onUiExpected();
    
    public abstract void onWrongBgSerial(String paramString, String... paramVarArgs);
  }
  
  public static abstract class a
    implements Runnable
  {
    private String a;
    private int b;
    private long c;
    private String d;
    private boolean e;
    private Future<?> f;
    private AtomicBoolean g = new AtomicBoolean();
    
    public a()
    {
      this("", 0, "");
    }
    
    public a(String paramString1, int paramInt, String paramString2)
    {
      if (!"".equals(paramString1)) {
        this.a = paramString1;
      }
      if (paramInt > 0)
      {
        this.b = paramInt;
        this.c = (System.currentTimeMillis() + paramInt);
      }
      if (!"".equals(paramString2)) {
        this.d = paramString2;
      }
    }
    
    private void b()
    {
      if ((this.a != null) || (this.d != null)) {
        BackgroundExecutor.a().set(null);
      }
      try
      {
        BackgroundExecutor.b().remove(this);
        if (this.d != null)
        {
          a locala = BackgroundExecutor.a(this.d);
          if (locala != null)
          {
            if (locala.b != 0) {
              locala.b = Math.max(0, (int)(this.c - System.currentTimeMillis()));
            }
            BackgroundExecutor.a(locala);
          }
        }
        return;
      }
      finally {}
    }
    
    public abstract void a();
    
    public void run()
    {
      if (!this.g.getAndSet(true)) {}
      try
      {
        BackgroundExecutor.a().set(this.d);
        a();
        return;
      }
      finally
      {
        b();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/api/BackgroundExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */