package com.lantern.a.a;

import android.os.Handler;
import android.os.Looper;

final class m
  extends Thread
{
  m(l paraml) {}
  
  public final void run()
  {
    Looper.prepare();
    Handler localHandler = new Handler();
    localHandler.postDelayed(new n(this, localHandler), 3000L);
    Looper.loop();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */