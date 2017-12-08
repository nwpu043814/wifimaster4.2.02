package com.lantern.feed.ui;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

final class cf
  implements Handler.Callback
{
  cf(WkFeedVideoPlayer paramWkFeedVideoPlayer) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((WkFeedVideoPlayer.a(this.a) != 4) && (WkFeedVideoPlayer.a(this.a) != 5))
      {
        WkFeedVideoPlayer.b(this.a).setVisibility(4);
        WkFeedVideoPlayer.c(this.a).setVisibility(0);
        WkFeedVideoPlayer.d(this.a);
        WkFeedVideoPlayer.e(this.a).setVisibility(4);
        continue;
        WkFeedVideoPlayer.f(this.a).sendEmptyMessageDelayed(2, 300L);
        WkFeedVideoPlayer.g(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */