package com.lantern.download.utils;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ExpandableListView;

final class b
  implements AbsListView.OnScrollListener
{
  b(PinnedExpandableListView paramPinnedExpandableListView) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = this.a.getExpandableListPosition(paramInt1);
    paramInt1 = ExpandableListView.getPackedPositionGroup(l);
    paramInt2 = ExpandableListView.getPackedPositionChild(l);
    this.a.a(paramInt1, paramInt2);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/download/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */