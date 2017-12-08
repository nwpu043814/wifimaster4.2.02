package com.lantern.browser.comment.ui;

import android.app.Dialog;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.string;
import com.lantern.browser.c.b;

final class ar
  implements com.bluefay.b.a
{
  ar(WkCommentSetUserInfoGuideActivity paramWkCommentSetUserInfoGuideActivity, Dialog paramDialog, String paramString, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramString = String.valueOf(paramObject);
      WkCommentSetUserInfoGuideActivity.a(this.d, new com.lantern.browser.comment.e.a(paramString, new as(this, paramString)));
      WkCommentSetUserInfoGuideActivity.t(this.d).execute(new Void[0]);
    }
    for (;;)
    {
      return;
      WkCommentSetUserInfoGuideActivity.a(this.a);
      b.a(this.d.getApplication(), R.drawable.comment_sent_fail, R.string.comment_guide_upload_failed);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */