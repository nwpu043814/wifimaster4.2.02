package bluefay.preference;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.widget.SeekBar;

final class w
  extends ContentObserver
{
  w(VolumePreference.a parama, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if ((VolumePreference.a.b(this.a) != null) && (VolumePreference.a.c(this.a) != null))
    {
      int i = VolumePreference.a.c(this.a).getStreamVolume(VolumePreference.a.d(this.a));
      VolumePreference.a.b(this.a).setProgress(i);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */