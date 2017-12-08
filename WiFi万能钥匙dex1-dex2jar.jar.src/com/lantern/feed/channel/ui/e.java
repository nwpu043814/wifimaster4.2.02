package com.lantern.feed.channel.ui;

import com.bluefay.material.SwipeRefreshLayout;
import com.lantern.feed.ui.WkFeedTabLabel.a;
import java.util.HashMap;
import org.json.JSONObject;

final class e
  implements WkFeedTabLabel.a
{
  e(WkFeedChannelFragment paramWkFeedChannelFragment) {}
  
  public final void a(int paramInt)
  {
    if (paramInt == WkFeedChannelFragment.j(this.a)) {
      if (!WkFeedChannelFragment.k(this.a).a())
      {
        com.lantern.feed.channel.a.a.a().b();
        HashMap localHashMap = new HashMap();
        localHashMap.put("tabId", WkFeedChannelFragment.h(this.a));
        com.lantern.analytics.a.e().onEvent("dhlcli", new JSONObject(localHashMap).toString());
      }
    }
    for (;;)
    {
      return;
      WkFeedChannelFragment.l(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/channel/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */