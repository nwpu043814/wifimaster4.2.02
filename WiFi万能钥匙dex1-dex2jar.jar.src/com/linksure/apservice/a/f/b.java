package com.linksure.apservice.a.f;

import android.os.Handler;
import android.os.HandlerThread;

public class b
{
  private static b a = new b();
  private final HandlerThread b = new HandlerThread("aps_light");
  private final HandlerThread c;
  private final Handler d;
  private final Handler e;
  private Handler f = new Handler();
  
  private b()
  {
    this.b.start();
    this.d = new Handler(this.b.getLooper());
    this.c = new HandlerThread("aps_heavy");
    this.c.start();
    this.e = new Handler(this.c.getLooper());
  }
  
  public static void a()
  {
    a.f = new Handler();
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (Thread.currentThread() == a.b) {
      paramRunnable.run();
    }
    for (;;)
    {
      return;
      a.d.post(paramRunnable);
    }
  }
  
  public static void b(Runnable paramRunnable)
  {
    if (Thread.currentThread() == a.c) {
      paramRunnable.run();
    }
    for (;;)
    {
      return;
      a.e.post(paramRunnable);
    }
  }
  
  public static void c(Runnable paramRunnable)
  {
    a.f.post(paramRunnable);
  }
  
  public static abstract class a
    implements Runnable
  {
    public abstract void a();
    
    public void a(Exception paramException) {}
    
    public void run()
    {
      try
      {
        a();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(localException);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */