package com.lantern.browser.c;

import android.os.Handler;
import android.os.Looper;

final class d
  extends Thread
{
  d(c paramc) {}
  
  public final void run()
  {
    Looper.prepare();
    Handler localHandler = new Handler();
    localHandler.postDelayed(new e(this, localHandler), c.a(this.a));
    Looper.loop();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */