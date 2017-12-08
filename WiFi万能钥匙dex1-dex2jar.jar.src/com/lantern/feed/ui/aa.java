package com.lantern.feed.ui;

import android.view.View;
import android.widget.AbsListView.RecyclerListener;

final class aa
  implements AbsListView.RecyclerListener
{
  aa(WkFeedListView paramWkFeedListView) {}
  
  public final void onMovedToScrapHeap(View paramView)
  {
    if ((paramView instanceof a)) {
      ((a)paramView).d();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */