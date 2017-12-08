package com.analysis.model.crash;

public final class a
  implements Thread.UncaughtExceptionHandler
{
  public d a;
  private Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
  
  public a()
  {
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  private void a(d paramd)
  {
    this.a = paramd;
  }
  
  private void a(Throwable paramThrowable)
  {
    if (com.analysis.analytics.d.a) {
      this.a.a(paramThrowable);
    }
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (com.analysis.analytics.d.a) {
      this.a.a(paramThrowable);
    }
    if ((this.b != null) && (this.b != paramThread.getUncaughtExceptionHandler())) {
      this.b.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/crash/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */