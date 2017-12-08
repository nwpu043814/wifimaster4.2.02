package com.lantern.feed.a;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Surface;
import com.bluefay.b.h;
import com.lantern.core.c;

final class ab
  implements Handler.Callback
{
  ab(z paramz) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      try
      {
        z.b(this.a);
        z.c(this.a);
        if (z.a(this.a) != null) {
          z.a(this.a).release();
        }
        Object localObject = this.a;
        paramMessage = new android/media/MediaPlayer;
        paramMessage.<init>();
        z.a((z)localObject, paramMessage);
        z.a(this.a).setAudioStreamType(3);
        z.a(this.a).setDataSource(c.getAppContext(), Uri.parse(z.d(this.a)));
        z.a(this.a).setOnPreparedListener(this.a);
        z.a(this.a).setOnCompletionListener(this.a);
        z.a(this.a).setOnBufferingUpdateListener(this.a);
        z.a(this.a).setOnSeekCompleteListener(this.a);
        z.a(this.a).setOnErrorListener(this.a);
        z.a(this.a).setOnInfoListener(this.a);
        z.a(this.a).setOnVideoSizeChangedListener(this.a);
        z.a(this.a).prepareAsync();
        paramMessage = z.a(this.a);
        localObject = new android/view/Surface;
        ((Surface)localObject).<init>(z.e(this.a));
        paramMessage.setSurface((Surface)localObject);
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        this.a.onError(z.a(this.a), -1, 0);
      }
      continue;
      h.a("release", new Object[0]);
      if (z.a(this.a) != null) {
        try
        {
          z.a(this.a).release();
          z.a(this.a, null);
          h.a("release mediaplayer", new Object[0]);
        }
        catch (IllegalStateException paramMessage)
        {
          for (;;)
          {
            h.a(paramMessage);
          }
        }
      } else {
        h.a("release no mediaplayer", new Object[0]);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */