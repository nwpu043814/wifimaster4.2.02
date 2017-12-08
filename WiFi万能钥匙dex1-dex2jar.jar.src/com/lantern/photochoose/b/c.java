package com.lantern.photochoose.b;

import android.os.Looper;
import java.util.concurrent.Semaphore;

final class c
  extends Thread
{
  c(a parama) {}
  
  public final void run()
  {
    Looper.prepare();
    a.a(this.a, new d(this));
    a.d(this.a).release();
    Looper.loop();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/photochoose/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */