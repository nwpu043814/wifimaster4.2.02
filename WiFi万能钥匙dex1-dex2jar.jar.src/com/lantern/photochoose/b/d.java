package com.lantern.photochoose.b;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.Semaphore;

final class d
  extends Handler
{
  d(c paramc) {}
  
  public final void handleMessage(Message paramMessage)
  {
    try
    {
      a.a(this.a.a).acquire();
      paramMessage = a.b(this.a.a);
      if (paramMessage != null) {
        paramMessage.executeOnExecutor(a.b(), new Integer[] { Integer.valueOf(a.c(this.a.a)), Integer.valueOf(a.c(this.a.a)) });
      }
      return;
    }
    catch (InterruptedException paramMessage)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/photochoose/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */