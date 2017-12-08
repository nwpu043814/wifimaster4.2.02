package com.wifipay.common.eventbus;

import java.util.concurrent.ExecutorService;

class a
  implements Runnable
{
  private final k a;
  private final EventBus b;
  
  a(EventBus paramEventBus)
  {
    this.b = paramEventBus;
    this.a = new k();
  }
  
  public void a(p paramp, Object paramObject)
  {
    paramp = j.a(paramp, paramObject);
    this.a.a(paramp);
    this.b.a().execute(this);
  }
  
  public void run()
  {
    j localj = this.a.a();
    if (localj == null) {
      throw new IllegalStateException("No pending post available");
    }
    this.b.a(localj);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/eventbus/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */