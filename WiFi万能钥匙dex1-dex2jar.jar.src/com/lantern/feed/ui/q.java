package com.lantern.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.lantern.feed.a.m;

final class q
  implements View.OnClickListener
{
  q(WkFeedFragment paramWkFeedFragment) {}
  
  public final void onClick(View paramView)
  {
    WkFeedFragment.f(this.a);
    WkFeedFragment.g(this.a).setVisibility(0);
    WkFeedFragment.i(this.a).startAnimation(WkFeedFragment.h(this.a));
    m.a().e();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */