package com.lantern.browser.comment.ui;

import android.widget.ImageView;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.string;
import com.lantern.browser.c.b;
import com.lantern.core.p;

final class as
  implements com.bluefay.b.a
{
  as(ar paramar, String paramString) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    WkCommentSetUserInfoGuideActivity.a(this.b.a);
    if (paramInt == 1)
    {
      b.a(this.b.d.getApplication(), R.drawable.comment_sent_succes, R.string.comment_guide_upload_success);
      p.k(this.b.d.getApplication(), this.a);
    }
    try
    {
      this.b.d.getApplication();
      paramString = com.lantern.browser.comment.f.a.a(this.b.b);
      WkCommentSetUserInfoGuideActivity.n(this.b.d).setImageBitmap(paramString);
      WkCommentSetUserInfoGuideActivity.o(this.b.d).setImageBitmap(paramString);
      if (this.b.c == 1000) {
        WkCommentSetUserInfoGuideActivity.a(this.b.d, 2, 3);
      }
      for (;;)
      {
        return;
        b.a(this.b.d.getApplication(), R.drawable.comment_sent_fail, R.string.comment_guide_upload_failed);
      }
    }
    catch (Throwable paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */