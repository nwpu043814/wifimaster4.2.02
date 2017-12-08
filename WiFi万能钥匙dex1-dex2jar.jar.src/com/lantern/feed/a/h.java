package com.lantern.feed.a;

import android.os.Handler;
import android.os.Looper;

final class h
  extends Thread
{
  h(g paramg) {}
  
  public final void run()
  {
    Looper.prepare();
    Handler localHandler = new Handler();
    localHandler.postDelayed(new i(this, localHandler), g.a(this.a));
    Looper.loop();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */