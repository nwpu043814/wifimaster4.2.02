package com.lantern.browser.comment.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.lantern.browser.comment.e.a;
import com.lantern.browser.comment.e.c;

final class aq
  implements DialogInterface.OnDismissListener
{
  aq(WkCommentSetUserInfoGuideActivity paramWkCommentSetUserInfoGuideActivity) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (WkCommentSetUserInfoGuideActivity.u(this.a) != null) {
      WkCommentSetUserInfoGuideActivity.u(this.a).cancel(true);
    }
    if (WkCommentSetUserInfoGuideActivity.t(this.a) != null) {
      WkCommentSetUserInfoGuideActivity.t(this.a).cancel(true);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */