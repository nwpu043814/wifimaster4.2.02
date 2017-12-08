package com.lantern.browser.comment.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.lantern.browser.comment.e.a;

final class ao
  implements DialogInterface.OnDismissListener
{
  ao(WkCommentSetUserInfoGuideActivity paramWkCommentSetUserInfoGuideActivity) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (WkCommentSetUserInfoGuideActivity.t(this.a) != null) {
      WkCommentSetUserInfoGuideActivity.t(this.a).cancel(true);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */