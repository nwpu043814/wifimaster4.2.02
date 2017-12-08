package com.lantern.push.utils;

import android.os.Handler.Callback;
import android.os.Message;
import com.lantern.push.ui.h;

final class d
  implements Handler.Callback
{
  d(c paramc) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (c.a(this.a) > 0) {
      c.b(this.a).a(c.a(this.a));
    }
    return false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */