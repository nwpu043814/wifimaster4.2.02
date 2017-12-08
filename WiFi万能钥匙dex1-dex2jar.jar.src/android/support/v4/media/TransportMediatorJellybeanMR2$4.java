package android.support.v4.media;

import android.media.AudioManager.OnAudioFocusChangeListener;

class TransportMediatorJellybeanMR2$4
  implements AudioManager.OnAudioFocusChangeListener
{
  TransportMediatorJellybeanMR2$4(TransportMediatorJellybeanMR2 paramTransportMediatorJellybeanMR2) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    this.this$0.mTransportCallback.handleAudioFocusChange(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/media/TransportMediatorJellybeanMR2$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */