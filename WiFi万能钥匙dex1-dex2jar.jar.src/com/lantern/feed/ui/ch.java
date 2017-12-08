package com.lantern.feed.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ch
  implements DialogInterface.OnClickListener
{
  ch(WkFeedVideoPlayer paramWkFeedVideoPlayer) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    WkFeedVideoPlayer.a(this.a, false);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */