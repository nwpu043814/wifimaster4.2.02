package com.tencent.wxop.stat;

import com.tencent.wxop.stat.b.b;

final class n
  implements Thread.UncaughtExceptionHandler
{
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((!c.l()) || (e.J() == null)) {}
    for (;;)
    {
      return;
      if (c.x())
      {
        t.s(e.J()).b(new com.tencent.wxop.stat.a.c(e.J(), e.a(e.J(), false, null), paramThrowable, paramThread), null, false, true);
        e.K().debug("MTA has caught the following uncaught exception:");
        e.K().a(paramThrowable);
      }
      e.p(e.J());
      if (e.L() != null)
      {
        e.K().e("Call the original uncaught exception handler.");
        if (!(e.L() instanceof n)) {
          e.L().uncaughtException(paramThread, paramThrowable);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */