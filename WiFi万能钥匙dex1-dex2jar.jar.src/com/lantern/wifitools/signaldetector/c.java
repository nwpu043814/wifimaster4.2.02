package com.lantern.wifitools.signaldetector;

import android.os.Handler;
import android.os.Message;
import java.util.Random;

final class c
  extends Handler
{
  c(SignalProgressBar paramSignalProgressBar) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what != 256) || (!SignalProgressBar.a(this.a))) {
      return;
    }
    SignalProgressBar.a(this.a, new Random().nextInt(3));
    if (SignalProgressBar.b(this.a) == -1)
    {
      SignalProgressBar.a(this.a, 80);
      if ((SignalProgressBar.c(this.a)) && (SignalProgressBar.d(this.a) < 100.0F))
      {
        SignalProgressBar.b(this.a, SignalProgressBar.e(this.a));
        label100:
        if ((SignalProgressBar.c(this.a)) || (SignalProgressBar.d(this.a) < 5.0F)) {
          break label211;
        }
        SignalProgressBar.c(this.a, SignalProgressBar.e(this.a));
        label138:
        if (SignalProgressBar.d(this.a) >= 0.0F) {
          break label331;
        }
        SignalProgressBar.d(this.a, 0.0F);
      }
    }
    for (;;)
    {
      this.a.a((int)SignalProgressBar.d(this.a));
      SignalProgressBar.g(this.a).sendEmptyMessageDelayed(256, SignalProgressBar.f(this.a));
      break;
      SignalProgressBar.a(this.a, false);
      break label100;
      label211:
      SignalProgressBar.a(this.a, true);
      break label138;
      SignalProgressBar.a(this.a, 20);
      if (SignalProgressBar.d(this.a) + 3.0F < SignalProgressBar.b(this.a))
      {
        SignalProgressBar.b(this.a, SignalProgressBar.e(this.a));
        break label138;
      }
      if (SignalProgressBar.d(this.a) > SignalProgressBar.b(this.a) + 3)
      {
        SignalProgressBar.c(this.a, SignalProgressBar.e(this.a));
        break label138;
      }
      SignalProgressBar.d(this.a, SignalProgressBar.b(this.a));
      break label138;
      label331:
      if (SignalProgressBar.d(this.a) > 100.0F) {
        SignalProgressBar.d(this.a, 100.0F);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/signaldetector/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */