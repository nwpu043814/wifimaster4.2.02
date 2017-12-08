package com.lantern.notifaction;

import android.os.Handler;
import com.lantern.core.g.j;

final class c
  implements com.bluefay.b.a
{
  c(a parama, Handler paramHandler) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (j.b(((Integer)paramObject).intValue())) {
      this.a.post(new d(this));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/notifaction/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */