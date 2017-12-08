package com.lantern.browser.comment.ui;

import android.app.Dialog;
import android.widget.TextView;
import com.bluefay.b.a;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.string;
import com.lantern.browser.c.b;
import com.lantern.core.p;

final class an
  implements a
{
  an(WkCommentSetUserInfoGuideActivity paramWkCommentSetUserInfoGuideActivity, Dialog paramDialog, String paramString) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    WkCommentSetUserInfoGuideActivity.a(this.a);
    if (paramInt == 1)
    {
      b.a(this.c.getApplication(), R.drawable.comment_sent_succes, R.string.comment_guide_update_nickname_success);
      p.i(this.c.getApplication(), this.b);
      WkCommentSetUserInfoGuideActivity.s(this.c).setText(this.b);
      if (WkCommentSetUserInfoGuideActivity.i(this.c)) {
        WkCommentSetUserInfoGuideActivity.a(this.c, 1, 3);
      }
    }
    for (;;)
    {
      return;
      WkCommentSetUserInfoGuideActivity.a(this.c, 1, 2);
      continue;
      b.a(this.c.getApplication(), R.drawable.comment_sent_fail, R.string.comment_guide_update_nickname_failed);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */