package com.lantern.feed.channel.ui;

import com.bluefay.material.SwipeRefreshLayout.a;
import java.util.HashMap;
import org.json.JSONObject;

final class c
  implements SwipeRefreshLayout.a
{
  c(WkFeedChannelFragment paramWkFeedChannelFragment) {}
  
  public final void a()
  {
    com.lantern.feed.channel.a.a.a().b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("tabId", WkFeedChannelFragment.h(this.a));
    com.lantern.analytics.a.e().onEvent("dhrf", new JSONObject(localHashMap).toString());
  }
  
  public final void b() {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/channel/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */