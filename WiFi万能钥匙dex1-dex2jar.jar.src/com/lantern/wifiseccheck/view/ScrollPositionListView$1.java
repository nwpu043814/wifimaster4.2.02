package com.lantern.wifiseccheck.view;

import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.lantern.wifiseccheck.LogUtils;

class ScrollPositionListView$1
  implements AbsListView.OnScrollListener
{
  ScrollPositionListView$1(ScrollPositionListView paramScrollPositionListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.this$0.mCurrentfirstVisibleItem = paramInt1;
    View localView = paramAbsListView.getChildAt(0);
    if (localView != null)
    {
      ScrollPositionListView.ItemRecod localItemRecod = (ScrollPositionListView.ItemRecod)this.this$0.recordSp.get(paramInt1);
      paramAbsListView = localItemRecod;
      if (localItemRecod == null) {
        paramAbsListView = new ScrollPositionListView.ItemRecod(this.this$0);
      }
      paramAbsListView.height = localView.getHeight();
      paramAbsListView.top = localView.getTop();
      this.this$0.recordSp.append(paramInt1, paramAbsListView);
    }
    LogUtils.d("ScrollPositionListView", "get list view scroll y" + ScrollPositionListView.access$000(this.this$0));
    if (ScrollPositionListView.access$100(this.this$0) != null) {
      ScrollPositionListView.access$100(this.this$0).onScrollY(ScrollPositionListView.access$000(this.this$0));
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/view/ScrollPositionListView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */