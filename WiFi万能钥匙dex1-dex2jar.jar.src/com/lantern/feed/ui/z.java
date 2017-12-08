package com.lantern.feed.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class z
  implements AbsListView.OnScrollListener
{
  z(WkFeedListView paramWkFeedListView) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    WkFeedListView.a(this.a);
    if ((WkFeedListView.b(this.a) == 2) || (WkFeedListView.b(this.a) == 1)) {
      WkFeedListView.c(this.a);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    WkFeedListView.a(this.a, paramInt);
    WkFeedListView.a(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */