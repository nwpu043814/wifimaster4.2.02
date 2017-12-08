package com.lantern.feed.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ci
  implements DialogInterface.OnClickListener
{
  ci(WkFeedVideoPlayer paramWkFeedVideoPlayer) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    WkFeedVideoPlayer.a(this.a, true);
    WkFeedVideoPlayer.i(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */