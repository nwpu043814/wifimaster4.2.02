package com.wifi.connect.plugin.ssrp.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class m
{
  private static m a;
  private ExecutorService b = Executors.newSingleThreadExecutor();
  
  public static m a()
  {
    if (a == null) {
      a = new m();
    }
    return a;
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.b.execute(paramRunnable);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */