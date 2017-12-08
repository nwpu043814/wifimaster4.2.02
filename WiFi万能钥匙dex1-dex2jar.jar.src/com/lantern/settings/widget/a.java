package com.lantern.settings.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class a
  implements AbsListView.OnScrollListener
{
  a(PinnedHeaderListView paramPinnedHeaderListView) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAbsListView instanceof PinnedHeaderListView)) {
      ((PinnedHeaderListView)paramAbsListView).a();
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */