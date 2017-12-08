package com.lantern.analytics.b;

public final class a
  implements Thread.UncaughtExceptionHandler
{
  private boolean a = true;
  private Thread.UncaughtExceptionHandler b;
  private a c;
  
  public a()
  {
    if (Thread.getDefaultUncaughtExceptionHandler() == this) {}
    for (;;)
    {
      return;
      this.b = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(this);
    }
  }
  
  public final void a(a parama)
  {
    this.c = parama;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((this.c != null) && (this.a)) {
      this.c.a(paramThrowable);
    }
    if ((this.b != null) && (this.b != Thread.getDefaultUncaughtExceptionHandler())) {
      this.b.uncaughtException(paramThread, paramThrowable);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Throwable paramThrowable);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */