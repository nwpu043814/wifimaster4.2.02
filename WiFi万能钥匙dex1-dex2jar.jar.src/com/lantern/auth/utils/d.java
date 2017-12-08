package com.lantern.auth.utils;

import android.os.Handler.Callback;
import android.os.Message;

final class d
  implements Handler.Callback
{
  d(b paramb) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (b.a(this.a) != 1) && (b.a(this.a) != 3))
    {
      b.a(this.a, 2);
      b.a(this.a, 0, "send sms failed");
    }
    return false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */