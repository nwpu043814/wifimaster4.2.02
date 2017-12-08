package com.lantern.browser.comment.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import com.lantern.browser.R.string;
import com.lantern.browser.comment.d.g;
import com.lantern.browser.comment.ui.a.a;

final class m
  implements AbsListView.OnScrollListener
{
  m(WkCommentDetailFragment paramWkCommentDetailFragment) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > 0)
    {
      paramInt2 = WkCommentDetailFragment.d(this.a).getChildAt(0).getTop();
      paramAbsListView = null;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label85;
      }
      paramAbsListView = this.a.getString(R.string.comment_text);
    }
    for (;;)
    {
      if ((paramAbsListView != null) && (!paramAbsListView.equals(WkCommentDetailFragment.h(this.a))))
      {
        WkCommentDetailFragment.a(this.a, paramAbsListView);
        WkCommentDetailFragment.i(this.a).setText(WkCommentDetailFragment.h(this.a));
      }
      return;
      label85:
      g localg = WkCommentDetailFragment.g(this.a).a();
      if ((localg.d() != -1) && (paramInt1 >= localg.d()) && (paramInt1 < localg.f())) {
        paramAbsListView = this.a.getString(R.string.comment_replyme);
      } else if ((paramInt1 >= localg.f()) && (paramInt1 < localg.e())) {
        paramAbsListView = this.a.getString(R.string.comment_hot);
      } else if (paramInt1 >= localg.e()) {
        paramAbsListView = this.a.getString(R.string.comment_new);
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */