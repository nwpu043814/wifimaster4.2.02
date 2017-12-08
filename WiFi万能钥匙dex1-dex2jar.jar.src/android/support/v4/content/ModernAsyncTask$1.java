package android.support.v4.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ModernAsyncTask$1
  implements ThreadFactory
{
  private final AtomicInteger mCount = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/content/ModernAsyncTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */