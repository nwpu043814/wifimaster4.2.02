package com.lantern.browser.comment.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Handler;
import com.lantern.analytics.a;
import com.lantern.core.c;

final class s
  implements DialogInterface.OnClickListener
{
  s(p paramp, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    WkCommentDetailFragment.b(this.b.a, this.a);
    if (WkCommentDetailFragment.m(this.b.a) == null) {
      WkCommentDetailFragment.a(this.b.a, new t(this, new int[] { 128202 }));
    }
    c.addListener(WkCommentDetailFragment.m(this.b.a));
    paramDialogInterface = this.b.a;
    Intent localIntent = new Intent("wifi.intent.action.ADD_ACCOUNT_MAIN");
    localIntent.addFlags(268435456);
    localIntent.setPackage(c.getAppContext().getPackageName());
    localIntent.putExtra("fromSource", "news_comment");
    paramDialogInterface.startActivity(localIntent);
    WkCommentDetailFragment.s(this.b.a).postDelayed(new u(this), 300L);
    a.e().onEvent("cmtskip");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */