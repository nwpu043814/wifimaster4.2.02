package com.lantern.feed.a;

import android.os.Handler;
import android.os.Looper;

final class k
  extends Thread
{
  k(j paramj) {}
  
  public final void run()
  {
    Looper.prepare();
    Handler localHandler = new Handler();
    localHandler.postDelayed(new l(this, localHandler), j.a(this.a));
    Looper.loop();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */