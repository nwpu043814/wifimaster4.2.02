package com.lantern.feed.channel.ui;

import android.os.Handler;
import android.os.Message;
import com.lantern.feed.b.g;
import com.lantern.feed.ui.WkFeedUpdateToastView;
import java.util.List;

final class a
  extends Handler
{
  a(WkFeedChannelFragment paramWkFeedChannelFragment) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (!WkFeedChannelFragment.a(this.a)) {}
    for (;;)
    {
      return;
      switch (paramMessage.what)
      {
      case 3: 
      case 4: 
      case 7: 
      case 8: 
      default: 
        break;
      case 2: 
        WkFeedChannelFragment.a(this.a, paramMessage.arg1);
        break;
      case 5: 
        WkFeedChannelFragment.a(this.a, paramMessage.arg1, paramMessage.arg2, (List)paramMessage.obj);
        break;
      case 6: 
        WkFeedChannelFragment.b(this.a).setVisibility(8);
        break;
      case 9: 
        WkFeedChannelFragment.a(this.a, (g)paramMessage.obj);
        break;
      case 10: 
        WkFeedChannelFragment localWkFeedChannelFragment = this.a;
        paramMessage = paramMessage.obj;
        WkFeedChannelFragment.c(localWkFeedChannelFragment);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/channel/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */