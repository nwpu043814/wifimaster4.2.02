package com.alipay.android.a.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class w
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, "com.alipay.mobile.common.transport.http.HttpManager.HttpWorker #" + this.a.getAndIncrement());
    paramRunnable.setPriority(4);
    return paramRunnable;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */