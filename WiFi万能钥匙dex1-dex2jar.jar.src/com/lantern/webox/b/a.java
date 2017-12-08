package com.lantern.webox.b;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class a
{
  private static e a = new e(a.class);
  private static Executor b = Executors.newFixedThreadPool(8);
  
  public static void a(Runnable paramRunnable)
  {
    a(paramRunnable, 0L);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    b.execute(new b(paramLong, paramRunnable));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */