package com.linksure.apservice.ui.category.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;

final class a
  implements AbsListView.OnScrollListener
{
  a(ApsListView paramApsListView) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((!ApsListView.a(this.a)) && (ApsListView.b(this.a)) && (this.a.getLastVisiblePosition() == this.a.getAdapter().getCount() - 1) && ((paramInt == 2) || (paramInt == 0)))
    {
      this.a.a();
      if (ApsListView.c(this.a) != null) {
        ApsListView.c(this.a).d();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */