package com.lantern.browser.comment.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.bluefay.a.e;

final class av
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  av(WkCommentToolBar paramWkCommentToolBar, View paramView) {}
  
  public final void onGlobalLayout()
  {
    try
    {
      int i = WkCommentToolBar.c(this.b).getWidth();
      int j = WkCommentToolBar.d(this.b).getWidth();
      if ((i > 0) && (j > 0))
      {
        ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
        localLayoutParams.width = (i - e.a(WkCommentToolBar.a(this.b), 2.0F) + (j >> 1));
        this.a.setLayoutParams(localLayoutParams);
        WkCommentToolBar.c(this.b).getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */