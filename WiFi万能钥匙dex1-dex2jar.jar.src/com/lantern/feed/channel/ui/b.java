package com.lantern.feed.channel.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.lantern.feed.channel.a.a;

final class b
  implements View.OnClickListener
{
  b(WkFeedChannelFragment paramWkFeedChannelFragment) {}
  
  public final void onClick(View paramView)
  {
    WkFeedChannelFragment.d(this.a);
    WkFeedChannelFragment.e(this.a).setVisibility(0);
    WkFeedChannelFragment.g(this.a).startAnimation(WkFeedChannelFragment.f(this.a));
    a.a().b(WkFeedChannelFragment.h(this.a));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/channel/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */