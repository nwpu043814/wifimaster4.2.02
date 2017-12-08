package com.lantern.browser.comment.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.lantern.core.c;

final class o
  implements DialogInterface.OnDismissListener
{
  o(WkCommentDetailFragment paramWkCommentDetailFragment) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (WkCommentDetailFragment.m(this.a) != null) {
      c.removeListener(WkCommentDetailFragment.m(this.a));
    }
    WkCommentDetailFragment.b(this.a, null);
    WkCommentDetailFragment.a(this.a, null);
    WkCommentDetailFragment.a(this.a, -1);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */