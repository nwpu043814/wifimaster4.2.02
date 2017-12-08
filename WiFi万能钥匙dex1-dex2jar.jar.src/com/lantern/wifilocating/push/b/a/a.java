package com.lantern.wifilocating.push.b.a;

import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.d;
import com.lantern.wifilocating.push.util.h;
import com.lantern.wifilocating.push.util.j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a
{
  private static a a;
  private ExecutorService b = Executors.newSingleThreadExecutor();
  
  public static final a a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a locala = new com/lantern/wifilocating/push/b/a/a;
        locala.<init>();
        a = locala;
      }
      return a;
    }
    finally {}
  }
  
  public final void a(boolean paramBoolean, d paramd)
  {
    for (;;)
    {
      try
      {
        if (!j.c(c.a()))
        {
          com.lantern.wifilocating.push.util.b.a("network disable, request server failed");
          if (paramd != null) {
            paramd.a(10, null);
          }
          return;
        }
      }
      catch (Throwable paramd)
      {
        ExecutorService localExecutorService;
        com.lantern.wifilocating.push.b.d.b localb;
        h.a(paramd);
        continue;
      }
      if ((this.b != null) && (!this.b.isShutdown()))
      {
        localExecutorService = this.b;
        localb = new com/lantern/wifilocating/push/b/d/b;
        localb.<init>(paramBoolean, paramd);
        localExecutorService.submit(localb);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */