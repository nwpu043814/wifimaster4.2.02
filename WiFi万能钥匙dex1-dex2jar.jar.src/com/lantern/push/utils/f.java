package com.lantern.push.utils;

import android.os.Handler.Callback;
import android.os.Message;
import com.lantern.push.ui.h;

final class f
  implements Handler.Callback
{
  f(e parame) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (e.a(this.a) != null)
    {
      if (e.b(this.a) == null) {
        break label32;
      }
      e.a(this.a).notifyDataSetChanged();
    }
    for (;;)
    {
      return false;
      label32:
      e.a(this.a).a();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */