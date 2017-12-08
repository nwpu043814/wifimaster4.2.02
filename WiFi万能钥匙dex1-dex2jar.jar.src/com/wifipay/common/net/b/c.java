package com.wifipay.common.net.b;

import android.os.Handler;
import java.util.concurrent.Executor;

class c
  implements Executor
{
  c(b paramb, Handler paramHandler) {}
  
  public void execute(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */