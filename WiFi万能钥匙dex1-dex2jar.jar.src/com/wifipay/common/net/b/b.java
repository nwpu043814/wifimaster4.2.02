package com.wifipay.common.net.b;

import android.os.Handler;
import com.wifipay.common.net.b.a.h;
import java.util.concurrent.Executor;

public class b
  implements s
{
  private final Executor a;
  
  public b(Handler paramHandler)
  {
    this.a = new c(this, paramHandler);
  }
  
  public void a(k paramk)
  {
    paramk.b("post-cancel");
    this.a.execute(new d(this, paramk));
  }
  
  public void a(k paramk, h paramh)
  {
    paramk.b("post-error");
    paramh = r.a(paramh);
    this.a.execute(new f(this, paramk, paramh, null));
  }
  
  public void a(k paramk, r paramr)
  {
    a(paramk, paramr, null);
  }
  
  public void a(k paramk, r paramr, Runnable paramRunnable)
  {
    paramk.v();
    paramk.b("post-response");
    this.a.execute(new f(this, paramk, paramr, paramRunnable));
  }
  
  public void b(k paramk)
  {
    paramk.b("post-preExecute");
    this.a.execute(new e(this, paramk));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */