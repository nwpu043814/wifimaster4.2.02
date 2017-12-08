package com.lantern.browser.comment.ui;

import android.widget.TextView;
import bluefay.app.k.a;
import com.bluefay.a.e;
import com.lantern.analytics.a;
import com.lantern.browser.R.string;
import com.lantern.browser.comment.b.b.a;
import com.lantern.browser.comment.f.b;
import com.lantern.core.c;
import com.lantern.core.o;

final class p
  implements b.a
{
  p(WkCommentDetailFragment paramWkCommentDetailFragment) {}
  
  public final void a() {}
  
  public final void a(String paramString)
  {
    if (c.getServer().j())
    {
      b.a().a(WkCommentDetailFragment.n(this.a), new q(this, paramString));
      a.e().onEvent("cmtsubmit");
    }
    for (;;)
    {
      return;
      k.a locala = new k.a(WkCommentDetailFragment.o(this.a));
      TextView localTextView = new TextView(WkCommentDetailFragment.p(this.a));
      localTextView.setTextSize(16.0F);
      localTextView.setTextColor(-11711155);
      localTextView.setGravity(17);
      localTextView.setText(R.string.comment_dialog_message);
      int i = e.a(WkCommentDetailFragment.q(this.a), 20.0F);
      localTextView.setPadding(i, i, i, i);
      locala.a(localTextView);
      locala.b(R.string.comment_dialog_cancel, new r(this));
      locala.a(R.string.comment_dialog_login, new s(this, paramString));
      locala.a(new v(this));
      locala.d();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */