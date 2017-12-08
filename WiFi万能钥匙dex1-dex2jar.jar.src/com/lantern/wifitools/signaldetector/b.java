package com.lantern.wifitools.signaldetector;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;

final class b
  extends Handler
{
  float a = 1.0F;
  
  b(SignalDetectorFragment paramSignalDetectorFragment) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label123:
    label217:
    for (;;)
    {
      return;
      this.a -= 0.05F;
      if (this.a > 0.2F) {
        if (SignalDetectorFragment.a(this.b) != null) {
          SignalDetectorFragment.b(this.b).sendEmptyMessageDelayed(1, 10L);
        }
      }
      for (;;)
      {
        if (SignalDetectorFragment.a(this.b) == null) {
          break label123;
        }
        SignalDetectorFragment.a(this.b).setVolume(this.a, this.a);
        SignalDetectorFragment.a(this.b).start();
        break;
        this.a = 0.2F;
      }
      continue;
      this.a += 0.01F;
      if (this.a < 1.0F) {
        if (SignalDetectorFragment.a(this.b) != null) {
          SignalDetectorFragment.b(this.b).sendEmptyMessageDelayed(2, 10L);
        }
      }
      for (;;)
      {
        if (SignalDetectorFragment.a(this.b) == null) {
          break label217;
        }
        SignalDetectorFragment.a(this.b).setVolume(this.a, this.a);
        SignalDetectorFragment.a(this.b).start();
        break;
        this.a = 1.0F;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/signaldetector/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */