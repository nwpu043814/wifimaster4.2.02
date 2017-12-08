package com.lantern.feed.channel.ui;

import android.os.Handler;
import android.os.Message;
import com.lantern.feed.b.g;
import com.lantern.feed.channel.a.a.a;
import java.util.List;

final class d
  implements a.a
{
  d(WkFeedChannelFragment paramWkFeedChannelFragment) {}
  
  public final void a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    WkFeedChannelFragment.i(this.a).sendMessage(localMessage);
  }
  
  public final void a(int paramInt1, int paramInt2, List<g> paramList)
  {
    Message localMessage = new Message();
    localMessage.what = 5;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramList;
    WkFeedChannelFragment.i(this.a).sendMessage(localMessage);
  }
  
  public final void a(g paramg)
  {
    Message localMessage = new Message();
    localMessage.what = 9;
    localMessage.obj = paramg;
    WkFeedChannelFragment.i(this.a).sendMessage(localMessage);
  }
  
  public final void b(g paramg)
  {
    Message localMessage = new Message();
    localMessage.what = 10;
    localMessage.obj = paramg;
    WkFeedChannelFragment.i(this.a).sendMessage(localMessage);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/channel/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */