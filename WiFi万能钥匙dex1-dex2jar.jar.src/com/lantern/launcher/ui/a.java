package com.lantern.launcher.ui;

import android.os.Handler;
import android.os.Message;
import com.lantern.a.a.e;

final class a
  extends Handler
{
  a(MainActivity paramMainActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((!MainActivity.a(this.a)) && (i == 100))
    {
      i = paramMessage.arg1;
      if (i <= 0) {
        break label63;
      }
      MainActivity.a(this.a, i);
      sendMessageDelayed(Message.obtain(MainActivity.b(this.a), 100, i - 1, 0), 1000L);
    }
    for (;;)
    {
      return;
      label63:
      MainActivity.a(this.a, 1);
      if (MainActivity.c(this.a) != null) {
        MainActivity.c(this.a).d();
      }
      MainActivity.a(this.a, null);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */