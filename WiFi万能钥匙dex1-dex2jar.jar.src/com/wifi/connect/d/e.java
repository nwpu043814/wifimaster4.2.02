package com.wifi.connect.d;

import android.os.Handler;
import android.os.Looper;

final class e
  extends Thread
{
  e(d paramd) {}
  
  public final void run()
  {
    Looper.prepare();
    Handler localHandler = new Handler();
    localHandler.postDelayed(new f(this, localHandler), 35000L);
    Looper.loop();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */