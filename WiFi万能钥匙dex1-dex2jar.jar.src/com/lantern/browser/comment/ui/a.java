package com.lantern.browser.comment.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;

final class a
  implements AbsListView.OnScrollListener
{
  a(PinnedSectionListView paramPinnedSectionListView) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null) {
      this.a.a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    paramAbsListView = this.a.getAdapter();
    if ((paramAbsListView == null) || (paramInt2 == 0)) {}
    for (;;)
    {
      return;
      if (PinnedSectionListView.a(paramAbsListView, paramAbsListView.getItemViewType(paramInt1)))
      {
        if (this.a.getChildAt(0).getTop() != this.a.getPaddingTop()) {
          this.a.a(paramInt1, paramInt1, paramInt2);
        }
      }
      else
      {
        paramInt3 = this.a.a(paramInt1);
        if (paramInt3 >= 0)
        {
          this.a.a(paramInt3, paramInt1, paramInt2);
          continue;
        }
      }
      this.a.b();
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */