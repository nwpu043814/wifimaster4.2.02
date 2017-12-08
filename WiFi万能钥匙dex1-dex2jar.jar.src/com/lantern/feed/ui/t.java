package com.lantern.feed.ui;

import com.bluefay.material.SwipeRefreshLayout;
import com.lantern.analytics.a;
import com.lantern.feed.a.m;

final class t
  implements WkFeedTabLabel.a
{
  t(WkFeedFragment paramWkFeedFragment) {}
  
  public final void a(int paramInt)
  {
    if ((paramInt == 0) && (!WkFeedFragment.j(this.a).a()))
    {
      m.a().g();
      a.e().onEvent("dhlcli");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */