package cm.pass.sdk.a.a;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class e
{
  private static final ConcurrentLinkedQueue<Runnable> a = new ConcurrentLinkedQueue();
  private static ExecutorService b = null;
  
  public static ExecutorService a()
  {
    try
    {
      if (b == null) {
        b = Executors.newSingleThreadExecutor();
      }
      ExecutorService localExecutorService = b;
      return localExecutorService;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */