package com.lantern.browser.comment.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.lantern.browser.comment.e.b;

final class am
  implements DialogInterface.OnDismissListener
{
  am(WkCommentSetUserInfoGuideActivity paramWkCommentSetUserInfoGuideActivity) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (WkCommentSetUserInfoGuideActivity.r(this.a) != null) {
      WkCommentSetUserInfoGuideActivity.r(this.a).cancel(true);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */