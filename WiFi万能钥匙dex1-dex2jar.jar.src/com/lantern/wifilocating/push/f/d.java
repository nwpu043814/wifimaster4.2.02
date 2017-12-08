package com.lantern.wifilocating.push.f;

import android.os.Handler.Callback;
import android.os.Message;
import com.lantern.wifilocating.push.b.a.b;
import com.lantern.wifilocating.push.b.a.f;

final class d
  implements Handler.Callback
{
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      f.a().a(false, paramMessage.arg1);
      continue;
      f.a().a(true, paramMessage.arg1);
      continue;
      b.a().a(true, null);
      continue;
      b.a().c();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */