package com.linksure.apservice.ui.home.list;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.lantern.core.imageloader.a.aa;

final class e
  implements AbsListView.OnScrollListener
{
  e(MessageListFragment paramMessageListFragment) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    MessageListFragment.a(this.a).a(paramInt1 + paramInt2);
    if ((paramInt1 == 0) && (paramInt3 > 1)) {
      MessageListFragment.a(this.a).d();
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 2) {
      MessageListFragment.j().a(MessageListFragment.i());
    }
    for (;;)
    {
      return;
      MessageListFragment.j().b(MessageListFragment.i());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/list/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */