package android.support.v4.media;

import android.os.SystemClock;
import android.view.KeyEvent;

public abstract class TransportPerformer
{
  static final int AUDIOFOCUS_GAIN = 1;
  static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
  static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
  static final int AUDIOFOCUS_LOSS = -1;
  static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
  static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;
  
  public void onAudioFocusChange(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    }
    for (paramInt = i;; paramInt = 127)
    {
      if (paramInt != 0)
      {
        long l = SystemClock.uptimeMillis();
        onMediaButtonDown(127, new KeyEvent(l, l, 0, 127, 0));
        onMediaButtonUp(127, new KeyEvent(l, l, 1, 127, 0));
      }
      return;
    }
  }
  
  public int onGetBufferPercentage()
  {
    return 100;
  }
  
  public abstract long onGetCurrentPosition();
  
  public abstract long onGetDuration();
  
  public int onGetTransportControlFlags()
  {
    return 60;
  }
  
  public abstract boolean onIsPlaying();
  
  public boolean onMediaButtonDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      onStart();
      continue;
      onPause();
      continue;
      onStop();
      continue;
      if (onIsPlaying()) {
        onPause();
      } else {
        onStart();
      }
    }
  }
  
  public boolean onMediaButtonUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return true;
  }
  
  public abstract void onPause();
  
  public abstract void onSeekTo(long paramLong);
  
  public abstract void onStart();
  
  public abstract void onStop();
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/media/TransportPerformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */