package com.linksure.apservice.ui.common.search;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class g
  implements AbsListView.OnScrollListener
{
  g(SearchFragment paramSearchFragment) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((SearchFragment.e(this.a).getVisibility() != 0) && (paramInt1 + paramInt2 + 1 == paramInt3)) {
      SearchFragment.a(this.a).c();
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/search/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */