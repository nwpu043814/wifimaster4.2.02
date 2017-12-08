package com.lantern.browser.comment.ui;

import android.app.Dialog;
import com.lantern.core.p;

final class ap
  implements com.bluefay.b.a
{
  ap(WkCommentSetUserInfoGuideActivity paramWkCommentSetUserInfoGuideActivity, Dialog paramDialog, String paramString) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    WkCommentSetUserInfoGuideActivity.a(this.a);
    if (paramInt == 1)
    {
      com.lantern.analytics.a.e().onEvent("cmtrdmavt");
      p.k(this.c.getApplication(), this.b);
    }
    try
    {
      WkCommentSetUserInfoGuideActivity.b(this.c, this.b);
      WkCommentSetUserInfoGuideActivity.a(this.c, 2, 3);
      for (;;)
      {
        return;
        WkCommentSetUserInfoGuideActivity.a(this.c, 2, 3);
      }
    }
    catch (Throwable paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */