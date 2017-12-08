package com.tencent.wxop.stat;

import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.l;
import java.util.TimerTask;

final class ag
  extends TimerTask
{
  ag(af paramaf) {}
  
  public final void run()
  {
    if (c.k()) {
      l.av().b("TimerTask run");
    }
    e.q(af.a(this.de));
    cancel();
    this.de.ah();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */